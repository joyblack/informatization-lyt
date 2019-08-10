package com.xxfy.informatizationlyt.user.service;

import com.xxfy.informatizationlyt.common.exception.JoyException;
import com.xxfy.informatizationlyt.common.result.JoyResult;
import com.xxfy.informatizationlyt.user.domain.entity.UserEntity;
import com.xxfy.informatizationlyt.user.domain.repository.UserRepository;
import com.xxfy.informatizationlyt.utils.MD5Util;
import com.xxfy.informatizationlyt.utils.StringUtil;
import com.xxfy.informatizationlyt.utils.identity.IdNumberUtil;
import com.xxfy.informatizationlyt.utils.jwt.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public JoyResult register(UserEntity userEntity) {
        if (null == userEntity.getId()) {
            userEntity.setId(0L);
        } else {
            throw new JoyException("无效注册操作");
        }
        /**
         * 检测密码是否一致
         */
        if(!StringUtil.equals(userEntity.getPassword(),userEntity.getAffirmPassword())){
            throw new JoyException("密码输入不一致");
        }

        /**
         * 校验： 身份证号、手机号、登录名
         */
        if(!IdNumberUtil.isIDNumber(userEntity.getIdNumber())){
            throw new JoyException("身份证号错误");
        }
        UserEntity checkUser = userRepository.findAllByIdNumberAndIdNot(userEntity.getIdNumber(),userEntity.getId());
        if(null != checkUser){
            throw new JoyException("身份证号已注册");
        }
        checkUser = userRepository.findAllByPhoneAndIdNot(userEntity.getPhone(), userEntity.getId());
        if(null != checkUser){
            throw new JoyException("该手机号已被注册");
        }
        checkUser = userRepository.findAllByLoginNameAndIdNot(userEntity.getLoginName(), userEntity.getId());
        if(null != checkUser){
            throw new JoyException("账户名已被注册");
        }
        // 密码
        userEntity.setPassword(MD5Util.encode(userEntity.getPassword()));
        // 保存数据
        UserEntity saveResult = userRepository.save(userEntity);
        // 置空密码返回到客户端
        saveResult.setPassword(null);
        return JoyResult.buildSuccessResultWithData(saveResult);
    }


}

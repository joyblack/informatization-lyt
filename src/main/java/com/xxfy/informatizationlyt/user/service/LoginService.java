package com.xxfy.informatizationlyt.user.service;

import com.xxfy.informatizationlyt.common.result.JoyResult;
import com.xxfy.informatizationlyt.config.JwtParamConfig;
import com.xxfy.informatizationlyt.user.domain.entity.UserEntity;
import com.xxfy.informatizationlyt.user.domain.repository.UserRepository;
import com.xxfy.informatizationlyt.user.web.request.LoginRequest;
import com.xxfy.informatizationlyt.utils.MD5Util;
import com.xxfy.informatizationlyt.utils.StringUtil;
import com.xxfy.informatizationlyt.utils.jwt.JwtUtil;
import com.xxfy.informatizationlyt.utils.jwt.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtParamConfig jwtParamConfig;

    public JoyResult login(LoginRequest loginReq) {
        if (StringUtil.isEmpty(loginReq.getLoginName())) {
            return JoyResult.buildFailedResult("用户名不能为空");
        }
        if (StringUtil.isEmpty(loginReq.getPassword())) {
            return JoyResult.buildFailedResult("密码不能为空");
        }

        String md5Password = MD5Util.encode(loginReq.getPassword());

        // 先用电话号码查询
        UserEntity user = userRepository.getAllByPhoneAndPassword(loginReq.getLoginName(), md5Password);

        if(user == null){
            user = userRepository.getAllByLoginNameAndPassword(loginReq.getLoginName(), md5Password);
        }

        if(user == null){
            user = userRepository.getAllByIdNumberAndPassword(loginReq.getLoginName(), md5Password);
        }
        if(user != null){
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put(Token.USER.getName(), user);
            return JoyResult.buildSuccessResultWithData(JwtUtil.createJWT(claims, jwtParamConfig));
        }else{
            return JoyResult.buildFailedResult("登录名/手机号/身份证/与密码不匹配");
        }
    }


}

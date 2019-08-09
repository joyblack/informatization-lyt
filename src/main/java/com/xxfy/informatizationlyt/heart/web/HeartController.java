package com.xxfy.informatizationlyt.heart.web;

import com.xxfy.informatizationlyt.common.constant.SystemConstant;
import com.xxfy.informatizationlyt.common.result.JoyResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(SystemConstant.API_VERSION + "heart")
public class HeartController {
    /**
     * 测试心跳
     */
    @RequestMapping(value = {"ping"})
    public JoyResult ping(HttpServletRequest request){
        return JoyResult.buildSuccessResult("pong!");
    }

}
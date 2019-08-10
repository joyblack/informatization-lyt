package com.xxfy.informatizationlyt.user.web;

import com.xxfy.informatizationlyt.common.result.JoyResult;
import com.xxfy.informatizationlyt.user.service.LoginService;
import com.xxfy.informatizationlyt.user.web.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录名及密码登陆
     */
    @PostMapping(
            value = "/login",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult login(@RequestBody LoginRequest loginReq) {
        return loginService.login(loginReq);
    }

//    @PostMapping(
//            value = "/sendNote",
//            produces = {"application/json;charset=UTF-8"})
//    public JoyResult sendNote(@RequestBody LoginRequest loginReq) {
//        return loginService.sendLoginNote(loginReq);
//    }
//
//    @PostMapping(
//            value = "/loginByPhone",
//            produces = {"application/json;charset=UTF-8"})
//    public JoyResult loginByPhone(@RequestBody LoginRequest loginReq) {
//        return loginService.loginByPhone(loginReq);
//    }


}

package com.xxfy.informatizationlyt.user.web;

import com.xxfy.informatizationlyt.common.result.JoyResult;
import com.xxfy.informatizationlyt.user.domain.entity.UserEntity;
import com.xxfy.informatizationlyt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param bindingResult
     * @return
     */
    @PostMapping(
            value = "/register",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult register(@RequestBody @Valid UserEntity userEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return userService.register(userEntity);
        }
    }



}

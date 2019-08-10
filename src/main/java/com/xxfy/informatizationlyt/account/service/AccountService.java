package com.xxfy.informatizationlyt.account.service;

import com.xxfy.informatizationlyt.common.result.JoyResult;
import com.xxfy.informatizationlyt.utils.jwt.TokenUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AccountService {
    public JoyResult getMyInformation(HttpServletRequest request) {
        return JoyResult.buildSuccessResultWithData(TokenUtil.getUser(request));
    }
}

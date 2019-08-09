package com.xxfy.informatizationlyt.index.web;

import com.xxfy.informatizationlyt.common.constant.SystemConstant;
import com.xxfy.informatizationlyt.common.result.JoyResult;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(SystemConstant.API_VERSION + "index")
public class IndexController {
    @RequestMapping("/")
    public JoyResult index(){
        return JoyResult.buildSuccessResult("感谢您访问信息化平台服务...");
    }
}

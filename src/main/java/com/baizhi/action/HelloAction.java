package com.baizhi.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//小邹修改一次


//小勇煞笔乱改我代码
@Controller
@RequestMapping("/first")
public class HelloAction {

    @RequestMapping("/boot")
    public String boot() throws Exception{
        System.out.println("Hell SpringBoot");
        return "index";
    }
}

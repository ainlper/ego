package com.ego.controller;

import com.ego.commons.pojo.EgoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/")
    public String login() {
        return "login";
    }


    @RequestMapping("/main")
    public String showIndex() {
        return "index";
    }


    @RequestMapping("/loginSuccess")
    @ResponseBody
    public EgoResult loginSuccess() {
        return EgoResult.ok();
    }


    /**
     * 实现Restful的控制器
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}

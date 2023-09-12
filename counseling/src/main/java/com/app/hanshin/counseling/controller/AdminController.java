package com.app.hanshin.counseling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @GetMapping(value = {"", "/"})
    public String goToAdminPage(){
        return "/admin/index";

    }
    @GetMapping("/check")
    public RedirectView checkAuth(String auth){
        return new RedirectView(auth.equals("201521017") ? "/admin/board" : "/admin");
    }

    @GetMapping("/board")
    public void goToBoard(){;}
}

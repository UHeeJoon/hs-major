package com.app.hanshin.counseling.controller;


import com.app.hanshin.counseling.vo.member.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("")
    public String goToLogIn(Model model){
        return "login/login";
    }

    @PostMapping("")
    public RedirectView goToApplicant(HttpSession session, MemberDTO memberDTO, Long majorFieldId){
        session.setAttribute("majorFieldId", majorFieldId);
        session.setAttribute("id", memberDTO.getId());
        session.setAttribute("memberName", memberDTO.getMemberName());
        session.setAttribute("studentId", memberDTO.getStudentId());
        return new RedirectView("/applicant");
    }


}

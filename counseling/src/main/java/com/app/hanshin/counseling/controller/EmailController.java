package com.app.hanshin.counseling.controller;

import com.app.hanshin.counseling.service.email.EmailService;
import com.app.hanshin.counseling.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


@RestController
@RequiredArgsConstructor
public class EmailController {

    final private EmailService emailService;

    @RequestMapping(value = "/send-auth-email", method = RequestMethod.POST)
    public Object sendMessage(@RequestBody HashMap<String, Object> studentId, HttpServletResponse servletResponse){
        return emailService.sendAuthNum((String) studentId.get("studentId"), servletResponse);
    }

}

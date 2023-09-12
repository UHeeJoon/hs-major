package com.app.hanshin.counseling.service.email;

import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.member.MemberStateDTO;

import javax.servlet.http.HttpServletResponse;

public interface EmailService {
    public MemberStateDTO sendAuthNum(String studentId, HttpServletResponse httpServletResponse);
}

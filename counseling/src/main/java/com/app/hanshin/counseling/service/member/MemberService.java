package com.app.hanshin.counseling.service.member;

import com.app.hanshin.counseling.vo.member.MemberDTO;

import java.util.Optional;

public interface MemberService {
    public Optional<MemberDTO> getEmailName(String studentId);
}

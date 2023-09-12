package com.app.hanshin.counseling.service.member;

import com.app.hanshin.counseling.dao.member.MemberDAO;
import com.app.hanshin.counseling.vo.member.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    final private MemberDAO memberDAO;

    @Override
    public Optional<MemberDTO> getEmailName(String studentId) {
        return memberDAO.findStudentIdMemberNameMemberEmailByStudentId(studentId);
    }
}

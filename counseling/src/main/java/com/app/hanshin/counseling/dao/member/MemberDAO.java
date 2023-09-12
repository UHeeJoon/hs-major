package com.app.hanshin.counseling.dao.member;

import com.app.hanshin.counseling.mapper.member.MemberMapper;
import com.app.hanshin.counseling.vo.member.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    final private MemberMapper memberMapper;

    public Optional<MemberDTO> findStudentIdMemberNameMemberEmailByStudentId(String studentId){
        return Optional.ofNullable(memberMapper.selectEmail(studentId));
    }

}

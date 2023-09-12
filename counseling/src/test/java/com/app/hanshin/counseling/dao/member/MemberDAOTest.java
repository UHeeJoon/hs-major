package com.app.hanshin.counseling.dao.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.hanshin.counseling.vo.member.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberDAOTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void findStudentIdMemberNameMemberEmailByStudentIdTest(){
        String studentId = "201955067";
        assertThat(
            memberDAO.findStudentIdMemberNameMemberEmailByStudentId(studentId).orElse(MemberDTO.builder().build()).getMemberName()
        ).isEqualTo("유희준");
    }
}

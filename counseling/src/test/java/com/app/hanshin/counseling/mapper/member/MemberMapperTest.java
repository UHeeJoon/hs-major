package com.app.hanshin.counseling.mapper.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.hanshin.counseling.vo.member.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void selectEmailTest(){
        String studentId = "kimnodong123";
        assertThat(
                memberMapper.selectEmail(studentId).getMemberName()
        ).isEqualTo("이수인");
    }

}

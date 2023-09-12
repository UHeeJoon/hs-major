package com.app.hanshin.counseling.service.member;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void getEmailNameTest(){
        String studentId = "kimnodong123";
        assertThat(
                memberService.getEmailName(studentId).get().getMemberName()
        ).isEqualTo("이수인");
    }

}

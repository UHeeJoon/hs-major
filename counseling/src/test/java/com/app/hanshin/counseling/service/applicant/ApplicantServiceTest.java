package com.app.hanshin.counseling.service.applicant;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.hanshin.counseling.vo.applicant.ApplicantDTO;
import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ApplicantServiceTest {

    @Autowired
    private ApplicantService applicantService;

    @Test
    public void getMajorsTest(){
        assertThat(
            applicantService.getMajors(1L).get(0).getMajor()
        ).isEqualTo("신학");
    }

    @Test
    public void getApplicantTest(){
        ApplicantDateMajor dateMajor = ApplicantDateMajor.builder()
                .majorId(23L)
                .applicantDate("9/19")
                .build();
        applicantService.getApplicant(dateMajor).stream().map(ApplicantDTO::toString).forEach(log::info);
    }

}

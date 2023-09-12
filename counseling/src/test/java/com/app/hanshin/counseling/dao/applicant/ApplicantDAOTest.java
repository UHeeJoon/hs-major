package com.app.hanshin.counseling.dao.applicant;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.hanshin.counseling.vo.applicant.ApplicantDTO;
import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ApplicantDAOTest {

    @Autowired
    private ApplicantDAO applicantDAO;

    @Test
    public void findAllByMajorFieldTest(){
        assertThat(
            applicantDAO.findAllByMajorField(1L).get(0).getMajor()
        ).isEqualTo("신학");
    }

    @Test
    public void findAllByApplicantDateAndMajorIdTest(){
        ApplicantDateMajor dateMajor = ApplicantDateMajor.builder()
                .majorId(23L)
                .applicantDate("9/19")
                .build();
        applicantDAO.findAllByApplicantDateAndMajorId(dateMajor).stream().map(ApplicantDTO::toString).forEach(log::info);
    }

}

package com.app.hanshin.counseling.mapper.applicant;

import com.app.hanshin.counseling.vo.applicant.ApplicantDTO;
import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ApplicantMapperTest {

    @Autowired
    private ApplicantMapper applicantMapper;

    @Test
    public void selectAllTest(){
        log.info("........................." + applicantMapper.selectAll(1L));
    }

    @Test
    public void selectTest(){
        ApplicantDateMajor dateMajor = ApplicantDateMajor.builder()
                .majorId(23L)
                .applicantDate("9/19")
                .build();
        applicantMapper.select(dateMajor).stream().map(ApplicantDTO::toString).forEach(log::info);
    }

}

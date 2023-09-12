package com.app.hanshin.counseling.service.applicant;

import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MemberApplicantListServiceTest {

    @Autowired
    private MemberApplicantListService memberApplicantListService;

    @Test
    public void applicantTest(){

        MemberApplicantListDTO listDTO = MemberApplicantListDTO.builder()
                .memberId(1110L)
                .applicantId(1L)
                .build();
        assertThat(
            memberApplicantListService.applicant(listDTO)
        ).isEqualTo(StateEnum.FAIL);
    }
}

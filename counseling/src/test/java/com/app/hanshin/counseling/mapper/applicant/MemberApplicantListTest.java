package com.app.hanshin.counseling.mapper.applicant;

import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import static org.assertj.core.api.Assertions.assertThat;

import com.app.hanshin.counseling.vo.applicant.MyApplicantListDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberApplicantListTest {

    @Autowired
    private MemberApplicantListMapper memberApplicantListMapper;

    @Test
    public void insertTest(){
        MemberApplicantListDTO listDTO = MemberApplicantListDTO.builder()
                .memberId(1110L)
                .applicantId(1L)
                .build();
        assertThat(
            memberApplicantListMapper.insert(listDTO)
        ).isEqualTo(1);
    }

    @Test
    public void selectMineTest(){
        memberApplicantListMapper.selectMine(1110L).stream().map(MyApplicantListDTO::toString).forEach(log::info);
    }

}

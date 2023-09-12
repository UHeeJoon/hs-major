package com.app.hanshin.counseling.dao.applicant;

import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberApplicantListDAOTest {

    @Autowired
    private MemberApplicantListDAO memberApplicantListDAO;

    @Test
    public void saveTest(){
        MemberApplicantListDTO memberApplicantListDTO = MemberApplicantListDTO.builder()
                .memberId(1110L)
                .applicantId(1L)
                .build();
        assertThat(
            memberApplicantListDAO.save(memberApplicantListDTO)
        ).isEqualTo(StateEnum.SUCCESS);
    }

}

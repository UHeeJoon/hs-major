package com.app.hanshin.counseling.vo.member;

import com.app.hanshin.counseling.vo.applicant.MemberApplicantListVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class MemberApplicantDTO {
    private Long id;
    private String studentId;
    private String memberName;
    private String memberEmail;
    private String memberMajor;
    private String number_of_applicant;

}

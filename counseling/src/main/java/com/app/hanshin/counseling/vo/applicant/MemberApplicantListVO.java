package com.app.hanshin.counseling.vo.applicant;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class MemberApplicantListVO {
    private Long id;
    private Long memberId;
    private Long applicantId;
}

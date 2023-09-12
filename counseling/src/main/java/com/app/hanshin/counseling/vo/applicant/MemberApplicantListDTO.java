package com.app.hanshin.counseling.vo.applicant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component @Data
@NoArgsConstructor
public class MemberApplicantListDTO {
    private Long memberId;
    private Long applicantId;

    @Builder
    public MemberApplicantListDTO(Long memberId, Long applicantId) {
        this.memberId = memberId;
        this.applicantId = applicantId;
    }
}

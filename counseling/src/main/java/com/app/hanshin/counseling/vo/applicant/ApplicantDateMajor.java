package com.app.hanshin.counseling.vo.applicant;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@NoArgsConstructor
public class ApplicantDateMajor {
    private Long majorId;
    private String applicantDate;

    @Builder
    public ApplicantDateMajor(Long majorId, String applicantDate) {
        this.majorId = majorId;
        this.applicantDate = applicantDate;
    }
}

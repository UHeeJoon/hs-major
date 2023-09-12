package com.app.hanshin.counseling.vo.applicant;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class MyApplicantListDTO {
    private Long applicantId;
    private Long professorId;
    private Long timeId;
    private String applicantDate;
}

package com.app.hanshin.counseling.vo.applicant;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ApplicantVO {
    private Long id;
    private Long timeId;
    private Long professorId;
    private Integer numberOfApplicant;
    private String applicantDate;
}

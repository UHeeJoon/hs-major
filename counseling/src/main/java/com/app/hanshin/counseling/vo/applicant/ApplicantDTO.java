package com.app.hanshin.counseling.vo.applicant;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component @Data
@NoArgsConstructor
public class ApplicantDTO {
    private Long id;
    private String professorName;
    private Long professorId;
    private String timeStart;
    private String timeEnd;
    private Long timeId;
    private String numberOfApplicant;
}

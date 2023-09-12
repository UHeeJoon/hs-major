package com.app.hanshin.counseling.vo.professor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProfessorVO {
    private Long id;
    private Long majorId;
    private String professorName;
}

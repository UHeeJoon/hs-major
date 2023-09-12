package com.app.hanshin.counseling.vo.major;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MajorFieldVO {
    private Long id;
    private String field;
}

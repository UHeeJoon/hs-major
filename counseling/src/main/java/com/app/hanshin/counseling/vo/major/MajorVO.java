package com.app.hanshin.counseling.vo.major;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MajorVO {
    private Long id;
    private Long majorFieldId;
    private String major;
}

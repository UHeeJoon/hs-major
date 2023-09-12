package com.app.hanshin.counseling.vo.time;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class TimeVO {
    private Long id;
    private String startTime;
    private String endTime;
}

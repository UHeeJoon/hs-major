package com.app.hanshin.counseling.vo.major;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MajorDTO {
    private Long id;
    private String major;

    @Builder
    public MajorDTO(String major) {
        this.major = major;
    }
}

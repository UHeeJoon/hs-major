package com.app.hanshin.counseling.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor

public class FileDTO {
    private String major;
    private String professorName;

    public FileDTO stringArrToFileDTO(String[] data){
        this.major = data[0];
        this.professorName = data[1];
        return this;
    }
}

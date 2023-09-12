package com.app.hanshin.counseling.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FileReadVO {
//    applicant에들어갈 내용들
    private String id;
    private String applicantDate;
    private String timeStart;
    private String professorName;
    private String major;

    public FileReadVO stringArrToFileReadVO(String[] data){
        this.id = data[0];
        this.applicantDate = data[1];
        this.timeStart = data[2];
        this.professorName = data[3];
        this.major = data[4];
        return this;
    }

    @Builder
    public FileReadVO(String id, String applicantDate, String timeStart, String professorName, String major) {
        this.id = id;
        this.applicantDate = applicantDate;
        this.timeStart = timeStart;
        this.professorName = professorName;
        this.major = major;
    }
}

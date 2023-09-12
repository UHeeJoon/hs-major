package com.app.hanshin.counseling.vo.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private Long id;
    private String studentId;
    private String memberName;
    private String memberEmail;
    private String memberMajor;
    private String number_of_applicant;
}

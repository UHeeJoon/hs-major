package com.app.hanshin.counseling.vo.member;

import com.app.hanshin.counseling.vo.StateEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberStateDTO {
    private Long id;
    private String studentId;
    private String memberName;
    private String memberEmail;
    private String code;
    private StateEnum state;

    public MemberStateDTO(Long id, String studentId, String memberName, String memberEmail) {
        this.id = id;
        this.studentId = studentId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }
}

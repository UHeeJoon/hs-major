package com.app.hanshin.counseling.service.applicant;

import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.ApplicantDTO;
import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.major.MajorDTO;

import java.util.List;

public interface ApplicantService {
    public List<MajorDTO> getMajors(Long majorFieldId);

    public List<ApplicantDTO> getApplicant(ApplicantDateMajor dateMajor);

}

package com.app.hanshin.counseling.service.applicant;


import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.applicant.MyApplicantListDTO;

import java.util.List;

public interface MemberApplicantListService {

    public List<MyApplicantListDTO> applicant(MemberApplicantListDTO memberApplicantListDTO);

    public List<MyApplicantListDTO> getMyApplicantList(Long memberId);

    public List<MyApplicantListDTO> removeApplicant(MemberApplicantListDTO memberApplicantListDTO);

}

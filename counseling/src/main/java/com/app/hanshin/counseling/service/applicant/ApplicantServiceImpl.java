package com.app.hanshin.counseling.service.applicant;

import com.app.hanshin.counseling.dao.applicant.ApplicantDAO;
import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.ApplicantDTO;
import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.major.MajorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ApplicantServiceImpl implements ApplicantService {

    final private ApplicantDAO applicantDAO;

    @Override
    public List<MajorDTO> getMajors(Long majorFieldId) {
        return applicantDAO.findAllByMajorField(majorFieldId);
    }

    @Override
    public List<ApplicantDTO> getApplicant(ApplicantDateMajor dateMajor) {
        return applicantDAO.findAllByApplicantDateAndMajorId(dateMajor);
    }


}

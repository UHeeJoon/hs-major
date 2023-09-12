package com.app.hanshin.counseling.dao.applicant;

import com.app.hanshin.counseling.mapper.applicant.ApplicantMapper;
import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.ApplicantDTO;
import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.major.MajorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplicantDAO {

    final private ApplicantMapper applicantMapper;

    public List<MajorDTO> findAllByMajorField(Long majorFieldId){
        return applicantMapper.selectAll(majorFieldId);
    }

    public List<ApplicantDTO> findAllByApplicantDateAndMajorId(ApplicantDateMajor dateMajor){
        return applicantMapper.select(dateMajor);
    }



}

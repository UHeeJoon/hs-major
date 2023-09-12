package com.app.hanshin.counseling.mapper.applicant;

import com.app.hanshin.counseling.vo.applicant.ApplicantDTO;
import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.major.MajorDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicantMapper {
    public List<MajorDTO> selectAll(Long majorFieldId);

    public List<ApplicantDTO> select(ApplicantDateMajor dateMajor);


}

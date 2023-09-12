package com.app.hanshin.counseling.mapper.applicant;

import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListVO;
import com.app.hanshin.counseling.vo.applicant.MyApplicantListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberApplicantListMapper {
    public Integer insert(MemberApplicantListDTO memberApplicantListDTO);

    public List<MyApplicantListDTO> selectMine(Long memberId);

    public Integer delete(MemberApplicantListDTO memberApplicantListDTO);
}

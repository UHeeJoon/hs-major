package com.app.hanshin.counseling.dao.applicant;

import com.app.hanshin.counseling.mapper.applicant.MemberApplicantListMapper;
import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.applicant.MyApplicantListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberApplicantListDAO {
    final private MemberApplicantListMapper memberApplicantListMapper;

    public StateEnum save(MemberApplicantListDTO memberApplicantListDTO){
        return StateEnum.toStateEnum(memberApplicantListMapper.insert(memberApplicantListDTO));
    }

    public List<MyApplicantListDTO> findByMemberId(Long memberId){
        return memberApplicantListMapper.selectMine(memberId);
    }

    public StateEnum deleteByMemberIdApplicantId(MemberApplicantListDTO memberApplicantListDTO){
        return StateEnum.toStateEnum(memberApplicantListMapper.delete(memberApplicantListDTO));
    }

}

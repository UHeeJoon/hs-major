package com.app.hanshin.counseling.service.applicant;

import com.app.hanshin.counseling.dao.applicant.MemberApplicantListDAO;
import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.applicant.MyApplicantListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberApplicantListServiceImpl implements MemberApplicantListService {

    final private MemberApplicantListDAO memberApplicantListDAO;

    @Override
    public List<MyApplicantListDTO> applicant(MemberApplicantListDTO memberApplicantListDTO) {
        try{
            memberApplicantListDAO.save(memberApplicantListDTO);
            return memberApplicantListDAO.findByMemberId(memberApplicantListDTO.getMemberId());
        } catch (Exception ignored){;}
        return null;
    }

    @Override
    public List<MyApplicantListDTO> getMyApplicantList(Long memberId) {
        return memberApplicantListDAO.findByMemberId(memberId);
    }


    @Override
    public List<MyApplicantListDTO> removeApplicant(MemberApplicantListDTO memberApplicantListDTO) {
        try{
            memberApplicantListDAO.deleteByMemberIdApplicantId(memberApplicantListDTO);
            return memberApplicantListDAO.findByMemberId(memberApplicantListDTO.getMemberId());
        } catch (Exception ignored){;}
        return null;
    }
}

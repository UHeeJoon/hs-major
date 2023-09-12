package com.app.hanshin.counseling.controller;

import com.app.hanshin.counseling.service.applicant.ApplicantService;
import com.app.hanshin.counseling.service.applicant.MemberApplicantListService;
import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.applicant.ApplicantDTO;
import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import com.app.hanshin.counseling.vo.applicant.MemberApplicantListDTO;
import com.app.hanshin.counseling.vo.applicant.MyApplicantListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/applicant")
@RequiredArgsConstructor
public class ApplicantController {

    final private ApplicantService applicantService;
    final private MemberApplicantListService memberApplicantListService;

    @GetMapping("")
    public Object goToApplicant(HttpSession session, Model model){
//        session.setAttribute("majorFieldId", 1L);
//        session.setAttribute("id", 1111L);
        Long memberId = (Long)session.getAttribute("id");
        Long majorFieldId = (Long) session.getAttribute("majorFieldId");
        if(memberId == null){
            return new RedirectView("/");
        }
        model.addAttribute("majors", applicantService.getMajors(majorFieldId));
        model.addAttribute("myApplicantList", memberApplicantListService.getMyApplicantList(memberId));
        return "applicant/applicant";
    }

    @GetMapping("/{applicantId}")
    @ResponseBody
    public Object applicant(HttpSession session, @PathVariable Long applicantId){
        Long memberId = (Long) session.getAttribute("id");
        if(memberId == null){
            return "null";
        }
        List<MyApplicantListDTO> myApplicantList = memberApplicantListService.applicant(new MemberApplicantListDTO(memberId, applicantId));
        return  myApplicantList == null ? "null" : myApplicantList;
    }

    @GetMapping("/get-applicant-data")
    @ResponseBody
    public List<ApplicantDTO> getApplicantData(HttpSession session,ApplicantDateMajor dateMajor){
        Long memberId = (Long) session.getAttribute("id");
        if(memberId == null){
            return null;
        }
        return applicantService.getApplicant(dateMajor);
    }

    @DeleteMapping("/delete/{applicantId}")
    @ResponseBody
    public Object deleteApplicant(HttpSession session, @PathVariable Long applicantId){
        Long memberId = (Long) session.getAttribute("id");
        if(memberId == null){
            return "null";
        }
        List<MyApplicantListDTO> myApplicantList = memberApplicantListService.removeApplicant(new MemberApplicantListDTO(memberId, applicantId));
        return  myApplicantList == null ? "null" : myApplicantList;
    }

}

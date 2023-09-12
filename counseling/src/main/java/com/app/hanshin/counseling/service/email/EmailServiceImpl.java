package com.app.hanshin.counseling.service.email;

import com.app.hanshin.counseling.dao.member.MemberDAO;
import com.app.hanshin.counseling.vo.StateEnum;
import com.app.hanshin.counseling.vo.member.MemberDTO;
import com.app.hanshin.counseling.vo.member.MemberStateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.RedirectView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class EmailServiceImpl implements EmailService {

    final private MemberDAO memberDAO;

    @Override
    public MemberStateDTO sendAuthNum(String studentId, HttpServletResponse response) {
        Optional<MemberDTO> memberDTO = memberDAO.findStudentIdMemberNameMemberEmailByStudentId(studentId);
        MemberStateDTO memberStateDTO = new MemberStateDTO();
        if(memberDTO.isEmpty()){
            memberStateDTO.setState(StateEnum.FAIL);
            return memberStateDTO;
        }
        if(memberDTO.get().getMemberMajor() == null || !memberDTO.get().getMemberMajor().equals("")){
            memberStateDTO.setState(StateEnum.FAIL);
            return memberStateDTO;
        }


        memberStateDTO = memberDTO.get().toMemberStateDTO();
        memberStateDTO.setState(StateEnum.SUCCESS);

//       메일 보내기
        sendMail(memberStateDTO);

        return memberStateDTO;
    }


    private void sendMail(MemberStateDTO memberStateDTO){
//         메일 인코딩
        final String bodyEncoding = "UTF-8"; // 콘텐츠 인코딩
        final String username = "dbgmlwns@hs.ac.kr";
        final String password = "fueeodffdqtqdpel";

        // 원하는 메일 제목 작성
        String subject = "인증번호 송신";
        String fromUsername = "한신대학교 메일 인증";

        String fromEmail = "jasona1@naver.com";
        String toEmail = memberStateDTO.getMemberEmail();

        final int MIN = 100000;
        final int MAX = 999999;
        String random = Integer.toString(((int) (Math.random() * (MAX - MIN + 1)) + MIN));
        memberStateDTO.setCode(random);

        StringBuilder randomNumber = new StringBuilder();
        randomNumber.append("<h2> 인증번호 : ")
                .append(random)
                .append("</h2>");

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        try {
            // 메일 서버 인증 계정 설정
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };

            // 메일 세션 생성
            Session session = Session.getDefaultInstance(props, auth);

            // 메일 송/수신 옵션 설정
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, fromUsername));
            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(toEmail, false));
            message.setSubject(subject);
            message.setSentDate(new Date());

            // 메일 콘텐츠 설정
            Multipart mParts = new MimeMultipart();
            MimeBodyPart mTextPart = new MimeBodyPart();
            MimeBodyPart mFilePart = null;

            // 메일 콘텐츠 - 내용
            mTextPart.setText(randomNumber.toString(), bodyEncoding, "html");
            mParts.addBodyPart(mTextPart);

            // 메일 콘텐츠 설정
            message.setContent(mParts);

            // 메일 발송
            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

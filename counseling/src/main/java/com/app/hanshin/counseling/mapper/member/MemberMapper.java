package com.app.hanshin.counseling.mapper.member;

import com.app.hanshin.counseling.vo.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public MemberDTO selectEmail(String studentId);
}

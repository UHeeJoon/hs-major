package com.app.hanshin.counseling.mapper;

import com.app.hanshin.counseling.vo.FileDTO;
import com.app.hanshin.counseling.vo.FileReadVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileReadMapper {
    public Integer insert(FileReadVO fileReadVO);

    public Integer insertProfessor(FileDTO fileDTO);
}

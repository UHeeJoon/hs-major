package com.app.hanshin.counseling.service;

import com.app.hanshin.counseling.mapper.FileReadMapper;
import com.app.hanshin.counseling.vo.FileDTO;
import com.app.hanshin.counseling.vo.FileReadVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileReadService {
    final private FileReadMapper fileReadMapper;




    public void readFile(String location) throws IOException, InterruptedException {


        BufferedReader reader = new BufferedReader(new FileReader(location, Charset.forName("EUC-KR")));
        String str;
        while ((str = reader.readLine()) != null){
            FileReadVO vo = new FileReadVO().stringArrToFileReadVO(str.split(","));
            fileReadMapper.insert(vo);

        }

        reader.close();
    }

    public void readProfessorFile(String location) throws IOException, InterruptedException {


        BufferedReader reader = new BufferedReader(new FileReader(location, Charset.forName("EUC-KR")));
        String str;
        while ((str = reader.readLine()) != null){
            FileDTO vo = new FileDTO().stringArrToFileDTO(str.split(","));
            fileReadMapper.insertProfessor(vo);

        }

        reader.close();
    }
}

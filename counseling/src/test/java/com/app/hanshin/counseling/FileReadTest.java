package com.app.hanshin.counseling;

import com.app.hanshin.counseling.service.FileReadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class FileReadTest {

    @Autowired
    private FileReadService fileReadService;

    @Test
    public void fileReadTest() throws IOException, InterruptedException {
        fileReadService.readFile("D:\\hanshin-unversity-consultation\\resource\\csv\\TIME.csv");
    }

    @Test
    public void insertProfessorTest() throws IOException, InterruptedException {
        fileReadService.readProfessorFile("D:\\hanshin-unversity-consultation\\resource\\csv\\PROFESSOR.csv");
    }

}

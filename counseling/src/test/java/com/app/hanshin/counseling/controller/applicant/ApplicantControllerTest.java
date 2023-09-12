package com.app.hanshin.counseling.controller.applicant;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.hanshin.counseling.vo.applicant.ApplicantDateMajor;
import com.app.hanshin.counseling.vo.major.MajorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class ApplicantControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void goToApplicantTest() throws Exception{
        assertThat( ((List<MajorDTO>)(Objects.requireNonNull(mockMvc.perform(MockMvcRequestBuilders.get("/applicant"))
                .andReturn()
                .getModelAndView()
        )
                .getModelMap()
                .get("majors"))).get(0).getMajor()
        ).isEqualTo("신학");
    }

    @Test
    public void getApplicantData() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/applicant/get-applicant-data?majorId=23&applicantDate=9/19"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}

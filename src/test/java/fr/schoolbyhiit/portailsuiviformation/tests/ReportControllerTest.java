package fr.schoolbyhiit.portailsuiviformation.tests;

import fr.schoolbyhiit.portailsuiviformation.controller.ReportController;
import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ReportControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private ReportService reportServiceMock;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getReports() throws Exception {
        UserDto user = new UserDto();
        user.setId(1l);
        user.setMail("user.mail@school.fr");
        ReportDTO report = new ReportDTO();
        report.setId(1l);
        report.setUser(User.builder().build());
        List<ReportDTO> allReports = singletonList(report);


        given(reportController.getReports()).willReturn(allReports);
        mvc.perform(get("http:localhost8080/report"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].report", is(report.getId())));
    }

    @Test
    void create() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}

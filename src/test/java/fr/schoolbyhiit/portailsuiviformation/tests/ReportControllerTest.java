package fr.schoolbyhiit.portailsuiviformation.tests;

import fr.schoolbyhiit.portailsuiviformation.controller.ReportController;
import fr.schoolbyhiit.portailsuiviformation.dto.UserDto;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
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
    void getReports() throws IOException {
        ReportDTO report = new ReportDTO();
        report.setId(1l);
        report.setUser(User.builder().id(1l).mail("user.mail@school.fr").build());
        List<ReportDTO> allReports = singletonList(report);

        HttpResponse httpResponse = HttpClientBuilder.create().build()
            .execute(new HttpGet( "http://localhost:8080/report/" ));

        assertThat(
            httpResponse.getStatusLine().getStatusCode(),
            equalTo(HttpStatus.SC_OK));
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

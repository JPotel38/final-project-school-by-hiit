package fr.schoolbyhiit.portailsuiviformation.tests;

import fr.schoolbyhiit.portailsuiviformation.controller.ReportController;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ReportController.class)
public class ReportControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private ReportService reportServiceMock;

    @Test
    void shouldReturns200WhenFind() throws Exception {
        //GIVEN
        assertThat()        //THEN
        ;
    }
}

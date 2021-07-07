package fr.schoolbyhiit.portailsuiviformation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import fr.schoolbyhiit.portailsuiviformation.dto.ReportDTO;
import fr.schoolbyhiit.portailsuiviformation.entity.User;
import fr.schoolbyhiit.portailsuiviformation.exception.ReportNotFoundException;
import fr.schoolbyhiit.portailsuiviformation.model.ReportStatus;
import fr.schoolbyhiit.portailsuiviformation.service.ReportService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(controllers = ReportController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class ReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ReportService reportService;
    private List<ReportDTO> reportDTOList;
    private User user;
    private ReportDTO reportDTO;

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setId(1L);
        this.user.setCreationDate(LocalDate.now());
        this.user.setBirthDate(LocalDate.of(1990, 10, 10));
        this.user.setFirstName("Jon");
        this.user.setLastName("Snow");
        this.user.setMail("mail@mail.com");
        this.reportDTOList = new ArrayList<>();
        this.reportDTO = new ReportDTO();
        this.reportDTO.setId(1L);
        ZonedDateTime appointmentDate = ZonedDateTime.of(
                2021, 7, 3, 12, 20, 59,
            90000, ZoneId.systemDefault());
        this.reportDTO.setAppointmentDate(appointmentDate);
        this.reportDTO.setTeacherId(this.user.getId());
        this.reportDTO.setStudentId(this.user.getId());
        this.reportDTO.setTutorId(this.user.getId());
        this.reportDTO.setReportText("Quel bon eleve");
        this.reportDTO.setValidated(ReportStatus.VALIDATED);
        this.reportDTOList.add(reportDTO);
    }

    @Test
    void shouldFetchAllReports() throws Exception {
        Mockito.when(reportService.findAll()).thenReturn(reportDTOList);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/report")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();
        Assertions.assertThat(result).isNotNull();
        String reportJson = result.getResponse().getContentAsString();
        Assertions.assertThat(reportJson).isEqualToIgnoringCase(mapper.writeValueAsString(reportDTOList));
    }

    @Test
    void shouldCreateNewReport() throws Exception {

//        ReportDTO createdReportDTO = new ReportDTO();
//        createdReportDTO.setId(2L);
//        createdReportDTO.setTeacherId(this.user.getId());
//        createdReportDTO.setStudentId(this.user.getId());
//        createdReportDTO.setTutorId(this.user.getId());
//        createdReportDTO.setAppointmentDate(ZonedDateTime.of(
//            2021, 7, 7, 14, 20, 59,
//            90000, ZoneId.systemDefault()));
//        createdReportDTO.setReportText("Quel mauvais eleve");
//        createdReportDTO.setValidated(ReportStatus.VALIDATED);
//        Mockito.when(reportService.create(createdReportDTO)).thenReturn(createdReportDTO);
//        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        String requestJson = ow.writeValueAsString(createdReportDTO);
//        MvcResult result = this.mockMvc.perform(post("/api/report/post")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(requestJson))
//            .andExpect(status().isOk())
//            .andReturn();
//        Assertions.assertThat(result).isNotNull();
//        String reportJson = result.getResponse().getContentAsString();
//        Assertions.assertThat(reportJson).isEqualToIgnoringCase(mapper.writeValueAsString(createdReportDTO));
    }

    @Test
    void shouldFetchOneReportById() throws Exception {
        given(reportService.findById(1L)).willReturn(this.reportDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/report/{id}", 1L)
            .content(mapper.writeValueAsString(this.reportDTO)))
            .andExpect(jsonPath("id").value(1L))
            .andExpect(status().isOk())
            .andReturn();
    }

//    @Test
//    void shouldReturn404WhenReportById() throws Exception {
//        given(reportService.findById(50L)).willThrow(ReportNotFoundException.class);
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/report/{id}", 50L))
//            .andExpect(status().isNotFound());
//    }

    @Test
    void shouldUpdateReportStatus() {
    }
}

package fr.schoolbyhiit.portailsuiviformation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.schoolbyhiit.portailsuiviformation.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = {UserController.class})
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;


    @Test
    void whenValidInput_thenReturns200() throws Exception {
//        mockMvc.perform(post("/users")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
    }

    @Test
    void whenFindById_thenReturns200() throws Exception {
        //GIVEN
        MockHttpServletRequestBuilder request = get("/users").contentType(MediaType.APPLICATION_JSON);
        //WHEN
        final ResultActions result = mockMvc.perform(request);
        //THEN
        result
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON));
    }


}
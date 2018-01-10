package foodapp.controller;

import foodapp.service.FoodAppService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class FoodAppControllerTest {

    @InjectMocks
    FoodAppController foodAppController;

    @Mock
    FoodAppService foodAppService;

    private MockMvc mockMvc;

    private String json ="{\"id\":\"5\",\"name\":\"testname\",\"price\":\"95\",\"type\":\"veg\"}";
    private String Errorjson ="{\"id\":\"5\",\"name\":\"testname\",\"price\":\"abc\",\"type\":\"veg\"}";

    @Before
    public void setup()throws Exception {
        initMocks(this);
        mockMvc = standaloneSetup(foodAppController).build();
    }

    @Test
    public void postTestWithCorrectData() throws Exception {
        MvcResult result = mockMvc.perform(post("/insert")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());;
    }

    @Test
    public void postTestWithInCorrectData() throws Exception {
        MvcResult result = mockMvc.perform(post("/insert")
                .accept(MediaType.APPLICATION_JSON)
                .content(Errorjson)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertNotEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getTestingSearchAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/search/all")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getTestingSearchIndividual() throws Exception {
        MvcResult result = mockMvc.perform(get("/search/2")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getTestingSearchRange() throws Exception {
        MvcResult result = mockMvc.perform(get("/search/1/10")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void putTesting() throws Exception {
        MvcResult result = mockMvc.perform(put("/update")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void deleteTesting() throws Exception {
        MvcResult result = mockMvc.perform(delete("/delete/2")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}

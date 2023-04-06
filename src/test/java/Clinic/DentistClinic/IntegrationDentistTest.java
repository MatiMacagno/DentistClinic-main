package Clinic.DentistClinic;


import Clinic.DentistClinic.Entities.Dentist;
import Clinic.DentistClinic.Service.DentistService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegrationDentistTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DentistService dentistService;

    @BeforeEach
    public void cargarDataSet() {
        Dentist dentist = new Dentist("Matias", "Macagno", "M1989");
        dentistService.saveDentist(dentist);
    }

    @Test
    public void listDentists() throws Exception {
        this.cargarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/dentist/all").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assertions.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

}




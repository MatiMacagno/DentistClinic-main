package Clinic.DentistClinic;


import Clinic.DentistClinic.Entities.Address;
import Clinic.DentistClinic.Entities.Appointment;
import Clinic.DentistClinic.Entities.Dentist;
import Clinic.DentistClinic.Entities.Patient;
import Clinic.DentistClinic.Service.AppointmentService;
import Clinic.DentistClinic.Service.DentistService;
import Clinic.DentistClinic.Service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
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

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegrationAppointmentsTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PatientService patientService;

    @Autowired
    DentistService dentistService;

    @Autowired
    AppointmentService appointmentService;

    @BeforeEach
    public void cargarDataSet() {
        Address address = new Address("Antonia", 124, "Santa Fe", "Santa Fe");
        Patient patient = new Patient("Matias", "Macagno", "12345", LocalDate.of(2022, 4, 24), address);
        patientService.savePatient(patient);
        Dentist dentist = new Dentist("Paula", "Rodriguez", "M1989");
        dentistService.saveDentist(dentist);
        Appointment appointment = new Appointment(dentist, patient, LocalDate.of(2023, 10, 12));
        appointmentService.saveAppointment(appointment);
    }

    @Test
    public void listAppointments() throws Exception {
        this.cargarDataSet();
        MvcResult respuesta = mockMvc.perform(MockMvcRequestBuilders.get("/appointment/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assertions.assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }


}

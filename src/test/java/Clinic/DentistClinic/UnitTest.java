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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UnitTest {

    @Autowired
    PatientService patientService;

    @Autowired
    DentistService dentistService;

    @Autowired
    AppointmentService appointmentService;

    @BeforeEach
    void init() {
        Address address = new Address("Antonia", 124, "Santa Fe", "Santa Fe");
        Patient patient = new Patient("Matias", "Macagno", "12345", LocalDate.of(2022, 4, 24), address);
        patientService.savePatient(patient);
        Dentist dentist = new Dentist("Paula", "Rodriguez", "M1989");
        dentistService.saveDentist(dentist);
        Appointment appointment = new Appointment(dentist, patient, LocalDate.of(2023, 10, 12));
        appointmentService.saveAppointment(appointment);
    }

    @Test
    void getPatientById(){
        Optional<Patient> patient = patientService.findPatient(1L);
        Assertions.assertTrue(patient.get().getId() >=1L);
    }

    @Test
    void getDentistById() {
        Optional<Dentist> dentist = dentistService.findDentist(1L);
        Assertions.assertTrue(dentist.get().getId() >= 1L);
    }

    @Test
    void getAppointmentById() {
        Optional<Appointment> appointment = appointmentService.findAppointment(1L);
        Assertions.assertTrue(appointment.get().getId() >= 1L);
    }

    @Test
    void getPatientsList(){
        List<Patient> patientList = patientService.findAllPatients();
        Assertions.assertFalse(patientList.isEmpty());
    }

    @Test
    void getDentistsList(){
        List<Dentist> dentistList = dentistService.findAllDentists();
        Assertions.assertFalse(dentistList.isEmpty());
    }

    @Test
    void getAppointmentsList(){
        List<Appointment> appointmentList = appointmentService.findAllAppointments();
        Assertions.assertFalse(appointmentList.isEmpty());
    }

    @Test
    void updateDentist() {
        Optional<Dentist> dentist = dentistService.findDentist(1L);
        dentist.get().setName("Miriam");
        Dentist dentist1 = dentistService.updateDentist(1L, dentist.get());
        Assertions.assertEquals(dentist1.getName(), "Miriam");
    }

    @Test
    void updateAppointmentDate() {
        Optional<Appointment> appointment = appointmentService.findAppointment(1L);
        appointment.get().setDateAppointment(LocalDate.of(2023,4,30));
        Appointment appointment1 = appointmentService.updateAppointment(1L, appointment.get());
        Assertions.assertEquals(appointment1.getDateAppointment(), LocalDate.of(2023,4,30));
    }

    @Test
    public void deletePatientById(){
        Patient p2 = new Patient("Marcos", "Loyeau","12341995", LocalDate.of(2022, 4, 24), new Address());
        patientService.savePatient(p2);
        List<Patient> patientList = patientService.findAllPatients();
        patientService.deletePatient(2L);
        Assertions.assertFalse(patientList.contains(p2));
    }

}

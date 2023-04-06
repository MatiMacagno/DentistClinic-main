package Clinic.DentistClinic.Service;

import Clinic.DentistClinic.Entities.Appointment;
import Clinic.DentistClinic.Repository.AppointmentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private static final Logger logger = Logger.getLogger(AppointmentService.class);

    @Autowired
    AppointmentRepository appointmentRepository;

    public boolean existsById(Long id) {
        return appointmentRepository.existsById(id);
    }

    public Appointment saveAppointment(Appointment a) {
        return appointmentRepository.save(a);
    }


    public Boolean deleteAppointment(Long id) {
        if (!existsById(id)){
            logger.info("Appointment "+ id + "not exists");
            throw new NotFoundException("Appointment id no exists");
        }
        appointmentRepository.deleteById(id);
        return true;
    }

    public Optional<Appointment> findAppointment(Long id) {
        if(!existsById(id)){
            logger.info("Appointment "+ id + "not exists");
            throw new NotFoundException("Appointment not found with ID: " + id);
        }
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment updateAppointment(Long id, Appointment newAppointment) {
        Appointment a = appointmentRepository.findById(id).orElseThrow(() -> {throw new RuntimeException();});
        a.setDateAppointment(newAppointment.getDateAppointment());
        logger.info("Update appointment " + id );
        return a;
    }

}

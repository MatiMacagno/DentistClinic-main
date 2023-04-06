package Clinic.DentistClinic.Repository;

import Clinic.DentistClinic.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

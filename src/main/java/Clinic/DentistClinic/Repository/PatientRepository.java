package Clinic.DentistClinic.Repository;

import Clinic.DentistClinic.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

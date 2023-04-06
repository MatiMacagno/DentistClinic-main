package Clinic.DentistClinic.Repository;

import Clinic.DentistClinic.Entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}

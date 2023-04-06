package Clinic.DentistClinic.Service;

import Clinic.DentistClinic.Entities.Patient;
import Clinic.DentistClinic.Repository.PatientRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private static final Logger logger = Logger.getLogger(PatientService.class);

    @Autowired
    PatientRepository patientRepository;

    public boolean existsById(Long id) {
        return patientRepository.existsById(id);
    }

    public Patient savePatient(Patient p) {
        p.setDischargeDate(LocalDate.now());
        return patientRepository.save(p);
    }

    public boolean deletePatient(Long id) {
        Optional<Patient> patient = findPatient(id);
        if (patient.isPresent()){
            patientRepository.deleteById(id);
            logger.info("Dentist eliminated");
            return true;
        }
        else {
            logger.info("Patient not exists");
            throw new NotFoundException("Patient not exists");
        }
    }

    public Patient updatePatient(Long id, Patient updatePatient) {
        Patient p = patientRepository.findById(id).orElseThrow(() -> {throw new RuntimeException();});
        p.setName(updatePatient.getName());
        p.setLastName(updatePatient.getLastName());
        p.setAddress(updatePatient.getAddress());
        p.setDNI(updatePatient.getDNI());
        logger.info("Update patient " + id );
        return patientRepository.save(p);
    }

    public Optional<Patient> findPatient(Long id){
        if(!existsById(id)) {
            logger.info("Patient with id " + id + " not exists");
            throw new NotFoundException("Patient not found with ID: " + id);
        }
        return patientRepository.findById(id);

    }
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }


}

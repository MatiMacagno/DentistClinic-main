package Clinic.DentistClinic.Service;

import Clinic.DentistClinic.Entities.Dentist;
import Clinic.DentistClinic.Repository.DentistRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private static final Logger logger = Logger.getLogger(DentistService.class);

    @Autowired
    DentistRepository dentistRepository;

    public boolean existById(Long id) {
        return dentistRepository.existsById(id);
    }

    public Dentist saveDentist(Dentist d) {
        return dentistRepository.save(d);
    }

    public Boolean deleteDentist(Long id) {
        Optional<Dentist> dentist = findDentist(id);
        if (dentist.isPresent()){
            dentistRepository.deleteById(id);
            logger.info("Dentist eliminated");
            return true;
        }
        else {
            logger.info("Dentist not exists");
            throw new NotFoundException("Dentist not exists");
        }
    }

    public Dentist updateDentist(Long id, Dentist updateDentist) {
        Dentist d = dentistRepository.findById(id).orElseThrow(() -> {throw new RuntimeException();});
        d.setName(updateDentist.getName());
        d.setLastName(updateDentist.getLastName());
        d.setTuition(updateDentist.getTuition());
        logger.info("Update dentist " + id );
        return dentistRepository.save(d);
    }

    public Optional<Dentist> findDentist(Long id) {
        if (!existById(id)){
            logger.info("Dentist with id " + id + " not exists");
            throw new NotFoundException("Dentist not found with ID: " + id);
        }
        return dentistRepository.findById(id);
    }

    public List<Dentist> findAllDentists() {
        return dentistRepository.findAll();
    }

}

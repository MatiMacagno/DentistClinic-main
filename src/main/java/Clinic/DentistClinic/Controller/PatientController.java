package Clinic.DentistClinic.Controller;

import Clinic.DentistClinic.Entities.Patient;
import Clinic.DentistClinic.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient p) {
        return new ResponseEntity<>(patientService.savePatient(p), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> allPatients() {
        return new ResponseEntity<>(patientService.findAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> patientById(@PathVariable("id") Long idPatient) {
        return new ResponseEntity<>(patientService.findPatient(idPatient), HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
   public ResponseEntity<Boolean> deleteDentist(@PathVariable("id") Long idPatient) {
       boolean response = patientService.deletePatient(idPatient);
       if(response) {
           return new ResponseEntity<>(HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updateDentist(@PathVariable("id") Long idDentist, @RequestBody Patient p) {
        return new ResponseEntity<>(patientService.updatePatient(idDentist, p), HttpStatus.OK);
    }

}

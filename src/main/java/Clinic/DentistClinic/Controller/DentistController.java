package Clinic.DentistClinic.Controller;

import Clinic.DentistClinic.Entities.Dentist;
import Clinic.DentistClinic.Service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    DentistService dentistService;

    @PostMapping("/create")
    public ResponseEntity<Dentist> createDentist(@RequestBody Dentist d) {
        return new ResponseEntity<>(dentistService.saveDentist(d), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDentist(@PathVariable("id") Long idDentist) {
        boolean response = dentistService.deleteDentist(idDentist);
        if(response) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Dentist>> dentistById(@PathVariable("id") Long idDentist) {
        return new ResponseEntity<>(dentistService.findDentist(idDentist), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dentist>> allDentists() {
        return new ResponseEntity<>(dentistService.findAllDentists(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dentist> updateDentist(@PathVariable("id") Long idDentist, @RequestBody Dentist d) {
        return new ResponseEntity<>(dentistService.updateDentist(idDentist, d), HttpStatus.OK);
    }

}

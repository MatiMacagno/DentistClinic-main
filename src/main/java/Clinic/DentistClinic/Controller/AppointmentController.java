package Clinic.DentistClinic.Controller;

import Clinic.DentistClinic.Entities.Appointment;
import Clinic.DentistClinic.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment a){
        return new ResponseEntity<>(appointmentService.saveAppointment(a), HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Appointment>> appointmentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(appointmentService.findAppointment(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> allAppointments() {
        return new ResponseEntity<>(appointmentService.findAllAppointments(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable("id") Long id){
        boolean response = appointmentService.deleteAppointment(id);
        if(response) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") Long id, @RequestBody Appointment appointment){
        return new ResponseEntity<>(appointmentService.updateAppointment(id, appointment), HttpStatus.OK);
    }

}

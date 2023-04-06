package Clinic.DentistClinic.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column
    private LocalDate dateAppointment;

    public Appointment(Dentist dentist, Patient patient, LocalDate dateAppointment) {
        this.dentist = dentist;
        this.patient = patient;
        this.dateAppointment = dateAppointment;
    }
}

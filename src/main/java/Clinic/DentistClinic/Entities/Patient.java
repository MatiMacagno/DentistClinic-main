package Clinic.DentistClinic.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {

    @Column(name = "patient_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String DNI;
    @Column
    private LocalDate dischargeDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<Appointment> appointments = new HashSet<>();

    public Patient(String name, String lastName, String DNI, LocalDate dischargeDate, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.dischargeDate = dischargeDate;
        this.address = address;
    }

}

package Clinic.DentistClinic.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dentist {

    @Column(name = "dentist_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String tuition;

    @JsonIgnore
    @OneToMany(mappedBy = "dentist",fetch = FetchType.LAZY)
    private Set<Appointment> appointments= new HashSet<>();

    public Dentist(String name, String lastName, String tuition) {
        this.name = name;
        this.lastName = lastName;
        this.tuition = tuition;
    }
}

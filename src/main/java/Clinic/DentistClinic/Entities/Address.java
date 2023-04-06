package Clinic.DentistClinic.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String street;
    @Column
    private Integer number;
    @Column
    private String locality;
    @Column
    private String province;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Patient patient;

    public Address(String street, Integer number, String locality, String province) {
        this.street = street;
        this.number = number;
        this.locality = locality;
        this.province = province;
    }
}

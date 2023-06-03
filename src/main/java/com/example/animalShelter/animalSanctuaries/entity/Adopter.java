package com.example.animalShelter.animalSanctuaries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adopter {

    @Id
    private int adopter_ssn;

    private String a_Fname;

    private String a_Mname;

    private String a_LName;

    private String gender;

    private String tel_no;

    private String email;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Address adopter_address;

}

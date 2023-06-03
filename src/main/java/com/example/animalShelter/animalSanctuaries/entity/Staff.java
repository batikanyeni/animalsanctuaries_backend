package com.example.animalShelter.animalSanctuaries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;
    private String S_Fname;
    private String S_Mname;
    private String S_LName;
    private int staff_ssn;
    private String gender;
    private String tel_no;
    private String email;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn
    private Address staff_address;

    public Staff(String s_Fname, String s_Mname, String s_LName, int staff_ssn, String gender, String tel_no, String email, Address address) {
        S_Fname = s_Fname;
        S_Mname = s_Mname;
        S_LName = s_LName;
        this.staff_ssn = staff_ssn;
        this.gender = gender;
        this.tel_no = tel_no;
        this.email = email;
        this.staff_address = address;
    }
}

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
public class Sanctuarie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sanctuarie_id;
    private String sanctuarie_name;
    private String tel_no;
    private String email;
    private int totalCageNum;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Address sanctruarie_address;

    public Sanctuarie(String sanctuarie_name, String tel_no, String email, int totalCageNum,Address address) {
        this.sanctuarie_name = sanctuarie_name;
        this.tel_no = tel_no;
        this.email = email;
        this.totalCageNum = totalCageNum;
        this.sanctruarie_address=address;
    }
}

package com.enviro.assessment.grad001.withdrawlsystem.entities;

import com.enviro.assessment.grad001.withdrawlsystem.dto.InvestorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Address address;
    @OneToMany(mappedBy = "investor",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public Investor(String firstName, String lastName,int age, String email, String phone, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    public InvestorDTO toDTO() {
        return new InvestorDTO(id, firstName, lastName,age, email, phone, address.toDTO(), products);
    }
    public Investor fromDTO(InvestorDTO investorDTO) {
        return new Investor(investorDTO.id(), investorDTO.firstName(), investorDTO.lastName(),investorDTO.age(), investorDTO.email(), investorDTO.phone(),new Address().fromDTO(investorDTO.addressDTO()), investorDTO.productDTOS());
    }
}

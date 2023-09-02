package com.enviro.assessment.grad001.withdrawlsystem.entities;

import com.enviro.assessment.grad001.withdrawlsystem.dto.AddressDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String street;
    private String city;
    private String province;
    private String zip;
    private String country;

    public Address(String street, String city, String province, String zip, String country) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.zip = zip;
        this.country = country;
    }
    public AddressDTO toDTO() {
        return new AddressDTO(id, street, city, province, zip, country);
    }
    public Address fromDTO(AddressDTO addressDTO) {
        return new Address(addressDTO.id(), addressDTO.street(), addressDTO.city(), addressDTO.province(), addressDTO.zip(), addressDTO.country());
    }
}

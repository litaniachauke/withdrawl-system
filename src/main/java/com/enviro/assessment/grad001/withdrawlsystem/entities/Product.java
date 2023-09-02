package com.enviro.assessment.grad001.withdrawlsystem.entities;

import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private String type;
    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;
    private double currentBalance;

    public Product(String name, String description, String type,Investor investor, double currentBalance) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.investor = investor;
        this.currentBalance = currentBalance;
    }
    public ProductDTO toDTO() {
        return new ProductDTO(id, name, description,investor.toDTO(), type, currentBalance);
    }
    public Product fromDTO(ProductDTO productDTO) {
        return new Product(productDTO.id(), productDTO.name(), productDTO.description(), productDTO.type(),new Investor().fromDTO(productDTO.investor()), productDTO.currentBalance());
    }
}

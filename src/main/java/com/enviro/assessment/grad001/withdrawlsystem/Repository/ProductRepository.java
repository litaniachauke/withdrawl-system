package com.enviro.assessment.grad001.withdrawlsystem.Repository;

import com.enviro.assessment.grad001.withdrawlsystem.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}

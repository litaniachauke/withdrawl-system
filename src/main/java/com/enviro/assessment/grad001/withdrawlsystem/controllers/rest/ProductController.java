package com.enviro.assessment.grad001.withdrawlsystem.controllers.rest;

import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @PostMapping("/create")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productServices.createProduct(productDTO);
    }
    @PutMapping("/update")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productServices.updateProduct(productDTO);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@PathVariable UUID id) {
        return productServices.deleteProduct(id);
    }
    @GetMapping("/get/{id}")
    public ProductDTO getProductById(@PathVariable UUID id) {
        return productServices.getProductById(id);
    }
}

package com.enviro.assessment.grad001.withdrawlsystem.controllers.rest;

import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    /**
     * Create product product dto.
     *
     * @param productDTO the product dto
     * @return the product dto
     */
    @PostMapping("/create")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productServices.createProduct(productDTO);
    }

    /**
     * Update product product dto.
     *
     * @param productDTO the product dto
     * @return the product dto
     */
    @PutMapping("/update")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productServices.updateProduct(productDTO);
    }

    /**
     * Delete product boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@PathVariable UUID id) {
        return productServices.deleteProduct(id);
    }

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    @GetMapping("/get/{id}")
    public ProductDTO getProductById(@PathVariable UUID id) {
        return productServices.getProductById(id);
    }
}

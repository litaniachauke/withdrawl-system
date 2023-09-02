package com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface;

import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;

import java.util.UUID;

public interface ProductServices {
    ProductDTO getProductById(UUID id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    boolean deleteProduct(UUID id);
}

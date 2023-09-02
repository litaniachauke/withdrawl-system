package com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface;

import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;

import java.util.UUID;

/**
 * The interface Product services.
 */
public interface ProductServices {
    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    ProductDTO getProductById(UUID id);

    /**
     * Create product product dto.
     *
     * @param productDTO the product dto
     * @return the product dto
     */
    ProductDTO createProduct(ProductDTO productDTO);

    /**
     * Update product product dto.
     *
     * @param productDTO the product dto
     * @return the product dto
     */
    ProductDTO updateProduct(ProductDTO productDTO);

    /**
     * Delete product boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteProduct(UUID id);
}

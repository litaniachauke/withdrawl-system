package com.enviro.assessment.grad001.withdrawlsystem.services.serviceImplemetation;

import com.enviro.assessment.grad001.withdrawlsystem.Repository.ProductRepository;
import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Product;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ProductServiceImplementation implements ProductServices {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO getProductById(UUID id) {
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get().toDTO();
        }else {
            throw new RuntimeException("Product not found!");
        }
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        if(productDTO != null){
            return productRepository.save(new Product().fromDTO(productDTO)).toDTO();
        }else {
            throw new RuntimeException("Product not found!");
        }
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        if (productRepository.findById(productDTO.id()).isPresent()){
            return productRepository.save(new Product().fromDTO(productDTO)).toDTO();
        }else {
            throw new RuntimeException("Product not found!");
        }
    }

    @Override
    public boolean deleteProduct(UUID id) {
        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return true;
        }else {
            throw new RuntimeException("Product not found!");
        }
    }
}

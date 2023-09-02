package com.enviro.assessment.grad001.withdrawlsystem.services.serviceImplemetation;

import com.enviro.assessment.grad001.withdrawlsystem.Repository.InvestorRepository;
import com.enviro.assessment.grad001.withdrawlsystem.Repository.ProductRepository;
import com.enviro.assessment.grad001.withdrawlsystem.dto.InvestorDTO;
import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Investor;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Product;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.InvestorService;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.WithdrawalNoticeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
@Service
public class InvestorServiceImplementation implements InvestorService {
    @Autowired
    private InvestorRepository investorRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WithdrawalNoticeServices withdrawalNoticeServices;

    @Override
    public InvestorDTO getInvestorById(UUID id) {
        if (investorRepository.findById(id).isPresent()) {
            return investorRepository.findById(id).get().toDTO();
        } else {
            throw new RuntimeException("Investor not found!");
        }
    }

    @Override
    public InvestorDTO createInvestor(InvestorDTO investorDTO) {
        if (investorDTO != null) {
            return investorRepository.save(new Investor().fromDTO(investorDTO)).toDTO();
        } else {
            throw new RuntimeException("Investor not found!");
        }
    }

    @Override
    public InvestorDTO updateInvestor(InvestorDTO investorDTO) {
        if (investorDTO != null && investorRepository.findById(investorDTO.id()).isPresent()) {
            return investorRepository.save(new Investor().fromDTO(investorDTO)).toDTO();
        } else {
            throw new RuntimeException("Investor not found!");
        }
    }

    @Override
    public boolean deleteInvestor(UUID id) {
        if (investorRepository.findById(id).isPresent()) {
            investorRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Investor not found!");
        }
    }

    @Override
    public boolean makeWithdrawal(UUID productId, double amount) {
        if (productRepository.findById(productId).isPresent()) {
            Product product = productRepository.findById(productId).get();
            if (amount <= (product.getCurrentBalance() * 0.9)) {
                if (Objects.equals(product.getType(), "retirement") && product.getInvestor().getAge() <= 65) {
                    throw new RuntimeException("You are not eligible for retirement withdrawal!!");
                }
                product.setCurrentBalance(product.getCurrentBalance() - amount);
                productRepository.save(product);
                return true;
            } else {
                throw new RuntimeException("Not enough balance!!");
            }

        }else{
            throw new RuntimeException("Product not found!");
        }
    }
    @Override
    public ProductDTO addProduct(ProductDTO productDTO){
        if(productDTO != null){
            Investor investor = new Investor().fromDTO(productDTO.investor());
            Product product = new Product().fromDTO(productDTO);
            investor.getProducts().add(product);
            investorRepository.save(investor);
            return productRepository.save(product).toDTO();
        }else {
            throw new RuntimeException("Product not found!");
        }
    }
}

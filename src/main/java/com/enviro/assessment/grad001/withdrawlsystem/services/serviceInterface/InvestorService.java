package com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface;

import com.enviro.assessment.grad001.withdrawlsystem.dto.InvestorDTO;
import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;

import java.util.UUID;

public interface InvestorService {
    InvestorDTO getInvestorById(UUID id);
    InvestorDTO createInvestor(InvestorDTO investorDTO);
    InvestorDTO updateInvestor(InvestorDTO investorDTO);
    boolean deleteInvestor(UUID id);
    boolean makeWithdrawal(UUID productId, double amount);
    ProductDTO addProduct(ProductDTO product);
}

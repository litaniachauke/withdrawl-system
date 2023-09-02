package com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface;

import com.enviro.assessment.grad001.withdrawlsystem.dto.InvestorDTO;
import com.enviro.assessment.grad001.withdrawlsystem.dto.ProductDTO;

import java.util.UUID;

/**
 * The interface Investor service.
 */
public interface InvestorService {
    /**
     * Gets investor by id.
     *
     * @param id the id
     * @return the investor by id
     */
    InvestorDTO getInvestorById(UUID id);

    /**
     * Create investor investor dto.
     *
     * @param investorDTO the investor dto
     * @return the investor dto
     */
    InvestorDTO createInvestor(InvestorDTO investorDTO);

    /**
     * Update investor investor dto.
     *
     * @param investorDTO the investor dto
     * @return the investor dto
     */
    InvestorDTO updateInvestor(InvestorDTO investorDTO);

    /**
     * Delete investor boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteInvestor(UUID id);

    /**
     * Make withdrawal boolean.
     *
     * @param productId the product id
     * @param amount    the amount
     * @return the boolean
     */
    boolean makeWithdrawal(UUID productId, double amount);

    /**
     * Add product product dto.
     *
     * @param product the product
     * @return the product dto
     */
    ProductDTO addProduct(ProductDTO product);
}

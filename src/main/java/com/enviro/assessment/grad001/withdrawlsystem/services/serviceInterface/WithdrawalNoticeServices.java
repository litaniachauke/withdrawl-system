package com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface;

import com.enviro.assessment.grad001.withdrawlsystem.dto.WithdrawalNoticeDTO;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Product;
import com.enviro.assessment.grad001.withdrawlsystem.entities.WithdrawalNotice;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * The interface Withdrawal notice services.
 */
public interface WithdrawalNoticeServices {
    /**
     * Create withdrawal notice withdrawal notice dto.
     *
     * @param withdrawalNotice the withdrawal notice
     * @return the withdrawal notice dto
     */
    WithdrawalNoticeDTO createWithdrawalNotice(WithdrawalNoticeDTO withdrawalNotice);

    /**
     * Update withdrawal notice withdrawal notice.
     *
     * @param withdrawalNotice the withdrawal notice
     * @return the withdrawal notice
     */
    WithdrawalNotice updateWithdrawalNotice(WithdrawalNoticeDTO withdrawalNotice);

    /**
     * Delete withdrawal notice boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteWithdrawalNotice(UUID id);

    /**
     * Gets withdrawal notice by id.
     *
     * @param id the id
     * @return the withdrawal notice by id
     */
    WithdrawalNotice getWithdrawalNoticeById(UUID id);

    /**
     * Gets withdrawal notice by product.
     *
     * @param product the product
     * @return the withdrawal notice by product
     * @throws IOException the io exception
     */
    List<WithdrawalNotice> getWithdrawalNoticeByProduct(Product product) throws IOException;
}

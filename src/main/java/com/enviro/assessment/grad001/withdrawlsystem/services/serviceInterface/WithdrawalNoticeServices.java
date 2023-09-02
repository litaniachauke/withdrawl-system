package com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface;

import com.enviro.assessment.grad001.withdrawlsystem.dto.WithdrawalNoticeDTO;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Product;
import com.enviro.assessment.grad001.withdrawlsystem.entities.WithdrawalNotice;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface WithdrawalNoticeServices {
    WithdrawalNoticeDTO createWithdrawalNotice(WithdrawalNoticeDTO withdrawalNotice);
    WithdrawalNotice updateWithdrawalNotice(WithdrawalNoticeDTO withdrawalNotice);
    boolean deleteWithdrawalNotice(UUID id);
    WithdrawalNotice getWithdrawalNoticeById(UUID id);
    List<WithdrawalNotice> getWithdrawalNoticeByProduct(Product product) throws IOException;
}

package com.enviro.assessment.grad001.withdrawlsystem.Repository;

import com.enviro.assessment.grad001.withdrawlsystem.entities.Product;
import com.enviro.assessment.grad001.withdrawlsystem.entities.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, UUID> {
    List<WithdrawalNotice> findByProduct(Product product);
}

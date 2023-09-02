package com.enviro.assessment.grad001.withdrawlsystem.entities;

import com.enviro.assessment.grad001.withdrawlsystem.dto.WithdrawalNoticeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    private Product product;
    private double amount;
    private LocalDateTime date;

    public WithdrawalNotice(Product product, double amount) {
        this.product = product;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public WithdrawalNoticeDTO toDTO(){
        return new WithdrawalNoticeDTO(id,product.toDTO(),amount,date);
    }
    public WithdrawalNotice fromDTO(WithdrawalNoticeDTO withdrawalNotice){
        return new WithdrawalNotice(withdrawalNotice.id(),new Product().fromDTO(withdrawalNotice.product()),withdrawalNotice.amount(),withdrawalNotice.date());
    }
}

package com.enviro.assessment.grad001.withdrawlsystem.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record WithdrawalNoticeDTO(
    UUID id,
    ProductDTO product,
    double amount,
    LocalDateTime date
) {
}

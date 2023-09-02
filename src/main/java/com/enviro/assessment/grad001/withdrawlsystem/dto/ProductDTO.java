package com.enviro.assessment.grad001.withdrawlsystem.dto;

import java.util.UUID;

public record ProductDTO(
    UUID id,
    String name,
    String description,
    InvestorDTO investor,
    String type,
    double currentBalance
) {
}

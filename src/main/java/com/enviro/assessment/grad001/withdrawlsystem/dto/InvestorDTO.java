package com.enviro.assessment.grad001.withdrawlsystem.dto;

import java.util.List;
import java.util.UUID;

public record InvestorDTO(
        UUID id,
        String firstName,
        String lastName,
        int age,
        String email,
        String phone,
        AddressDTO addressDTO,
        List<com.enviro.assessment.grad001.withdrawlsystem.entities.Product> productDTOS
) {
}

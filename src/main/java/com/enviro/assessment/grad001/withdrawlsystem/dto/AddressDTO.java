package com.enviro.assessment.grad001.withdrawlsystem.dto;

import java.util.UUID;

public record AddressDTO(
    UUID id,
    String street,
    String city,
    String province,
    String zip,
    String country
) {
}

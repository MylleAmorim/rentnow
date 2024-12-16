package com.alugueagora.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.Timestamp;

public record RentsDtos(@NotBlank String description, @NotBlank String summary , @NotNull Double price, @NotNull Double condominium, @NotNull Double fees, @NotNull Timestamp createAt) {

}

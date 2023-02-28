package com.farsousa.personalfinancesmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WalletCreateDto(
		@NotBlank
		String description,
		@NotNull
		Double balance
) {
	
}

package com.farsousa.personalfinancesmanager.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public record ActivityCreateDto(
		Short type,
		String description,
		Double value,
		Long walletId,
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		Date date,
		Short status
) {
	
}

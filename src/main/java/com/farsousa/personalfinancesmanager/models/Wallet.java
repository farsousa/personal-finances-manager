package com.farsousa.personalfinancesmanager.models;

import com.farsousa.personalfinancesmanager.dto.WalletCreateDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_wallet")
@Entity(name = "Wallet")
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private double balance;
	private boolean deleted;	
	
	public Wallet(WalletCreateDto walletCreateDto) {
		this.description = walletCreateDto.description();
		this.balance = walletCreateDto.balance();
		this.deleted = false;
	}

}

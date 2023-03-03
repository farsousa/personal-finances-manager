package com.farsousa.personalfinancesmanager.domains.entities;

import com.farsousa.personalfinancesmanager.dto.WalletCreateDto;

import jakarta.persistence.Column;
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
	@Column(name = "tw_id")
	private long id;
	@Column(name = "tw_description")
	private String description;
	@Column(name = "tw_balance")
	private double balance;
	@Column(name = "tw_deleted")
	private boolean deleted;	
	
	public Wallet(WalletCreateDto walletCreateDto) {
		this.description = walletCreateDto.description();
		this.balance = walletCreateDto.balance();
		this.deleted = false;
	}

}

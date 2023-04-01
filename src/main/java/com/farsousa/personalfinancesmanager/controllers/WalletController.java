package com.farsousa.personalfinancesmanager.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farsousa.personalfinancesmanager.domains.entities.Wallet;
import com.farsousa.personalfinancesmanager.dto.WalletCreateDto;
import com.farsousa.personalfinancesmanager.dto.WalletDeleteDto;
import com.farsousa.personalfinancesmanager.repositories.WalletRepository;

import jakarta.transaction.Transactional;

@RequestMapping("wallets")
@Controller
public class WalletController {
	
	@Autowired
	private WalletRepository walletRepository;	
	
	@PostMapping("create")
	@Transactional
	public String create(WalletCreateDto walletCreateDto, Model model) {	
		Wallet wallet = walletRepository.findByDescription(walletCreateDto.description());
		
		if(wallet != null) {
			wallet.setBalance(walletCreateDto.balance());
			wallet.setDeleted(false);
		}else {
			wallet.setBalance(walletCreateDto.balance());
			wallet.setDeleted(false);
			wallet.setDescription(walletCreateDto.description());
			walletRepository.save(wallet);
		}
		
		return "redirect:/activities";
	}
	
	@PostMapping("delete")
	@Transactional
	public String delete(WalletDeleteDto walletDeleteDto, Model model) {
		Optional<Wallet> wallet = walletRepository.findById(walletDeleteDto.id());
		if(!wallet.isEmpty()) {
			wallet.get().setDeleted(true);
			wallet.get().setBalance(0);
		}
		return "redirect:/activities";
	}

}

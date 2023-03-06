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

@RequestMapping("wallets")
@Controller
public class WalletController {
	
	@Autowired
	private WalletRepository walletRepository;	
	
	@PostMapping("create")
	public String create(WalletCreateDto walletCreateDto, Model model) {		
		Wallet wallet = new Wallet(walletCreateDto);
		walletRepository.save(wallet);			
		return "redirect:/activities";
	}
	
	@PostMapping("delete")
	public String delete(WalletDeleteDto walletDeleteDto, Model model) {
		Optional<Wallet> wallet = walletRepository.findById(walletDeleteDto.id());
		if(!wallet.isEmpty()) {
			walletRepository.delete(wallet.get());
		}
		return "redirect:/activities";
	}

}

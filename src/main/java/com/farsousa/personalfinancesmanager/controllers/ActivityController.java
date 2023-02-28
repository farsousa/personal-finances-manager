package com.farsousa.personalfinancesmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farsousa.personalfinancesmanager.models.Wallet;
import com.farsousa.personalfinancesmanager.repositories.WalletRepository;

@Controller
@RequestMapping("activities")
public class ActivityController {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@GetMapping("")
	public String index(Model model) {
		List<Wallet> wallets = walletRepository.findAll();
		model.addAttribute("wallets", wallets);		
		return "activities";
	}

}

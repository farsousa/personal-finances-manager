package com.farsousa.personalfinancesmanager.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farsousa.personalfinancesmanager.domains.entities.Activity;
import com.farsousa.personalfinancesmanager.domains.entities.Wallet;
import com.farsousa.personalfinancesmanager.repositories.ActivityRepository;
import com.farsousa.personalfinancesmanager.repositories.WalletRepository;

@Controller
@RequestMapping("activities")
public class ActivityController {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@GetMapping
	public String index(Model model) {
		List<Wallet> wallets = walletRepository.findAll();
		model.addAttribute("wallets", wallets);		
		
		List<Activity> activities = activityRepository.findByEffectiveDateMonth(new Date());
		model.addAttribute("activities", activities);	
		
		return "activities";
	}

}

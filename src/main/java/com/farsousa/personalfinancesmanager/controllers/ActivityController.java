package com.farsousa.personalfinancesmanager.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farsousa.personalfinancesmanager.domains.entities.Activity;
import com.farsousa.personalfinancesmanager.domains.entities.Wallet;
import com.farsousa.personalfinancesmanager.domains.enumarations.ActivityStatus;
import com.farsousa.personalfinancesmanager.domains.enumarations.ActivityType;
import com.farsousa.personalfinancesmanager.dto.ActivityCreateDto;
import com.farsousa.personalfinancesmanager.dto.WalletCreateDto;
import com.farsousa.personalfinancesmanager.repositories.ActivityRepository;
import com.farsousa.personalfinancesmanager.repositories.WalletRepository;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("activities")
public class ActivityController {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@GetMapping
	public String index(Model model) {
		List<Wallet> wallets = walletRepository.findByDeleted(false);
		model.addAttribute("wallets", wallets);		
		
		List<Activity> activities = activityRepository.findByEffectiveDateMonth(new Date());
		model.addAttribute("activities", activities);	
		
		Double total = 0.0;
		for(Wallet wallet: wallets) {
			total += wallet.getBalance();
		}
		model.addAttribute("total", total);
		
		return "pages/activities";
	}
	
	
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		Optional<Activity> activity = activityRepository.findById(id);
		
		if(activity.isEmpty()) {
			return "pages/activities";
		}
		
		model.addAttribute("activity", activity.get());
		
		return "pages/activity";
	}
	
	@GetMapping("changeStatus/{id}")
	@Transactional
	public String changeStatus(@PathVariable Long id, Model model) {
		Optional<Activity> activity = activityRepository.findById(id);
		
		if(activity.isEmpty()) {
			return "pages/activities";
		}
		
		activity.get().setStatus(ActivityStatus.Efetuado);
		activity.get().setEffectiveDate(new Date());
		
		model.addAttribute("activity", activity.get());
		
		return "pages/activity";
	}
	
	@PostMapping("create")
	@Transactional
	public String create(ActivityCreateDto activityCreateDto) {
		Optional<Wallet> wallet = walletRepository.findById(activityCreateDto.walletId());
		
		if(wallet.isEmpty()) {
			return "redirect:/activities";
		}
		
		Activity activity = new Activity();
		activity.setDescription(activityCreateDto.description());
		activity.setEffectiveDate(activityCreateDto.date());
		activity.setForecastDate(activityCreateDto.date());
		activity.setStatus(ActivityStatus.getByCode(activityCreateDto.status()));
		activity.setType(ActivityType.getActivityTypeByCode(activityCreateDto.type()));
		activity.setValue(activityCreateDto.value());
		activity.setWallet(wallet.get());
		activityRepository.save(activity);	
		
		wallet.get().setBalance(wallet.get().getBalance() - activity.getValue());
		
		return "redirect:/activities";
	}

}

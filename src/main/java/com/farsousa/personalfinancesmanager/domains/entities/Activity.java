package com.farsousa.personalfinancesmanager.domains.entities;

import java.util.Date;

import com.farsousa.personalfinancesmanager.domains.enumarations.ActivityStatus;
import com.farsousa.personalfinancesmanager.domains.enumarations.ActivityType;
import com.farsousa.personalfinancesmanager.dto.ActivityCreateDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_activity")
@Entity(name = "Activity")
public class Activity {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ta_id")
	private Long id;
	
	@Column(name = "ta_description")
	private String description;
	
	@Column(name = "ta_value")
	private Double value;
	
	@Column(name = "ta_effective_date")
	private Date effectiveDate;
	
	@Column(name = "ta_forecast_date")
	private Date forecastDate;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ta_status")
	private ActivityStatus status;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ta_type")
	private ActivityType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ta_tw_id", referencedColumnName = "tw_id")
	private Wallet wallet;
	
}

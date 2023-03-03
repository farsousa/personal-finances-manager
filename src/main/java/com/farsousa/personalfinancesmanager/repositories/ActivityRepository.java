package com.farsousa.personalfinancesmanager.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.farsousa.personalfinancesmanager.domains.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
	@Query(value = "SELECT * FROM tab_activity WHERE MONTH(ta_effective_date) = MONTH(:curdate) AND YEAR(ta_effective_date) = YEAR(:curdate) ORDER BY ta_effective_date DESC;", nativeQuery = true)
	public List<Activity> findByEffectiveDateMonth(@Param("curdate") Date curdate);

}

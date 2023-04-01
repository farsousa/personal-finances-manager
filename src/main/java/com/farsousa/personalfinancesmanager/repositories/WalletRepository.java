package com.farsousa.personalfinancesmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farsousa.personalfinancesmanager.domains.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

	public Wallet findByDescription(String description);

	public List<Wallet> findByDeleted(boolean deleted);

}

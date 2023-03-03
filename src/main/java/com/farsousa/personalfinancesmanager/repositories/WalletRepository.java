package com.farsousa.personalfinancesmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farsousa.personalfinancesmanager.domains.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

}

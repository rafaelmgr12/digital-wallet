package com.rafaelmgr12.digitalwallet.repository;


import com.rafaelmgr12.digitalwallet.entity.User;
import com.rafaelmgr12.digitalwallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    Wallet findByUser(User user);
}

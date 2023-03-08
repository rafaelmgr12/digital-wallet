package com.rafaelmgr12.digitalwallet.service;

import com.rafaelmgr12.digitalwallet.entity.User;
import com.rafaelmgr12.digitalwallet.repository.UserRepository;
import com.rafaelmgr12.digitalwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class TransferService {

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private UserRepository userRepository;

    public void transfer(String userId, String userId2, BigDecimal amount) {

        User user = userRepository.findById(UUID.fromString(userId)).orElseThrow();
        User user2 = userRepository.findById(UUID.fromString(userId2)).orElseThrow();
        BigDecimal balance = user.getWallet().getAmount();
        BigDecimal balance2 = user2.getWallet().getAmount();
        if (balance.compareTo(amount) >= 0) {
            user.getWallet().setAmount(balance.subtract(amount));
            user2.getWallet().setAmount(balance2.add(amount));
            walletRepository.save(user.getWallet());
            walletRepository.save(user2.getWallet());
        }
    }

}

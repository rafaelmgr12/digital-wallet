package com.rafaelmgr12.digitalwallet.service;

import com.rafaelmgr12.digitalwallet.dto.WalletDTO;
import com.rafaelmgr12.digitalwallet.entity.User;
import com.rafaelmgr12.digitalwallet.entity.Wallet;
import com.rafaelmgr12.digitalwallet.repository.UserRepository;
import com.rafaelmgr12.digitalwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;



    public WalletDTO createWalletByCPF(WalletDTO walletDTO, String cpf) {
        User user = userRepository.findByCpf(cpf);
        Wallet wallet = mapper.map(walletDTO, Wallet.class);
        wallet.setUser(user);
        walletRepository.save(wallet);
        return mapper.map(wallet, WalletDTO.class);
    }

    public WalletDTO createWalletByUserId(WalletDTO walletDTO, String userId) {
        User user = userRepository.findById(UUID.fromString(userId)).orElse(null);

        Wallet checkIsWalletExist = walletRepository.findByUserId(UUID.fromString(userId));
        if (checkIsWalletExist != null) {
            throw new RuntimeException("User has already a wallet exist");
        }
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Wallet wallet = mapper.map(walletDTO, Wallet.class);
        wallet.setUser(user);
        walletRepository.save(wallet);
        return mapper.map(wallet, WalletDTO.class);
    }



    public BigDecimal getBalance(String id) {
        Wallet wallet = walletRepository.findByUserId(UUID.fromString(id));
        return wallet.getAmount();
    }
}

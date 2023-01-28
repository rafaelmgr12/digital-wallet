package com.rafaelmgr12.digitalwallet.service;

import com.rafaelmgr12.digitalwallet.config.ModelMapperConfiguration;
import com.rafaelmgr12.digitalwallet.dto.WalletDTO;
import com.rafaelmgr12.digitalwallet.entity.User;
import com.rafaelmgr12.digitalwallet.entity.Wallet;
import com.rafaelmgr12.digitalwallet.repository.UserRepository;
import com.rafaelmgr12.digitalwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

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

    public WalletDTO createWalletbyEmail(WalletDTO walletDTO, String email) {
        User user = userRepository.findByEmail(email);
        Wallet wallet = mapper.map(walletDTO, Wallet.class);
        wallet.setUser(user);
        walletRepository.save(wallet);
        return mapper.map(wallet, WalletDTO.class);
    }

    public WalletDTO getWalletByCPF(String cpf) {
        User user = userRepository.findByCpf(cpf);
        Wallet wallet = walletRepository.findByUser(user);
        return mapper.map(wallet, WalletDTO.class);
    }

    public BigDecimal getAmountByEmail(String email) {
        User user = userRepository.findByEmail(email);
        Wallet wallet = walletRepository.findByUser(user);

        return wallet.getAmount();
    }
}

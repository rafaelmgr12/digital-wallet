package com.rafaelmgr12.digitalwallet.controller;

import com.rafaelmgr12.digitalwallet.dto.WalletDTO;
import com.rafaelmgr12.digitalwallet.service.WalletService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("wallets/{userId}")
    public ResponseEntity<BigDecimal> getWallet(@PathVariable(value = "userId") String userId) {
        BigDecimal amount = walletService.getBalance(userId);
        return ResponseEntity.ok(amount);
    }


    @Transactional()
    @PostMapping("wallets/{userId}")
    public ResponseEntity<WalletDTO> createWallet(@PathVariable(value = "userId") String userId,@RequestBody @Validated WalletDTO walletDTO, UriComponentsBuilder uriBuilder) {
        WalletDTO wallet = walletService.createWalletByUserId(walletDTO, userId);
        URI uri = uriBuilder.path("/wallets/{id}").buildAndExpand(wallet.getId()).toUri();
        return ResponseEntity.created(uri).body(wallet);

    }


}

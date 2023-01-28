package com.rafaelmgr12.digitalwallet.dto;

import com.rafaelmgr12.digitalwallet.entity.User;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletDTO {
    private UUID id;
    private BigDecimal amount;
    private User user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

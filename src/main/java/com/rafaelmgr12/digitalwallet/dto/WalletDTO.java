package com.rafaelmgr12.digitalwallet.dto;

import com.rafaelmgr12.digitalwallet.entity.User;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletDTO {
    private UUID uuid;
    private BigDecimal amount;
    private User user;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

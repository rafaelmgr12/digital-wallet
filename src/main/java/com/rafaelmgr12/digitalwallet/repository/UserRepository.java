package com.rafaelmgr12.digitalwallet.repository;

import com.rafaelmgr12.digitalwallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    User findByCpf(String cpf);
}

package com.rafaelmgr12.digitalwallet.controller;

import com.rafaelmgr12.digitalwallet.dto.TransferDTO;
import com.rafaelmgr12.digitalwallet.service.TransferService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @Transactional
    @PostMapping
    public ResponseEntity<Object> transfer(@RequestBody @Validated TransferDTO transferDTO,  UriComponentsBuilder uriBuilder) {
        transferService.transfer(transferDTO.getUserId(), transferDTO.getUserId2(), transferDTO.getAmount());
        return ResponseEntity.ok().build();
    }
}

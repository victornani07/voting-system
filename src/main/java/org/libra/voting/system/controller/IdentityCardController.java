package org.libra.voting.system.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.libra.voting.system.model.request.SaveIdentityCardRequest;
import org.libra.voting.system.model.response.SaveIdentityCardResponse;
import org.libra.voting.system.service.IdentityCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/identity-card")
@RequiredArgsConstructor
@Slf4j
public class IdentityCardController {

    private final IdentityCardService identityCardService;

    @PostMapping
    public ResponseEntity<SaveIdentityCardResponse> registerIdentityCard(@RequestBody SaveIdentityCardRequest request) {
        log.info("Request to register the Identity Card has been received.");

        var saveIdentityCardResponse = identityCardService.saveIdentityCard(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(saveIdentityCardResponse);
    }
}

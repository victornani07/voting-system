package org.libra.voting.system.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.libra.voting.system.model.request.SaveIdentityCardRequest;
import org.libra.voting.system.model.response.SaveIdentityCardResponse;
import org.libra.voting.system.repository.IdentityCardRepository;
import org.springframework.stereotype.Service;

import static org.libra.voting.system.utils.IdentityCardTransformers.convertIdentityCardEntityToSaveIdentityCardResponse;
import static org.libra.voting.system.utils.IdentityCardTransformers.convertSaveIdentityCardRequestToIdentityCardEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class IdentityCardService {

    private final IdentityCardRepository identityCardRepository;

    public SaveIdentityCardResponse saveIdentityCard(SaveIdentityCardRequest request) {
        var identityCardEntity = convertSaveIdentityCardRequestToIdentityCardEntity(request);
        var savedIdentityCardEntity = identityCardRepository.save(identityCardEntity);

        log.info("Identity Card has been successfully saved with ICID=[{}].", savedIdentityCardEntity.getId());

        return convertIdentityCardEntityToSaveIdentityCardResponse(savedIdentityCardEntity);
    }
}

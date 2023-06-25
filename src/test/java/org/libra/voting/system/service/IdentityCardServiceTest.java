package org.libra.voting.system.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.libra.voting.system.repository.IdentityCardRepository;
import org.libra.voting.system.utils.TestConstants;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.libra.voting.system.utils.TestConstants.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IdentityCardServiceTest {

    @Mock
    private IdentityCardRepository identityCardRepository;

    @InjectMocks
    private IdentityCardService identityCardService;

    @Test
    void whenSavingIdentityCardEntity_shouldReturnSaveIdentityCardResponse() {
        var savedIdentityCardEntity = IDENTITY_CARD_ENTITY.toBuilder()
            .id(ID_1)
            .build();
        when(identityCardRepository.save(IDENTITY_CARD_ENTITY)).thenReturn(savedIdentityCardEntity);

        var actual = identityCardService.saveIdentityCard(SAVE_IDENTITY_CARD_REQUEST);

        verify(identityCardRepository).save(IDENTITY_CARD_ENTITY);

        assertEquals(SAVE_IDENTITY_CARD_RESPONSE, actual);
    }
}
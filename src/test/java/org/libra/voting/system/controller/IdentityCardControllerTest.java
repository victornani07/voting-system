package org.libra.voting.system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.libra.voting.system.service.IdentityCardService;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.libra.voting.system.utils.TestConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = IdentityCardController.class)
class IdentityCardControllerTest {

    @MockBean
    IdentityCardService identityCardService;

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void whenRegisteringIdentityCard_shouldReturnResponseEntityCreated() throws Exception {
        Mockito.when(identityCardService.saveIdentityCard(SAVE_IDENTITY_CARD_REQUEST))
            .thenReturn(SAVE_IDENTITY_CARD_RESPONSE);

        mvc.perform(post(IDENTITY_CARD_CONTROLLER_REQUEST_MAPPING_PATH)
                .content(objectMapper.writeValueAsString(SAVE_IDENTITY_CARD_REQUEST))
                .contentType(APPLICATION_JSON))
            .andExpect(status().isCreated()
        ).andExpect(content().string(objectMapper.writeValueAsString(SAVE_IDENTITY_CARD_RESPONSE)));
    }
}
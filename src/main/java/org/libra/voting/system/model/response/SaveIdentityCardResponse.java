package org.libra.voting.system.model.response;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import org.libra.voting.system.model.data.ErrorData;
import org.libra.voting.system.model.data.SaveIdentityCardData;

@Value
@Builder
@ToString
public class SaveIdentityCardResponse {

    SaveIdentityCardData saveIdentityCardData;

    ErrorData errorData;
}

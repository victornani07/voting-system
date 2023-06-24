package org.libra.voting.system.model.data;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString
public class ErrorData {

    String code;

    String message;
}

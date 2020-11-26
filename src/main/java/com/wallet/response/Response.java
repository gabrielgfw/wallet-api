package com.wallet.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// Tipo 'T' pois poderá haver várias possibilidades.

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {

    private T data;
    private List<String> errors;
}

package com.clydoskope.code.spec;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRequestEntity {

    private String userId;
    private String password;
}

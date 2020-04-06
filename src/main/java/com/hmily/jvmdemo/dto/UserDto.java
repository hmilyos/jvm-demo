package com.hmily.jvmdemo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDto implements Serializable {

    private Integer id;
    private String name;
}

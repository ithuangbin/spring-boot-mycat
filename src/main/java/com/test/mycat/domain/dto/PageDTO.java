package com.test.mycat.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer current;
    @NotNull
    private Integer pageSize;
}

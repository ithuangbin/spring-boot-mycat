package com.test.mycat.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int current;
    private long total;
    private int pageSize;
    private List<T> data;

}

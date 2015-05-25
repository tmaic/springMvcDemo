package com.demo.domain.page;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tmaic on 15-5-25.
 * 页面分页展示类
 */

@Data
public class TableData<T> implements Serializable {


    private static final long serialVersionUID = -8164137183285105071L;

    @JsonProperty("sEcho")
    private int sEcho;

    @JsonProperty("iTotalRecords")
    private int totalRecords;

    @JsonProperty("iTotalDisplayRecords")
    private int totalDisplayRecords;

    @JsonProperty("aaData")
    private List<T> results;

}

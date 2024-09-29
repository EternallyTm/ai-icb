package com.icb.common.model;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -5916634771382762979L;

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalCount;
    /**
     * 页码总数
     */
    private int totalPage;
    /**
     * 数据集合
     */
    private List<T> records;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

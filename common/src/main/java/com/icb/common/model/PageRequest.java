package com.icb.common.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class PageRequest<T> implements Serializable {

    private static final long serialVersionUID = -6380378186325034951L;

    private static final Pattern pattern = Pattern.compile("[A-Z]");

    public static final int DEFAULT_PAGE_NUM = 1;

    public static final int DEFAULT_PAGE_SIZE = 10;

    public static final int MAX_PAGE_SIZE = 1000;

    public static final String DEFAULT_ORDER_BY_FIELD = "id";

    public static final Direction DEFAULT_PAGE_ORDER = Direction.DESC;

    /**
     * 当前页码
     */
    private int pageNum = DEFAULT_PAGE_NUM;
    /**
     * 每页数量
     */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 分页开始条数
     */
    private int pageStart;
//    /**
//     * 排序字段，默认按id排序
//     */
//    private String orderBy = DEFAULT_ORDER_BY_FIELD;
//    /**
//     * 排序字段规则，默认降序排序
//     */
//    private Direction direction = DEFAULT_PAGE_ORDER;
    /**
     * 查询参数
     */
    private T param;

    /**
     * 排序字段规则枚举
     */
    public enum Direction {
        /**
         * 升序
         */
        ASC("asc"),
        /**
         * 降序
         */
        DESC("desc");

        /**
         * 编码
         */
        private String code;

        Direction(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public void setPageStart() {
        this.pageStart = (pageNum - 1) * pageSize;
    }

    public Integer getPageStart() {
        return (pageNum - 1) * pageSize;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = Math.max(pageNum, 1);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = Math.min(pageSize, MAX_PAGE_SIZE);
    }

//    public String buildOrderBy() {
//        orderBy = StringUtils.isNotBlank(orderBy) ? orderBy : DEFAULT_ORDER_BY_FIELD;
//        direction = direction != null ? direction : DEFAULT_PAGE_ORDER;
//        return convert2ColumnName(orderBy) + " " + direction;
//    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    /**
     * 属性名称转表字段名称
     **/
    private String convert2ColumnName(String fieldName) {
        if (StringUtils.isBlank(fieldName)) {
            return fieldName;
        }

        Matcher matcher = pattern.matcher(fieldName);
        while (matcher.find()) {
            String old = matcher.group();
            String ne = matcher.group().toLowerCase();
            fieldName = fieldName.replaceAll(old, "_" + ne);
        }
        return fieldName;
    }
}
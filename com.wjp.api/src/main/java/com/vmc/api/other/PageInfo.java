package com.vmc.api.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> {

    /**
     * 页面大小
     */
    private Long pageSize;
    /**
     * 总页数
     */
    private Long pageCount;
    /**
     * 总行数
     */
    private Long total;
    /**
     * 当前页
     */
    private Long currentPage;
    /**
     * 返回信息
     */
    private List<T> rows;

    public PageInfo(List<T> data, Long pageSize, Long pageCount, Long total, Long currentPage) {
        this.rows = data;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.total = total;
        this.currentPage = currentPage;
    }
}

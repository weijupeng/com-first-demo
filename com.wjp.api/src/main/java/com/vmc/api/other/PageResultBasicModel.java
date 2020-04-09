package com.vmc.api.other;


import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author : Wuxi
 */
public class PageResultBasicModel<T, E> {
    /**
     * 创建分页返回
     *
     * @param pages mybits-puls分页对象
     * @param data  数据对象
     * @return PageInfo<Object>
     */
    public PageInfo<Object> createPageInfo(IPage<T> pages, List<E> data) {
        return new PageInfo(
                data, pages.getSize(), pages.getPages(), pages.getTotal(), pages.getCurrent());
    }

    /**
     * 创建分页返回
     *
     * @param pages mybits-puls分页对象
     * @return PageInfo<Object>
     */
    public PageInfo<Object> createPageInfo(IPage<T> pages) {
        return new PageInfo(pages.getRecords(), pages.getSize(), pages.getPages(), pages.getTotal(), pages.getCurrent());
    }
}

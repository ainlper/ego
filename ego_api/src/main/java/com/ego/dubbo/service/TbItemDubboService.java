package com.ego.dubbo.service;

import com.ego.pojo.TbItem;

import java.util.List;

/**
 * 只对数据库进行操作
 * 对商品表的操作
 */
public interface TbItemDubboService {
    /**
     * 分页查询
     *
     * @param pageSize   每页的大小
     * @param pageNumber 页码
     * @return 当前页显示的数据
     */
    List<TbItem> selectByPage(int pageSize, int pageNumber);
 
    /**
     * 查询总条数
     *
     * @return总条数
     */
    long selectCount();
}

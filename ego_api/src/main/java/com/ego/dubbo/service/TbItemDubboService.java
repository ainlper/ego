package com.ego.dubbo.service;

import com.ego.commons.exception.DaoException;
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

    /**
     * 事务一定写在provider中
     * 批量修改
     *
     * @param ids    所有要修改的id
     * @param status 修改的状态值
     * @return 成功1，失败0
     */
    int updateStatusByIds(long[] ids, int status) throws DaoException;
}

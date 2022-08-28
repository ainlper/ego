package com.ego.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;

/**
 * 试图逻辑
 */
public interface TbItemService {
    /*
    方法的返回值为页面要的东西
    方法的参数为页面传递过来的东西
     */

    /**
     * 分页显示商品信息
     *
     * @param pages 页码
     * @param rows  页面大小
     * @return EasyUI要的模板数据
     */
    EasyUIDatagrid showItem(int pages, int rows);

    /**
     * 操作状态值
     * @param ids
     * @param status
     * @return
     */
    EgoResult uodateStatus(long[] ids, int status);
}


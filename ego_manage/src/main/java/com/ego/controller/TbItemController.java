package com.ego.controller;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TbItemController {
    @Autowired
    private TbItemService tbItemService;

    /**
     * 分页显示商品
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDatagrid showItem(int page, int rows) {
        return tbItemService.showItem(page, rows);
    }


    /**
     * 删除商品（修改商品的status状态值为3）
     * 逻辑上的删除，数据是无价的（数据仍然在数据库中，只是修改状态为已删除）
     * 实质实质性的update语句
     *
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/delete")
    @ResponseBody
    public EgoResult delete(long[] ids) {
        return tbItemService.uodateStatus(ids, 3);
    }

    /**
     * 上架商品（修改商品的status状态值为1）
     *
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/reshelf")
    @ResponseBody
    public EgoResult reshelf(long[] ids) {
        return tbItemService.uodateStatus(ids, 1);
    }

    /**
     * 下架商品（修改商品的status状态值为3）
     *
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/instock")
    @ResponseBody
    public EgoResult instock(long[] ids) {
        return tbItemService.uodateStatus(ids, 2);
    }
}

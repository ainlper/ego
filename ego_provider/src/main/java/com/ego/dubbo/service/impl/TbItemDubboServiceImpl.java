package com.ego.dubbo.service.impl;

import com.ego.commons.exception.DaoException;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.mapper.TbItemMapper;
import com.ego.pojo.TbItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

// 使用Apache的注解 把当前类实现的接口发布到zookeeper中
@Service
public class TbItemDubboServiceImpl implements TbItemDubboService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public List<TbItem> selectByPage(int pageSize, int pageNumber) {
        // 分页插件要写在查询的上面
        PageHelper.startPage(pageNumber, pageSize);
        // Example 相当于sql语句中的where，没有where时参数为null
        List<TbItem> list = tbItemMapper.selectByExample(null);
        PageInfo<TbItem> pi = new PageInfo<TbItem>(list);
        return pi.getList();
    }

    @Override
    public long selectCount() {
        return tbItemMapper.countByExample(null);
    }

    @Override
    // 监听到异常执行事务回滚 （声明式事务注解）
    @Transactional
    public int updateStatusByIds(long[] ids, int status) throws DaoException {
        int index = 0;
        for (long id : ids) {
            TbItem tbItem = new TbItem();
            tbItem.setId(id);
            tbItem.setStatus((byte) status);
            tbItem.setUpdated(new Date());
            index += tbItemMapper.updateByPrimaryKeySelective(tbItem);
        }
        if (index == ids.length) {
            return 1;
        }
        // 抛出异常 事务回滚
        throw new DaoException("批量修改失败！");
    }


}

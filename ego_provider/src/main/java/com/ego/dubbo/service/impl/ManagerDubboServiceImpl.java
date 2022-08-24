package com.ego.dubbo.service.impl;

import com.ego.dubbo.service.ManagerDubboService;
import com.ego.mapper.ManagerMapper;
import com.ego.pojo.Manager;
import com.ego.pojo.ManagerExample;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//provider方导入Apache的service
@Service
public class ManagerDubboServiceImpl implements ManagerDubboService {


    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager selectManagerByUserName(String username) {
        ManagerExample me = new ManagerExample();//查询体
        me.createCriteria().andUsernameEqualTo(username);//创建查询体并根据应户名进行查询
        List<Manager> managers = managerMapper.selectByExample(me);
        if (managers != null && managers.size() != 0) {
            return managers.get(0);
        }
        return null;
    }
}

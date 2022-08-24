package com.ego.dubbo.service;

import com.ego.pojo.Manager;

/**
 * 对manager表进行操作
 * SpringSecurity登录
 */
public interface ManagerDubboService {
    /**
     * 根据用户名查询密码
     */
    Manager selectManagerByUserName(String username);
}

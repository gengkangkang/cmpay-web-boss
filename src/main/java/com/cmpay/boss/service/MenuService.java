package com.cmpay.boss.service;

import java.util.List;

import com.cmpay.boss.domain.MenuBO;

/**
 * Created by APPLE on 16/1/12.
 */
public interface MenuService {
    List<MenuBO> getAllEnabledMenu();

    List<MenuBO> getAllEnabledMenuByUserId(String userid);
}

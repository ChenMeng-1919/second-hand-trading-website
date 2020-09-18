package com.jzh.xx.transaction.service;


import com.jzh.xx.transaction.domain.XxUser;
import com.jzh.xx.transaction.dto.ComResult;
import com.jzh.xx.transaction.dto.PageInfo;

import java.util.Map;

public interface UserService {
    XxUser login(String phone, String password);

    void register(String realname,String phone,String username,String password);

    boolean verPhone(String phone);

    PageInfo<XxUser> page(int draw, int start, int length, XxUser user);

    void delete(Long id);

    void save(XxUser user);

    XxUser getById(Long id);

    void deleteMulti(Integer[] ids);

    ComResult updateInfo(XxUser xxUser);

    ComResult checkXxUser(XxUser xxUser);

    void deleteSelected(String[] sIds);

    int getUserCount();
}

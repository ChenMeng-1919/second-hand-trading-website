package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.XxUser;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

public interface XxUserMapper extends MyMapper<XxUser> {
    /**
     * 查询用户
     * @param phone
     * @return
     */
    XxUser getByPhone(String phone);

    XxUser getByUsername(String username);

    List<XxUser> page(Map<String,Object> params);

    void deleteMulti(Integer[] ids);

    int getUserCount();
}
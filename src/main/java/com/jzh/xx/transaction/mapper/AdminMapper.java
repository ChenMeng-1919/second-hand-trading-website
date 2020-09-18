package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.Admin;
import tk.mybatis.MyMapper;

public interface AdminMapper extends MyMapper<Admin> {
    Admin getByUsername(String username);
}
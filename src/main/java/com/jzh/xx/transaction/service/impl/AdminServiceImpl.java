package com.jzh.xx.transaction.service.impl;

import com.jzh.xx.transaction.domain.Admin;
import com.jzh.xx.transaction.mapper.AdminMapper;
import com.jzh.xx.transaction.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username,String password) {
        Admin admin = adminMapper.getByUsername(username);

        if(admin != null){
            if (admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }
}

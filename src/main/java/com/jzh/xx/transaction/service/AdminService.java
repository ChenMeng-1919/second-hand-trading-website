package com.jzh.xx.transaction.service;

import com.jzh.xx.transaction.domain.Admin;

public interface AdminService {
    Admin login(String username,String password);
}

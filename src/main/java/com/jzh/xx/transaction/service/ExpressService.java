package com.jzh.xx.transaction.service;

import com.jzh.xx.transaction.domain.Express;
import com.jzh.xx.transaction.dto.PageInfo;

import java.util.List;

public interface ExpressService {
    PageInfo<Express> page(int draw, int start, int length, Express express);

    void save(Express express);

    Express getById(int id);

    void deleteOne(int id);

    List<Express> getAll();

    void delSelected(String[] sIds);
}

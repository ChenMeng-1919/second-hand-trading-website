package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.Express;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

public interface ExpressMapper extends MyMapper<Express> {
    List<Express>  expressPage(Map<String,Object> params);
}
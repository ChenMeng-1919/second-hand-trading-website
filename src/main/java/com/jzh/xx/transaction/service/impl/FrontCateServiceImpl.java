package com.jzh.xx.transaction.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzh.xx.transaction.domain.Goods;
import com.jzh.xx.transaction.dto.PageResult;
import com.jzh.xx.transaction.mapper.GoodsMapper;
import com.jzh.xx.transaction.service.FrontCateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FrontCateServiceImpl implements FrontCateService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public PageResult<Goods> goodsPage(int pageNum, Long categoryId) {
        //一页的数量
        int pageSize = 6;
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsMapper.getByCate(categoryId);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);

        //获取分页结果
        List<Goods> goods = goodsPageInfo.getList();
        //创建一个分页对象
        PageResult<Goods> pageResult = new PageResult<>();
        //第几页
        pageResult.setPageNum(pageNum);
        //分页数据
        pageResult.setList(goods);
        //数据总条数
        Long total = goodsPageInfo.getTotal();
        pageResult.setTotal(total.intValue());
        //总页数
        int pageTotal = (total.intValue() + pageSize ) / pageSize;
        pageResult.setPageTotal(pageTotal);

        return pageResult;
    }
}

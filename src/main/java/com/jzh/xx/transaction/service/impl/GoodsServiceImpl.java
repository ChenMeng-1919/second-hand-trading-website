package com.jzh.xx.transaction.service.impl;

import com.jzh.xx.transaction.domain.Goods;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.mapper.GoodsMapper;
import com.jzh.xx.transaction.service.GoodsService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Goods detail(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> showChosen() {
        List<Goods> chosen = goodsMapper.getChosen();
        return chosen;
    }

    @Override
    public List<Goods> showAll() {
        List<Goods> goodsList = goodsMapper.selectAll();
        return goodsList;
    }

    @Override
    public List<Goods> showCheaper() {
        List<Goods> cheaper = goodsMapper.getCheaper();
        return cheaper;
    }

    @Override
    public List<Goods> showByCate(Long categoryId) {
        List<Goods> goodsByCate = goodsMapper.getByCate(categoryId);
        return goodsByCate;
    }

    @Override
    public List<Goods> getBySellerId(Long sellerId) {
        Example example = new Example(Goods.class);
        example.createCriteria().andEqualTo("sellerId",sellerId);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Goods> page(int draw, int start, int length, Goods goods) {
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("goods",goods);

        int count = goodsMapper.selectCount(goods);
        PageInfo<Goods> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(goodsMapper.goodsPage(params));

        return pageInfo;
    }

    @Override
    public void save(Goods goods) {
        //设置更新时间
        goods.setUpdated(new Date());

        if (goods.getId() == null){
            goods.setCreated(new Date());
            goodsMapper.insertSelective(goods);
        }
        else {
            goodsMapper.updateByPrimaryKeySelective(goods);
        }
    }

    @Override
    public void updateJb(Long goodsId, int selected) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if (selected == 1){
            goods.setJbStatus((byte) 2);
            goodsMapper.updateByPrimaryKeySelective(goods);
        }else{
            goods.setJbStatus((byte) 1);
            goodsMapper.updateByPrimaryKeySelective(goods);
        }
    }

    @Override
    public void delete(Long id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            goodsMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public double getTotalSum() {
        return goodsMapper.getTotalSum();
    }

    @Override
    public int getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }

    @Override
    public void delSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            goodsMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Map<String, Object> IndexInfoBySellerId(Long id) {
        Map<String,Object> map =new HashMap<>();

        int countBySellerId = goodsMapper.GoodsCountBySellerId(id);
        map.put("countBySellerId",countBySellerId);

        Example example = new Example(Goods.class);
        example.createCriteria().andEqualTo("sellerId",id).andEqualTo("sellStatus",0);
        List<Goods> goods = goodsMapper.selectByExample(example);
        int soldCount = goods.size();
        double soldMoney =0;
        for (Goods good : goods) {
            soldMoney += good.getPrice();
        }
        map.put("soldCount",soldCount);
        map.put("soldMoney",soldMoney);

        return map;
    }

    @Override
    public List<Goods> searchSome(String search) {
        Example example = new Example(Goods.class);
        example.createCriteria().andLike("goodsName","%"+search+"%");
        List<Goods> goods = goodsMapper.selectByExample(example);
        return goods;
    }

}

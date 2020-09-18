package com.jzh.xx.transaction.service.impl;

import com.jzh.xx.transaction.domain.Seller;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.mapper.SellerMapper;
import com.jzh.xx.transaction.service.SellerService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService {
    @Resource
    private SellerMapper sellerMapper;

    @Override
    public Seller seller(Long id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Seller> page(int draw, int start, int length, Seller seller) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("Seller", seller);

        int count = sellerMapper.selectCount(seller);
        PageInfo<Seller> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(sellerMapper.sellerPage(params));

        return pageInfo;
    }

    /**
     * 保存卖家信息
     *
     * @param seller
     */
    @Override
    public void save(Seller seller) {
        seller.setUpdated(new Date());
        if (seller.getId() == null) {
            seller.setCreated(new Date());
            sellerMapper.insert(seller);
        } else {
            sellerMapper.updateByPrimaryKey(seller);
        }
    }

    @Override
    public Seller getById(Long id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    /**
     * 卖家登录
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public Seller login(String phone, String password) {
        Example example = new Example(Seller.class);
        example.createCriteria().andEqualTo("phone",phone);
        Seller seller = sellerMapper.selectOneByExample(example);
        if (seller != null) {
            if (seller.getPassword().equals(password)) {
                return seller;
            }
        }
        return null;
    }

    /**
     * 注册
     * @return
     */
    @Override
    public void register(String realname,String phone,String city,String password) {
        if (!StringUtils.isEmpty(phone) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(realname) &&  !StringUtils.isEmpty(city)){
            Seller seller = new Seller();
            seller.setSellerName(realname);
            seller.setPhone(phone);
            seller.setCity(city);
            seller.setPassword(password);
            seller.setCreated(new Date());
            seller.setUpdated(new Date());
            sellerMapper.insert(seller);
        }
    }

    /**
     * 删除商家
     * @param id
     */
    @Override
    public void delete(Long id) {
        sellerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            sellerMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int getSellerCount() {
        return sellerMapper.getSellerCount();
    }


    @Override
    public String getReputation(Long id) {
        Seller seller = sellerMapper.selectByPrimaryKey(id);
        String reputation = seller.getReputation();
        return reputation;
    }
}

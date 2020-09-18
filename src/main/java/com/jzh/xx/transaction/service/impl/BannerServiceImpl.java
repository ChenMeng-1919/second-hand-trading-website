package com.jzh.xx.transaction.service.impl;

import com.jzh.xx.transaction.domain.Banner;
import com.jzh.xx.transaction.mapper.BannerMapper;
import com.jzh.xx.transaction.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl  implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> showBanner() {
        List<Banner> banners = bannerMapper.selectAll();
        return banners;
    }
}

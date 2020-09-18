package com.jzh.xx.transaction.controller.admin;

import com.jzh.xx.transaction.domain.Goods;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/goods")
public class AdminGoodsController {

    @Resource
    private GoodsService goodsService;


    /**
     * 遍历商品信息
     * @param request
     * @param goods
     * @return
     */
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Goods> pageInfo(HttpServletRequest request, Goods goods){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0: Integer.parseInt(strdraw);
        int start = strstart == null ? 0: Integer.parseInt(strstart);
        int length = strlength == null ? 10: Integer.parseInt(strlength);

        PageInfo<Goods> pageInfo = goodsService.page(draw,start,length,goods);
        return pageInfo;
    }

    @GetMapping("list")
    public String toAllGoods(HttpSession session){
        return "admin/goods_manager";
    }

    /**
     * 修改商品便签
     * @param selected
     * @param goodsId
     */
    @PostMapping("toCheapest")
    @ResponseBody
    public void change(int selected,Long goodsId){
        goodsService.updateJb(goodsId,selected);
    }


    /**
     * 删除选中
     * @param ids
     * @return
     */
    @GetMapping("delSelected")
    public String delSelected(String ids){
        String sIds[] = ids.split(",");
        goodsService.deleteSelected(sIds);
        return "admin/goods_manager";
    }

}

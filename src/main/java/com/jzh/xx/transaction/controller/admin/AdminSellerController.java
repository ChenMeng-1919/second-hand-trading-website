package com.jzh.xx.transaction.controller.admin;

import com.jzh.xx.transaction.domain.Seller;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/seller")
public class AdminSellerController {
    @Resource
    private SellerService sellerService;

    /**
     * 遍历商家信息
     * @param request
     * @param seller
     * @return
     */
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Seller> pageInfo(HttpServletRequest request,Seller seller){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0: Integer.parseInt(strdraw);
        int start = strstart == null ? 0: Integer.parseInt(strstart);
        int length = strlength == null ? 10: Integer.parseInt(strlength);

        PageInfo<Seller> pageInfo = sellerService.page(draw,start,length,seller);
        return pageInfo;
    }

    @GetMapping("list")
    public String list(){
        return "admin/seller_manager";
    }

    @GetMapping("add")
    public String add(){
        return "admin/seller_add";
    }

    /**
     * 保存卖家信息
     * @param seller
     * @return
     */
    @PostMapping("save")
    public String save(Seller seller){
        sellerService.save(seller);
        return "admin/seller_manager";
    }

    /**
     * 修改信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("update")
    public String update(Long id, Model model){
        Seller seller = sellerService.getById(id);
        model.addAttribute("seller",seller);
        return "admin/seller_update";
    }

    /**
     * 删除商家
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String deleteOne(Long id){
        sellerService.delete(id);
        return "admin/seller_manager";
    }

    /**
     * 删除选中
     * @param ids
     * @return
     */
    @GetMapping("delSelected")
    public String delSelected(String ids){
        String sIds[] = ids.split(",");
        sellerService.delSelected(sIds);
        return "admin/seller_manager";
    }

}

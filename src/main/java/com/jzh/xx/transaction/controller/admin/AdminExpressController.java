package com.jzh.xx.transaction.controller.admin;

import com.jzh.xx.transaction.domain.Express;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.service.ExpressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/express")
public class AdminExpressController {

    @Resource
    private ExpressService expressService;

    /**
     * 遍历快递信息
     * @param request
     * @param express
     * @return
     */
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Express> pageInfo(HttpServletRequest request,Express express){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0: Integer.parseInt(strdraw);
        int start = strstart == null ? 0: Integer.parseInt(strstart);
        int length = strlength == null ? 10: Integer.parseInt(strlength);

        PageInfo<Express> pageInfo = expressService.page(draw,start,length,express);
        return pageInfo;
    }

    @GetMapping("list")
    public String list(){
        return "admin/express_manager";
    }

    @GetMapping("add")
    public String add(){
        return "admin/express_add";
    }

    /**
     * 保存
     * @param express
     * @return
     */
    @PostMapping("save")
    public String save(Express express){
        expressService.save(express);
        return "admin/express_manager";
    }

    /**
     * 更新
     * @param id
     * @param model
     * @return
     */
    @GetMapping("update")
    public String update(int id, Model model){
        Express express = expressService.getById(id);
        model.addAttribute("express",express);
        return "admin/express_update";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String deleteOne(int id){
        expressService.deleteOne(id);
        return "admin/express_manager";
    }

    /**
     * 删除选中
     * @param ids
     * @return
     */
    @GetMapping("delSelected")
    public String delSelected(String ids){
        String sIds[] = ids.split(",");
        expressService.delSelected(sIds);
        return "admin/express_manager";
    }
}

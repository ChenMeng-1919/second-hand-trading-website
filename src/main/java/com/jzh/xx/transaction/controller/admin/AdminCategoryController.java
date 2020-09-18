package com.jzh.xx.transaction.controller.admin;

import com.jzh.xx.transaction.domain.Category;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/category")
public class AdminCategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("list")
    public String list(){
        return "admin/category_manager";
    }

    /**
     * 分页显示
     * @param request
     * @param category
     * @return
     */
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Category> pageInfo(HttpServletRequest request,Category category){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0: Integer.parseInt(strdraw);
        int start = strstart == null ? 0: Integer.parseInt(strstart);
        int length = strlength == null ? 10: Integer.parseInt( strlength);

        PageInfo<Category> pageInfo = categoryService.page(draw,start,length,category);
        return pageInfo;
    }

    /**
     * 保存分类
     * @param category
     * @return
     */
    @PostMapping("save")
    public String save(Category category){
        categoryService.save(category);
        return "admin/category_manager";
    }

    /**
     * 更新分类
     * @param id
     * @param model
     * @return
     */
    @GetMapping("update")
    public String update(Long id, Model model){
        Category category = categoryService.getById(id);
        model.addAttribute("category",category);
        return "admin/category_update";
    }

    /**
     * 添加分类
     * @return
     */
    @GetMapping("add")
    public String add(){
        return "admin/category_add";
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String deleteOne(int id){
        categoryService.deleteOne(id);
        return "admin/category_manager";
    }

    /**
     * 删除选中
     * @param ids
     * @return
     */
    @GetMapping("delSelected")
    public String delSelected(String ids){
        String sIds[] = ids.split(",");
        categoryService.deleteSelected(sIds);
        return "admin/category_manager";
    }
}

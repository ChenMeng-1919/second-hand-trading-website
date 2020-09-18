package com.jzh.xx.transaction.controller.admin;

import com.jzh.xx.transaction.domain.XxUser;
import com.jzh.xx.transaction.dto.ComResult;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 遍历用户信息
     * @param request
     * @param user
     * @return
     */
    @GetMapping("page")
    @ResponseBody
    public PageInfo<XxUser> pageInfo(HttpServletRequest request, XxUser user){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0: Integer.parseInt(strdraw);
        int start = strstart == null ? 0: Integer.parseInt(strstart);
        int length = strlength == null ? 10: Integer.parseInt(strlength);

        PageInfo<XxUser> pageInfo = userService.page(draw,start,length,user);
        return pageInfo;
    }

    @GetMapping("list")
    public String list(){
        return "admin/user_manager";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String deleteOne(Long id){
        userService.delete(id);
        return "admin/user_manager";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteMulti")
    @ResponseBody
    public ComResult delete(Integer[] ids){
        ComResult comResult = null;
        if (ids != null){
            comResult = ComResult.success("删除用户成功");
            userService.deleteMulti(ids);
        }
        else{
            comResult = ComResult.fail("删除用户失败");
        }
        return comResult;
    }

    /**
     * 删除选中
     * @param ids
     * @return
     */
    @GetMapping("delSelected")
    public String delSelected(String ids){
        String sIds[] = ids.split(",");
        userService.deleteSelected(sIds);
        return "admin/user_manager";
    }

    @GetMapping("add")
    public String add(){
        return "admin/user_add";
    }

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @PostMapping("save")
    public String save(XxUser user){
        userService.save(user);
        return "admin/user_manager";
    }

    /**
     * 修改用户信息
     */
    @GetMapping("update")
    public String update(Long id, Model model){
        XxUser user = userService.getById(id);
        model.addAttribute("user",user);
        return "admin/user_update";
    }


}

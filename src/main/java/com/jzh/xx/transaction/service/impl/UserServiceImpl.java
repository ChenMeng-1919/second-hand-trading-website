package com.jzh.xx.transaction.service.impl;

import com.jzh.xx.transaction.domain.XxUser;
import com.jzh.xx.transaction.dto.ComResult;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.mapper.XxUserMapper;
import com.jzh.xx.transaction.service.UserService;
import com.jzh.xx.transaction.utils.RegexUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private XxUserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    @Override
    public XxUser login(String phone, String password) {
//        String key = "user_"+phone;
//        ValueOperations<String,XxUser> operations = redisTemplate.opsForValue();
//
//        boolean haskey = redisTemplate.hasKey(key);
//
//            if (haskey){
//                XxUser user = operations.get(key);
//                return user;
//            }
//            else {
//                XxUser user = userMapper.getByPhone(phone);
//                if (user != null){
//                    if(user.getPassword().equals(password)){
//                        operations.set(key,user);
//                        return user;
//                    }
//                }
//        }
        XxUser user = userMapper.getByPhone(phone);
        if (user != null){
            if (user.getPassword().equals(password)){
                return user;
            }
        }
        return  null;
    }

    /**
     * 注册
     * @return
     */
    @Override
    public void register(String realname,String phone,String username,String password) {
        if (!StringUtils.isEmpty(phone) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(realname) && !StringUtils.isEmpty(username)){
            XxUser user = new XxUser();
            user.setRealname(realname);
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setCreated(new Date());
            user.setUpdated(new Date());
            userMapper.insert(user);
        }
    }

    /**
     * 验证手机号码
     * @param phone
     * @return
     */
    @Override
    public boolean verPhone(String phone) {
        Example example = new Example(XxUser.class);
        example.createCriteria().andEqualTo("phone",phone);
        XxUser user = userMapper.selectOneByExample(example);
        if (user == null){
            return false;
        }
        return true;
    }

    /**
     * 分页
     * @param start
     * @param length
     * @param draw
     * @param user
     * @return
     */
    @Override
    public PageInfo<XxUser> page(int draw, int start, int length, XxUser user) {
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("User",user);

        int count = userMapper.selectCount(user);
        PageInfo<XxUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(userMapper.page(params));

        return pageInfo;
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void delete(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 保存用户信息
     * @param user
     */
    @Override
    public void save(XxUser user) {
        user.setUpdated(new Date());
        if (user.getId() == null){
            user.setCreated(new Date());
            userMapper.insert(user);
        }
        else{
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public XxUser getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteMulti(Integer[] ids) {
        userMapper.deleteMulti(ids);
    }

    /**
     * 前台修改个人信息
     */
    @Override
    public ComResult updateInfo(XxUser xxUser) {
        ComResult comResult = checkXxUser(xxUser);
        //通过验证
        if (comResult.getStatus() == ComResult.STATUS_SUCCESS){
            xxUser.setUpdated(new Date());
            userMapper.updateByPrimaryKeySelective(xxUser);
            comResult.setMessage("用户信息保存成功");
        }
        return comResult;
    }

    /**
     * 用户信息的有效性验证
     * @param xxUser
     * @return
     */
    @Override
    public ComResult checkXxUser(XxUser xxUser) {
        ComResult comResult = ComResult.success();
        if (org.apache.commons.lang3.StringUtils.isBlank(xxUser.getEmail())){
            comResult = ComResult.fail("邮箱不能为空");
        }
        else if(!RegexUtils.checkEmail(xxUser.getEmail())){
            comResult = ComResult.fail("邮箱格式不正确");
        }
        else if(org.apache.commons.lang3.StringUtils.isBlank(xxUser.getPassword())){
            comResult = ComResult.fail("密码不能为空");
        }
        else if(org.apache.commons.lang3.StringUtils.isBlank(xxUser.getUsername())){
            comResult = ComResult.fail("姓名不能为空");
        }
        else if(org.apache.commons.lang3.StringUtils.isBlank(xxUser.getPhone())){
            comResult = ComResult.fail("手机号码不能为空");
        }
        else if(!RegexUtils.checkMobile(xxUser.getPhone())){
            comResult = ComResult.fail("手机号码格式不正确");
        }
        else if(org.apache.commons.lang3.StringUtils.isBlank(xxUser.getAddress())){
            comResult = ComResult.fail("地址不能为空");
        }
        return comResult;
    }

    @Override
    public void deleteSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            userMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

}

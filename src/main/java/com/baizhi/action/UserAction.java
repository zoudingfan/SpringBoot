package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/ShowAll")
    @ResponseBody
    public Map<String,Object> ShowAll(Integer page,Integer rows)throws Exception{
        Map<String, Object> map = new HashMap<>();
        //总条数
        Integer count = userService.queryCount();
        //总页数
        Integer ins=count%rows==0?count/rows:count/rows+1;
        //当前页的数据
        List<User> users = userService.queryAllUser(page, rows);
        //当前页号
        map.put("page",page);
        map.put("total",ins);
        map.put("records",count);
        map.put("rows",users);
        return map;
    }

 @ResponseBody
 @RequestMapping("/operation")
    public void operation(String oper,User user)throws Exception{
        if("add".equals(oper)){
            userService.addUser(user);
        }else if("edit".equals(oper)){
            userService.updateUser(user);
        }else if("del".equals(oper)){
            userService.deleteUser(user.getId());
        }
    }


}

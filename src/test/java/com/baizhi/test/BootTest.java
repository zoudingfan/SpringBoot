package com.baizhi.test;

import com.baizhi.Application;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BootTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Test
    public void test(){
        userDao.addUser(new User("5","dfdfdsf","000000","110110110","666@qq.com","微信","45.67.45.34","正常","普通用户"));
    }

    @Test
    public  void del(){
        userDao.deleteUser("3");
    }

    @Test
    public  void update(){
        userDao.updateUser(new User("3","王五dd","0000aa","110110110110","666555@qq.com","微信x","45.67.45.340","冻结","管理员"));
    }

    @Test
    public void dedede(){
        String [] ids={"5","4"};
        userDao.plDelete(ids);
    }

    @Test
    public void queryall(){
        List<User> users = userDao.queryAllUser(3,3);
        for (User user : users) {
            System.out.println(user);
        }

    }
    @Test
    public void count(){
        Integer count = userService.queryCount();
        System.out.println(count);
    }
}

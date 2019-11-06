package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //插入用户
    public void addUser(User user);
    //通过id删除用户
    public void deleteUser(String id);
    //修改用户
    public void updateUser(User user);

    //查询所有
    public List<User> queryAllUser(Integer page,Integer rows);

    //查询总员工总数
    public Integer queryCount();
}

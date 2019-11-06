package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //插入用户
    public void addUser(User user);
    //通过id删除用户
    public void deleteUser(String id);
    //修改用户
    public void updateUser(User user);
    //批量删除
    public void plDelete(String [] ids);
    //查询所有
    public List<User> queryAllUser(@Param("index")Integer index,@Param("rows")Integer rows);

    //查询总员工总数
    public Integer queryCount();
}

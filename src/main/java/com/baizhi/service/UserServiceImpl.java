package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
   private UserDao userDao;
    @Override
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
       userDao.updateUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> queryAllUser(Integer page,Integer rows) {
        Integer Index=(page-1)*rows;

        List<User> users = userDao.queryAllUser(Index,rows);
        return users;
    }

    @Override
    public Integer queryCount() {
        Integer count = userDao.queryCount();
        return count;
    }
}

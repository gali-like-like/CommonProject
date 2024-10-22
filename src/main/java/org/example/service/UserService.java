package org.example.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id) throws DataAccessException {
        return userMapper.selectById(id);
    }

    public void save(User user) throws DataAccessException {
        userMapper.updateById(user);
    }

    public Integer insert(User user) throws DataAccessException {
        return userMapper.insert(user);
    }

    public void deleteById(Integer id) throws DataAccessException {
        userMapper.deleteById(id);
    }

    public List<User> getUsers() throws DataAccessException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return userMapper.selectList(queryWrapper);
    }

    public List<User> getUsersByName(String name) throws DataAccessException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        queryWrapper.orderByDesc("id");
        return userMapper.selectList(queryWrapper);
    }
}

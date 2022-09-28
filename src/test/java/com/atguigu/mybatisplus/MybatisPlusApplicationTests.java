package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test //注意：注解包是 import org.junit.jupiter.api.Test;
    public void testSelectList() {
        List<com.atguigu.mybatisplus.entity.User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
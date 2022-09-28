package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @createTime : 2022/9/28 10:49
 */
@SpringBootTest
public class CRUDTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        //插入操作
        User user = new User();

        user.setName("HDY");
        user.setAge(19);
        user.setEmail("55317332@qq.com");

        int result = userMapper.insert(user);

        System.out.println("影响行数为：" + result);
        System.out.println(user); //id自动回填

    }


    @Test
    public void testUpdateById(){
        //插入操作
        User user = new User();

        user.setId(2L);
        user.setName("BYD");
        user.setAge(19);
        user.setEmail("55317332@qq.com");

        int result = userMapper.updateById(user);

        System.out.println("影响行数为：" + result);
    }

    @Test
    public void testOptimisticLocker() {
        //查询
        User user = userMapper.selectById(4L);

        //修改数据
        user.setName("Helen Yao");
        user.setEmail("helen@qq.com");

        //执行更新
        userMapper.updateById(user);
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds(){
      //批量查询
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){

        HashMap<String, Object> map = new HashMap<>();
        // 列名
        map.put("name", "Helen");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }

    //测试分页插件功能
    @Test
    public void testSwlectPage(){

        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page , null);

        page.getRecords().forEach(System.out::println);


        System.out.println("当前页数是第" + page.getCurrent() +"页");
        System.out.println("当前总页数为：" + page.getPages() );
        System.out.println("每页显示数量为：" + page.getSize() );
        System.out.println("总记录数为" + page.getTotal() );
        System.out.println("显示当前是否有下一页" + page.hasNext() );
        System.out.println("显示当前是否有上一页" + page.hasPrevious() );
    }

    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(8L);
        System.out.println(result);
    }

    @Test
    public void testDeleteByMap() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");
        map.put("age", 18);

        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    //测试逻辑删除
    /**
     * 测试 逻辑删除
     */
    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

    @Test
    public void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.ge("age", 20);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    //指定要查询的列
    @Test
    public void testSelectListColumn(){
        
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name","age");
        
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
}

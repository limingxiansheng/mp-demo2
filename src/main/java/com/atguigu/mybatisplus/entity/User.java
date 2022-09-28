package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @createTime : 2022/9/28 10:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    // @TableId(type =表示主键策略
   // @TableId(type = IdType.ASSIGN_ID)
    @TableId(type = IdType.AUTO) //这是主键算法里面的自增 数据库ID自增
    private Long id;

    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)//添加数据时赋值
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)//添加和修改
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT) //添加数据指定默认值
    private Integer version;

    @TableLogic
    private Integer deleted;


}

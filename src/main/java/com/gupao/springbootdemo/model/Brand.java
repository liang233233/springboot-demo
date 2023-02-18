package com.gupao.springbootdemo.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*****
 * @Author: 波波
 * @Description: 咕泡云商城
 ****/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "brand")
public class Brand {

    // ID（主键）  @TableId:标记当前属性为主键列对应的属性
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 品牌名字
    @JsonSerialize(using= ToStringSerializer.class)
    private String name;
    // 品牌图片
    private String image;
    // 品牌首字母
    private String initial;
    // 排序
    private Integer sort;


    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}

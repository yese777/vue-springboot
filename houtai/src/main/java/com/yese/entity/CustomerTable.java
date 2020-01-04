package com.yese.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (CustomerTable)表实体类
 *
 * @author makejava
 * @since 2020-01-04 14:21:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class CustomerTable extends Model<CustomerTable> {

    @TableId(type = IdType.AUTO)
        
    private Integer id;

    
        
    private String name;

    
        
    private String sex;

    
        
    private String tell;

    
        
    private String addr;
}
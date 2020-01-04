package com.yese.controller;

import com.yese.entity.CustomerTable;
import com.yese.service.CustomerTableService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (CustomerTable)控制层扩展类，一般初次生成，后续不再覆盖。这个类提供编写自己定义的方法。
 *
 * @author makejava
 * @since 2020-01-04 14:21:36
 */
@RestController
@RequestMapping("customerTable")
public class CustomerTableExtendController extends CustomerTableController {
    
}
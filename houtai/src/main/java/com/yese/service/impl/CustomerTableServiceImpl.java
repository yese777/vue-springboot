package com.yese.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yese.dao.CustomerTableDao;
import com.yese.entity.CustomerTable;
import com.yese.service.CustomerTableService;
import org.springframework.stereotype.Service;

/**
 * (CustomerTable)表服务实现类
 *
 * @author makejava
 * @since 2020-01-04 14:21:36
 */
@Service("customerTableService")
public class CustomerTableServiceImpl extends ServiceImpl<CustomerTableDao, CustomerTable> implements CustomerTableService {

}
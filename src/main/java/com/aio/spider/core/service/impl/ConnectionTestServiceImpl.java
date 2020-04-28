package com.aio.spider.core.service.impl;

import com.aio.spider.common.util.AioBeanUtils;
import com.aio.spider.core.mapper.ex.UserMapper;
import com.aio.spider.core.mapper.ex.pojo.User;
import com.aio.spider.core.service.ConnectionTestService;
import com.aio.spider.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionTestServiceImpl implements ConnectionTestService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVo> findUsers() {
        List<User> all = userMapper.findAll();
        all.addAll(userMapper.findAll1());
        return AioBeanUtils.convertList(all, UserVo.class);
    }
}

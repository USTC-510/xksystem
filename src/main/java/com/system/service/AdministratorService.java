package com.system.service;

import com.system.mapper.AdministratorMapper;
import com.system.pojo.Administrator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {
    @Resource
    private AdministratorMapper administratorMapper;

    public int login(String username, String password) {

        List<Administrator> list= administratorMapper.findByNameAndPassword(username,password);
        if(list!=null&&!list.isEmpty()){
            return 3;
        }
        else{
            return 0;
        }
    }
}
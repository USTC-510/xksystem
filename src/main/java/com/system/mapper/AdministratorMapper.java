package com.system.mapper;

import com.system.pojo.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorMapper extends Mapper<Administrator> {

}

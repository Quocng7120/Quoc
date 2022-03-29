package com.fis.spring.demoaccountspringjpa.dao.impl;

import com.fis.spring.demoaccountspringjpa.dao.AccountDao;
import com.fis.spring.demoaccountspringjpa.entity.Account;
import com.fis.spring.demoaccountspringjpa.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Account> getByFullName(String fullName) {
        String sql = "Select * from `account` where Full_Name = :fullName";

        Map params = new HashMap();
        params.put("Full_Name", fullName);
        return namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Account.class));

    }
}

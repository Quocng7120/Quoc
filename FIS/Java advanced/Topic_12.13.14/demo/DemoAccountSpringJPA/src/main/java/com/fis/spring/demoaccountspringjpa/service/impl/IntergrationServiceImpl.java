package com.fis.spring.demoaccountspringjpa.service.impl;

import com.fis.spring.demoaccountspringjpa.dao.dto.AccountDTO;
import com.fis.spring.demoaccountspringjpa.service.IntergrationService;
import lombok.Data;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class IntergrationServiceImpl implements IntergrationService {
    @Override
    public Object getAllAccount() {
        RestTemplate restTemplate =new RestTemplate();
        String url ="http://localhost:7888/account/getByFullname/Thành Trần";
        AccountDTO[] list=restTemplate.getForObject(url, AccountDTO[].class);
        return list;
    }

    @Data
    class AccountWrapper{
        List<AccountDTO> listAccount;
    }
}

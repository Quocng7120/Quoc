package fis.training.filnal.convert;

import fis.training.filnal.dto.CustomerDto;
import fis.training.filnal.entity.Customer;

import java.time.LocalDateTime;

public class CustomerConvert {
    public static Customer convertDto(CustomerDto dto){
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setBirthday(dto.getBirthday());
        customer.setAddress(dto.getAddress());
        customer.setIdentityNo(dto.getIdentityNo());
        customer.setMobile(dto.getMobile());
        customer.setCustomerType(dto.getCustomerType());
        customer.setStatus(1);
        customer.setCreateDatetime(LocalDateTime.now());
        customer.setUpdateDatetime(LocalDateTime.now());
        return customer;
    }
}

package fis.training.minitest_with_datajpa.dto;

import fis.training.minitest_with_datajpa.entity.Account;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class AccountDTO extends Account {
}

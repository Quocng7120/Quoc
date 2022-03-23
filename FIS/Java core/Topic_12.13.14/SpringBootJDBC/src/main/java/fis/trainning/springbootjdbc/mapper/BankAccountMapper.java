package fis.trainning.springbootjdbc.mapper;

import fis.trainning.springbootjdbc.model.BankAccountInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountMapper implements RowMapper<BankAccountInfo> {
    public static final String BASE_SQL //
            = "Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba ";

    @Override
    public BankAccountInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("Id");
        String fullName = rs.getString("Full_Name");
        double balance = rs.getDouble("Balance");

        return new BankAccountInfo(id, fullName, balance);
    }
}

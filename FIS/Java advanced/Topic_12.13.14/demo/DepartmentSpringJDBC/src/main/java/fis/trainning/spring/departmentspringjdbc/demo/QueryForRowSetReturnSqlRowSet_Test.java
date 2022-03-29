package fis.trainning.spring.departmentspringjdbc.demo;

import fis.trainning.spring.departmentspringjdbc.config.AppConfiguration;
import fis.trainning.spring.departmentspringjdbc.repository.QueryForRowSetReturnSqlRowSetRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;

public class QueryForRowSetReturnSqlRowSet_Test {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryForRowSetReturnSqlRowSetRepository dao = context.getBean(QueryForRowSetReturnSqlRowSetRepository.class);

        // SqlRowSet
        SqlRowSet rowSet = dao.queryForRowSet_SqlRowSet();

        while (rowSet.next()) {

            System.out.println("-----");
            Long empId = rowSet.getLong("Emp_Id"); // Index = 1
            String empNo = rowSet.getString(2); // Index = 2
            String empName = rowSet.getString("Emp_Name"); // Index = 3

            System.out.println("EmpID: " + empId + ", EmpNo: " + empNo + ", EmpName:" + empName);
        }

    }
}

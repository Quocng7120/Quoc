package fis.trainning.spring.departmentspringjdbc.demo;

import fis.trainning.spring.departmentspringjdbc.config.AppConfiguration;
import fis.trainning.spring.departmentspringjdbc.entity.Department;
import fis.trainning.spring.departmentspringjdbc.repository.QueryWithRowMapperRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class QueryWithRowMapper_Test {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryWithRowMapperRepository dao = context.getBean(QueryWithRowMapperRepository.class);

        List<Department> list = dao.queryDepartment() ;

        for(Department dept: list)  {
            System.out.println("DeptNo: "+ dept.getDeptNo()+" - DeptName: "+ dept.getDeptName());
        }
    }
}

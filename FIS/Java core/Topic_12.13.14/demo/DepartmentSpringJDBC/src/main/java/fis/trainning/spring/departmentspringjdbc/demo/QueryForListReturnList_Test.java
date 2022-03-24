package fis.trainning.spring.departmentspringjdbc.demo;

import fis.trainning.spring.departmentspringjdbc.config.AppConfiguration;
import fis.trainning.spring.departmentspringjdbc.repository.QueryForListReturnListRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class QueryForListReturnList_Test {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryForListReturnListRepository dao = context.getBean(QueryForListReturnListRepository.class);

        List<String> names = dao.getDeptNames("A");

        for (String name : names) {

            System.out.println("Dept Name: " + name);
        }
    }
}

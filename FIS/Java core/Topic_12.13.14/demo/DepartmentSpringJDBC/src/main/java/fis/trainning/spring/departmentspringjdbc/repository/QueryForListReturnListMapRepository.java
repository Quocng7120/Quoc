package fis.trainning.spring.departmentspringjdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class QueryForListReturnListMapRepository extends JdbcDaoSupport {
    @Autowired
    public QueryForListReturnListMapRepository(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    // Map<String columnName, Object value>
    public List<Map<String, Object>> queryForList_ListMap() {

        String sql = "Select e.Emp_No, e.Emp_Name from Employee e ";

        // List<Map<String, Object>> queryForList(String sql)
        List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql);

        return list;
    }

    // List<Map<String, Object>>
    // queryForList(String sql, Object[] args, int[] argTypes)

    public List<Map<String, Object>> queryForList_ListMap2() {

        String sql = "Select e.Emp_Id,e.Emp_No,e.Emp_Name From Employee e " //
                + " Where e.Hire_Date > ? and e.Salary > ? ";
        //
        Date hireDate = getDateByYear(1981);
        Object[] args = new Object[] { hireDate, 2800 };
        int[] argTypes = new int[] { Types.DATE, Types.DOUBLE };

        // List<Map<String, Object>> queryForList(String sql)
        List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql, args, argTypes);

        return list;
    }

    private Date getDateByYear(int year) {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_YEAR, 1);
        return c.getTime();
    }
}

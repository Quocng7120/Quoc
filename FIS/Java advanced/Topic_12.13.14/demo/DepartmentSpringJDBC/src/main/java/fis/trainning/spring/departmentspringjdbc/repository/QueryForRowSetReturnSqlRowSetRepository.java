package fis.trainning.spring.departmentspringjdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;

@Repository
public class QueryForRowSetReturnSqlRowSetRepository extends JdbcDaoSupport {
    @Autowired
    public QueryForRowSetReturnSqlRowSetRepository(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    // SqlRowSet queryForRowSet(String sql, Object[] args, int[] argTypes)

    public SqlRowSet queryForRowSet_SqlRowSet() {

        String sql = "Select e.Emp_Id,e.Emp_No,e.Emp_Name From Employee e " //
                + " Where e.Hire_Date > ? and e.Salary > ? ";
        //
        Date hireDate = getDateByYear(1981);
        Object[] args = new Object[] { hireDate, 2800 };
        int[] argTypes = new int[] { Types.DATE, Types.DOUBLE };

        // SqlRowSet queryForRowSet(String sql, Object[] args, int[] argTypes)
        SqlRowSet rowSet = this.getJdbcTemplate().queryForRowSet(sql, args, argTypes);

        return rowSet;
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

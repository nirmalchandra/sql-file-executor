package com.stocks.jdbc;

import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SqlExecutorTest {

    @Test
    public void testExecuteSqlsIn_dotSqlFile() throws SQLException {
        SqlExecutor sqlExecutor = new SqlExecutor();
        sqlExecutor.executeSqlFile("create_customer_table.sql");
        sqlExecutor.executeSqlFile("insert_customers.sql");
    }

    @Test
    public void testExecute_sql() throws SQLException {
        SqlExecutor sqlExecutor = new SqlExecutor();
        int count = sqlExecutor.executeSqlStatement("SELECT count(*) FROM certgurus.question_set");
        assertThat(count, is(7));
    }

}
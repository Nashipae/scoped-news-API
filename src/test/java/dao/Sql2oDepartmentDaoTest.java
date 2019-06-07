package dao;

import models.Department;
import org.sql2o.*;
import org.junit.*;
import java.sql.Connection;
import static org.junit.Assert.*;


public class Sql2oDepartmentDaoTest {

    private Sql2oDepartmentDao departmentDao;
    private Connection conn; //must be sql2o class conn

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
       departmentDao = new Sql2oDepartmentDao(sql2o); //ignore me for now
        conn = sql2o.open(); //keep connection open through entire test so it does not get erased
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }
}
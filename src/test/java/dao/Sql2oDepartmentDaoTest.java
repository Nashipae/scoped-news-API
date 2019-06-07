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

    @Test
    public void addingCourseSetsId() throws Exception {
        Department department = new Department ("RNIO");
        int originalDepartmentId = department.getId();
        departmentDao.add(department);
        assertNotEquals(originalDepartmentId, department.getId());
    }

    @Test
    public void existingTasksCanBeFoundById() throws Exception {
        Department department = new Department ("RNIO");
        departmentDao.add(department); //add to dao (takes care of saving)
        Department foundDepartment = departmentDao.findById(department.getId()); //retrieve
        assertEquals(department, foundDepartment); //should be the same
    }
    @Test
    public void addedDepartementsAreReturnedFromgetAll() throws Exception {
        Department department = new Department ("RNIO");
        departmentDao.add(department);
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void noDeparmentsReturnsEmptyList() throws Exception {
        assertEquals(0, departmentDao.getAll().size());
    }
}
package models;

import dao.DepartmentDao;
import jdk.internal.jline.internal.ShutdownHooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewDepartmentObjectGetsCorrectlyCreated_true() throws Exception {
        Department department =  new Department("RNIO");
        assertEquals(true, department instanceof Department);
    }

    @Test
    public void DepartmentInstantiatesWithName_true() throws Exception {
        Department department = new Department("RNIO");
        assertEquals("RNIO", department.getName());
    }

    @Test
    public void getCreatedAtInstantiatesWithCurrentTimeToday() throws Exception {
        Department department = new Department("RNIO");
        assertEquals(LocalDateTime.now().getDayOfWeek(), department.getCreatedAt().getDayOfWeek());
    }
//    @Test
//    public void updateChangesDepartmentName() throws Exception {
//        String initialName = "RNIO";
//        Department department = new Department (initialName);
//        DepartmentDao.add(department);
//
//        DepartmentDao.update(department.getId(),"TSAG");
//        Department updatedDepartment = DepartmentDao.findById(department.getId());
//        assertNotEquals(initialName, updatedName.getName());
//    }
//
//    @Test
//    public void deleteByIdDeletesCorrectDepartment() throws Exception {
//        String initialName = "RNIO";
//        Department department = new Department (initialName);
//        DepartmentDao.add(department);
//        DepartmentDao.deleteById(department.getId());
//        assertEquals(0, DepartmentDao.getAll().size());
//    }
//
//    @Test
//    public void clearAllClearsAll() throws Exception {
//        Department department = new Department("RNIO");
//        Department otherDepartment = new Department("TSAG");
//        DepartmentDao.add(department);
//        DepartmentDao.add(otherDepartment);
//        int daoSize = DepartmentDao.getAll().size();
//        DepartmentDao.clearAllDepartments();
//        assertTrue(daoSize > 0 && daoSize > DepartmentDao.getAll().size());
//    }
}



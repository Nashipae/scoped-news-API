package models;

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
        Department department =  new Department();
        assertEquals(true, department instanceof Department);
    }

    @Test
    public void DepartmentInstantiatesWithName_true() throws Exception {
        Department department = new Department();
        assertEquals("RNIO", department.getName());
    }

    @Test
    public void getCreatedAtInstantiatesWithCurrentTimeToday() throws Exception {
        Department department = new Department();
        assertEquals(LocalDateTime.now().getDayOfWeek(), department.getCreatedAt().getDayOfWeek());
    }


}
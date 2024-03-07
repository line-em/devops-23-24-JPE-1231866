package com.gregIturnquist.payroll;

import com.greglturnquist.payroll.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootConfiguration
class EmployeeTest {
    Employee emp;
    String CONSTRUCTOR_ERROR_MESSAGE = "";
    String JOB_YEARS_ERROR_MESSAGE = "";

    @BeforeEach
    public void setup() {
        emp = new Employee("Frodo", "Baggins", "ring bearer", "Hobbit", 2);
        CONSTRUCTOR_ERROR_MESSAGE = "Arguments must not be null or empty.";
        JOB_YEARS_ERROR_MESSAGE = "Job years must be a positive number.";
    }

    @Test
    public void testEmployeeFirstName() {
        String expected = "Frodo";
        String actual = emp.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    public void testEmployeeFirstNameAfterSetFirstName() {
        String expected = "Bilbo";
        emp.setFirstName("Bilbo");
        String actual = emp.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    public void invalidEmployeeFirstName() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee("", "Baggins",
                    "ring bearer", "Hobbit",2));
        assertEquals(CONSTRUCTOR_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void invalidEmployeeFirstNameNull() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee(null, "Baggins",
                    "ring bearer", "Hobbit",2));
        assertEquals(CONSTRUCTOR_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void testEmployeeLastName() {
        String expected = "Baggins";
        String actual = emp.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    public void testEmployeeLastNameAfterSetLastName() {
        String expected = "Lastname";
        emp.setLastName("Lastname");
        String actual = emp.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    public void invalidEmployeeLastName() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee("Frodo", "",
                    "ring bearer", "Hobbit",2));
        assertEquals(CONSTRUCTOR_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void invalidEmployeeLastNameNull() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee("Frodo", null,
                    "ring bearer", "Hobbit",2));
        assertEquals(CONSTRUCTOR_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void testEmployeeDescription() {
        String expected = "ring bearer";
        String actual = emp.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void testEmployeeDescriptionAfterSetDescription() {
        String expected = "Burglar";
        emp.setDescription("Burglar");
        String actual = emp.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void invalidEmployeeDescription() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee("Frodo", "Baggins",
                    "", "Hobbit",2));
        assertEquals(CONSTRUCTOR_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void invalidEmployeeDescriptionNull() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee("Frodo", "Baggins",
                    null, "Hobbit",2));
        assertEquals(CONSTRUCTOR_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void testEmployeeJobTitle() {
        String expected = "Hobbit";
        String actual = emp.getJobTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void testEmployeeJobTitleAfterSetJobTitle() {
        String expected = "Ring Bearer";
        emp.setJobTitle("Ring Bearer");
        String actual = emp.getJobTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void invalidEmployeeJobTitle() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee("Frodo", "Baggins",
                    "ring bearer", "",2));
        assertEquals(CONSTRUCTOR_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void invalidEmployeeJobTitleNull() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee("Frodo", "Baggins",
                    "ring bearer", null,1));
        assertEquals(CONSTRUCTOR_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void testToString() {
        String expected = "firstName='Frodo', lastName='Baggins'";
        String actual = emp.toString();
        assertTrue(actual.contains(expected));
    }

    @Test
    public void testEmployeeJobYears() {
        int expected = 2;
        int actual = emp.getJobYears();
        assertEquals(expected, actual);
    }

    @Test
    public void testEmployeeJobYearsAfterSetJobYears() {
        int expected = 3;
        emp.setJobYears(3);
        int actual = emp.getJobYears();
        assertEquals(expected, actual);
    }

    @Test
    public void invalidEmployeeJobYears() {
        Exception e = assertThrows(IllegalArgumentException.class,
              () -> new Employee("Frodo", "Baggins",
                    "ring bearer", "Hobbit",-2));
        assertEquals(JOB_YEARS_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void validEmployeeJobYearsZero() {
        int expected = 0;
        emp.setJobYears(0);
        int actual = emp.getJobYears();
        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        Employee emp2 = new Employee("Frodo", "Baggins", "ring bearer", "Hobbit", 2);
        assertEquals(emp, emp2);
    }
}

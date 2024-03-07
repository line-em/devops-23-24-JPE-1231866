package test.com.gregIturnquist.payroll;

import com.greglturnquist.payroll.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeTest {
    Employee emp;
    @BeforeEach
    public void setup() {
        emp = new Employee("Frodo", "Baggins", "ring bearer", "Hobbit");
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
    public void testToString() {
        String expected = "firstName='Frodo', lastName='Baggins'";
        String actual = emp.toString();
        assertTrue(actual.contains(expected));
    }

}

package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobOne instanceof Job);
        assertTrue(jobOne.getEmployer() instanceof Employer);
        assertTrue(jobOne.getLocation() instanceof Location);
        assertTrue(jobOne.getPositionType() instanceof PositionType);
        assertTrue(jobOne.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", jobOne.getName());
        assertEquals("ACME", jobOne.getEmployer().getValue());
        assertEquals("Desert", jobOne.getLocation().getValue());
        assertEquals("Quality control", jobOne.getPositionType().getValue());
        assertEquals("Persistence", jobOne.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', jobOne.toString().charAt(0));
        assertEquals('\n', jobOne.toString().charAt(jobOne.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + jobOne.getId() + "\n" +
                "Name: " + jobOne.getName() + "\n" +
                "Employer: " + jobOne.getEmployer() + "\n" +
                "Location: " + jobOne.getLocation() + "\n" +
                "Position Type: " + jobOne.getPositionType() + "\n" +
                "Core Competency: " + jobOne.getCoreCompetency() + "\n"
                ,jobOne.toString());
    }

    @Test
    public void testToStringHandlesAllFieldsEmptyExceptId() {
        Job jobOne = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(jobOne.toString(), "OOPS!  This job does not seem to exist.");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobOne = new Job("Product Tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String dataNotAvailable = "Data not available";
        assertEquals("\nID: " + jobOne.getId() + "\n" +
                        "Name: " + jobOne.getName() + "\n" +
                        "Employer: " + dataNotAvailable + "\n" +
                        "Location: " + dataNotAvailable + "\n" +
                        "Position Type: " + dataNotAvailable + "\n" +
                        "Core Competency: " + dataNotAvailable + "\n"
                ,jobOne.toString());
    }



}

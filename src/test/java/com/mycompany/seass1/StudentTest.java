
package com.mycompany.seass1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.joda.time.DateTime;



class StudentTest {
	
	private Student s;
	private Module m1, m2;
	private CourseProgramme cp1;
	
	
	@BeforeEach
	void setUp() throws Exception {
		s = new Student("BenDover", "30-07-98", 22, 17464946);
		m1 = new Module("EE417", "Software Eng");
		m2 = new Module("CT4101", "Machine Learning");
		cp1 = new CourseProgramme("BP", new DateTime("2020-01-01T00:00:00Z"),
		new DateTime("2024-01-01T00:00:00Z"));
	}

	@Test
	public void test_username(){
		
		String expected = "BenDover_22";
		String username = s.getUsername();
		assertEquals(expected, username);
	}
	

	
	@Test
	public void test_setCourseProgramme(){
		
		s.setCourseProgramme(cp1);
		CourseProgramme expectedCourse = new CourseProgramme("BP", new DateTime("2020-01-01T00:00:00Z"),
		new DateTime("2024-01-01T00:00:00Z"));
		CourseProgramme currentCourse = s.getCourseProgramme();
		assertEquals(expectedCourse.toString(), currentCourse.toString());

		
	}

	@Test
	public void test_addingModules(){
		s.addModule(m1);
		Module expectedModule = new Module("EE417", "Software Eng");
		String currentModules = s.getModuleString();
		assertTrue((expectedModule.toString()).contains(currentModules));

	}

	@Test
	public void test_removeModule(){
		s.addModule(m1);
		s.addModule(m2);
		s.removeModule(m2);
		Module expectedModule = new Module("EE417", "Software Eng");
		String sModule = s.getModuleString();
		assertTrue((expectedModule.toString()).contains(sModule));
	}
	
	

}

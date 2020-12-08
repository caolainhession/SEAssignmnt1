
package com.mycompany.seass1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.joda.time.DateTime;

public class ModuleTest {
	private Student student1;
	private Student student2;
	private Module module1;
	private CourseProgramme course1;
	private CourseProgramme course2;

	@BeforeEach
	public void setUp() throws Exception {
		student1 = new Student("DanDruff", "11-12-99", 21, 17284688);
		student2 = new Student("ItaCox", "09-09-00", 21, 174279994);

		module1 = new Module("EE417", "Software Eng");
		course1 = new CourseProgramme("BP", new DateTime("2003-07-01T00:00:00Z"),
				new DateTime("2007-07-01T00:00:00Z"));
		course2 = new CourseProgramme("EP", new DateTime("2010-07-01T00:00:00Z"),
				new DateTime("2015-07-01T00:00:00Z"));
	}

	@Test
	public void add_student_module_test(){
		module1.addStudentToModule(student1);
		List<Student> currentStudents = module1.getStudentList();
		assertTrue(currentStudents.contains(student1));
	}

	@Test
	public void testRemoveStudent(){
		module1.addStudentToModule(student1);
		module1.addStudentToModule(student2);
		module1.removeStudentFrmModule(student2);
		String correctStudents = "DanDruff_21";
		String currentStudents = module1.getStudentsString();
		assertEquals(correctStudents, currentStudents);
	}

	@Test
	public void addCourseTest(){
		module1.addCourse(course1);
		module1.addCourse(course2);
		String currentCourse = module1.getCoursesString();
		String correctCourse = "BPEP";
		assertTrue(currentCourse.equals(correctCourse));
	}

	@Test
	public void remove_module_course_test(){
		module1.addCourse(course1);
		module1.addCourse(course2);
		module1.removeCourse(course2);
		String currentCourse = module1.getCoursesString();
		String correctCourse = "BP";
		assertTrue(currentCourse.equals(correctCourse));
	}
}
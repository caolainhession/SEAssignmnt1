
package com.mycompany.seass1;


import java.util.ArrayList;
import java.util.List;


public class Module {
    private String id, name;
    private List<Student> students;
    private List<CourseProgramme> courses;
    
    public Module(String id, String name) {
            this.id = id;
            this.name = name;
            this.students = new ArrayList<Student>();
            this.courses = new ArrayList<CourseProgramme>();
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getID(){
        return id;
    }

    public void setID(String id){
        this.id = id;
    }
    
    public List<Student> getStudentList(){
        return students;
    }

    public void setStudentList(List<Student> students){
        this.students = students;
    }

    public List<CourseProgramme> getCourseList(){
        return courses;
    }

    public void setCourseList(List<CourseProgramme> courses){
        this.courses = courses;
    }
    
    
    
    public void addStudentToModule(Student student){
	if (!students.contains(student)){
		students.add(student);
		student.addModule(this);
	}
    }

    public void removeStudentFrmModule(Student student){
	if (students.contains(student)){
		students.remove(student);
	}
    }

    public void addCourse(CourseProgramme programme){
	if (!courses.contains(programme)){
		courses.add(programme);
		programme.addModuleToCourse(this);
	}
    }

    public void removeCourse(CourseProgramme programme){
	if (courses.contains(programme)){
		courses.remove(programme);
		programme.removeModuleFrmCourse(this);
	}
    }
    
    
    public String getStudentsString() {
		StringBuilder sbSL = new StringBuilder();
		for (Student s : students) {
			sbSL.append(s.getUsername());
		}
		String str = sbSL.toString();
		return str;
	}
    
	public String getCoursesString(){
		StringBuilder sbCL = new StringBuilder();
		for (CourseProgramme cp : courses){
			sbCL.append(cp.getCourseName());
		}
		String str = sbCL.toString();
		return str;
	}
    
    @Override
    public String toString(){
        return "Name: " + name + " | ID: " + id + " | Students Enrolled: " + this.getStudentList()
        + " | Courses Associated: " + this.getCourseList();
    }

}
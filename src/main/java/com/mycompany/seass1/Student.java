
package com.mycompany.seass1;

import java.util.ArrayList;
import java.util.List;


public class Student {
    private String name, username, DOB;
    private CourseProgramme courseProg;
    private int age, id;
    private List <Module> currentMods;
    
    public Student(String name, String DOB, int age, int id){
        this.name = name;
        this.DOB = DOB;
	this.age = age;
        this.username= this.getUsername();
	this.id = id;
	currentMods = new ArrayList<Module>();
        }
    
    public String getUsername(){
		String username = name + "_" + age;
		return username;
	}
    
    public void addModule(Module module){
	if (!currentMods.contains(module)){ 
		currentMods.add(module);
		module.addStudentToModule(this);
	}
    }

    public void removeModule(Module module){
	if (currentMods.contains(module)){
		currentMods.remove(module);
		module.removeStudentFrmModule(this);
	}
    }
    
    public void removeStudentCourse(){
	this.courseProg = null;
    }
    
    //getters and setters
      public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
    
    public int getId(){
	return id;
    }

    public void setId(int id){
	this.id = id;
    }

    public String getDOB(){
        return DOB;
    }

    public void setDOB(String DOB){
        this.DOB = DOB;
    }
    
    public CourseProgramme getCourseProgramme(){
	return courseProg;
    }

    public void setCourseProgramme(CourseProgramme courseProg){
        this.courseProg = courseProg;
    }
    
    public List<Module> getModules(){
		return currentMods;
	}

	public void setModules(List<Module> currentMods){
		this.currentMods = currentMods;
	}
	
	public String getModuleString(){
	    StringBuilder moduleSB = new StringBuilder();
	        
	        for(Module module : currentMods){
	            moduleSB.append(module.getName());
	            moduleSB.append(" ");
	        }
	        
	    String moduleString = moduleSB.toString();
	    return moduleString;
	}
	

	 @Override
	 public String toString(){
	    return "Name: " + name + " | Username: " + this.getUsername() + " | DOB: " + DOB + " | Age: " + age + " | ID: " + id +
	                " | Course: " + courseProg.getCourseName() + " | Modules: " + this.getModuleString();
	    }
    
}

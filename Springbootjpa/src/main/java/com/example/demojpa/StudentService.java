package com.example.demojpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Optional;

@Service
public class StudentService {
	
	//CRUD
	@Autowired
	StudentRepository studentRepository;
	
	List<Student> students =  new ArrayList<>();
	
	public void createStudents() {
	
		students.add(new Student(1, "a", 1, 11));
		students.add(new Student(2, "b", 2, 22));
		students.add(new Student(3, "c", 3, 31));
		students.add(new Student(4, "d", 4, 41));
	}
	
	public List<Student> getStudents(){
		//createStudents();
		//return students;
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
		
		
	}
	
	public Student getStudent(int id) {
		Student student=  students.stream().filter(s -> s.getId() == id ).findFirst().get();
		return student;
	}

	public void addStudent(Student student) {
		/*
		 * System.out.println("controllers add student"); students.add(student);
		 */
		
	}
	
	public void updateStudent(Student student, int id) {
		for(int i = 0; i<students.size(); i++) {
			Student s = students.get(0);
			if(s.getId() == id) {
				students.set(id, student);
				return;
				
				}
			}
	}
	
	public void removeStudent(int id) {
		students.removeIf(s -> s.getId() == id);
		}
	

}

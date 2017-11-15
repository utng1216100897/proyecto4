package dao;

import java.util.List;

import model.Student;

public interface StudentDAO {
	
	void createStudent(Student student);
	Student readStudent(Long id);
	List<Student> readAllStudents();
	void updateStudent(Student student);
	void deleteStudent(Long id);
	

}

package dao;

import java.util.List;

import entities.Student;


public interface  StudentDao
{
	public int saveStudent(Student student);
	public  Student getStudent(int id);
	public List<Student> getAllStudent();
	public int updateStudent(Student student);
	public void deleteStudent(int id);
}

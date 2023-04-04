package dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import entities.Student;

public class StudentDaoImpl implements StudentDao
{
	private  HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() 
	{
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) 
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional 
	public int saveStudent(Student student) {
		// TODO Auto-generated method stub
		int i = (Integer) hibernateTemplate.save(student);
		return i;
	}

	@Override
	public Student getStudent(int id) 
	{
		// TODO Auto-generated method stub
		Student st = hibernateTemplate.get(Student.class, id);
		return st;
	}

	@Override
	public List<Student> getAllStudent() 
	{
		// TODO Auto-generated method stub
		List<Student> list = hibernateTemplate.loadAll(Student.class);
		return list;
	}

	@Transactional
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(student);
		return 0;
	}

	@Transactional
	public void deleteStudent(int  id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(hibernateTemplate.get(Student.class, id));
	}
	
}

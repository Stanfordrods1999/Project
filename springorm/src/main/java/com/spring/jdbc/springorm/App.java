package com.spring.jdbc.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StudentDao;
import dao.StudentDaoImpl;
import entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao dao = context.getBean("studentDao",StudentDao.class);
        boolean go = true;
        while(go)
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press 1 to add new student");
        System.out.println("Press 2 to display all students");
        System.out.println("Press 3 to get detail of student by id");
        System.out.println("Press 4 to delete a student");
        System.out.println("Press 5 to update student details");
        System.out.println("Press 6 to exit");
        
        try
        {
        	int input = Integer.parseInt(br.readLine());
        	switch(input)
        	{
        	case 1:
        		//Adding a new student
        		//Taking the input of all fields for student ID
        		System.out.println("Enter user ID:");
        		int uid = Integer.parseInt(br.readLine());
        		
        		System.out.println("Enter user name:");
        		String uname = br.readLine();
        		
        		System.out.println("Enter user city:");
        		String ucity = br.readLine();
        		
        		Student s= new Student();
        		s.setStudentId(uid);
        		s.setStudentName(uname);
        		s.setStudentCity(ucity);
        		
        		int r = dao.saveStudent(s);
        		break;
        	case 2:
        		System.out.println("************************************************");
        		List<Student> allStudents= dao.getAllStudent();
        		for(Student st:allStudents)
        		{
        			System.out.println("Id :"+ st.getStudentId());
        			System.out.println("Name :"+ st.getStudentName());
        			System.out.println("City :"+ st.getStudentCity());
        		}
        		System.out.println("************************************************");
        		break;
        	case 3:
        		System.out.println("Enter user id:");
        		int userID = Integer.parseInt(br.readLine()) ;
        		Student student = dao.getStudent(userID);
        		System.out.println("Id:" + student.getStudentId());
        		System.out.println("Name:" + student.getStudentName());
        		System.out.println("Enter user id:" + student.getStudentCity());
        		System.out.println("________________________________________________");
        		break;
        	case 4:
        		System.out.println("Enter user id:");
        		int userid = Integer.parseInt(br.readLine());
        		dao.deleteStudent(userid);
        		System.out.println("Student with id :"+ userid+" has been deleted");
        		break;
        	case 5:
        		System.out.println("Enter user ID:");
        		int updateid = Integer.parseInt(br.readLine());
        		
        		System.out.println("Enter user name:");
        		String updatename = br.readLine();
        		
        		System.out.println("Enter user city:");
        		String updatecity = br.readLine();
        		
        		Student studentupdate= new Student();
        		studentupdate.setStudentId(updateid);
        		studentupdate.setStudentName(updatename);
        		studentupdate.setStudentCity(updatecity);
        		dao.updateStudent(studentupdate);
        		break;
        	case 6:
        		go=false;
        		break;
        	}
        }
        catch(Exception e)
        {
        	System.out.println("Invalid Input Try again");
        	System.out.println("e.getMessage()");
        }
        }
        System.out.println("Thank you  for using my application");
        System.out.println("See you soon");
    }
}

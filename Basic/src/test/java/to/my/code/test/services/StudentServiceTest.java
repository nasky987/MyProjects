package to.my.code.test.services;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import to.my.code.HomeController;
import to.my.code.test.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/context-web.xml")
@ActiveProfiles("develop")
public class StudentServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceTest.class);
	
	@Autowired
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@BeforeClass
	public static void setup() {
		if( logger.isDebugEnabled() ) {
			logger.debug("테스트 시작 전 호출");
		}
	}
	
	@AfterClass
	public static void teardown() {
		if( logger.isDebugEnabled() ) {
			logger.debug("테스트 종료 후 호출");
		}
	}
	
	@Test
	public void testFindAllStudents() {
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		
		for(Student student : students) {
			if( logger.isDebugEnabled() ) {
				logger.debug(student.toString());
			}
		}
	}
	
	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		
		if( logger.isDebugEnabled() ) {
			logger.debug(student.toString());
		}
	}
	
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		
		int id = 3;
		
		student.setStudId(id);
		student.setName("student_" + id);
		student.setEmail("student_" + id + "@gmail.com");
		student.setDob(new Date());
		
		studentService.createStudent(student);
		
		Student newStudent = studentService.findStudentById(id);
		Assert.assertNotNull(newStudent);
	}
}

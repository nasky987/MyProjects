package to.my.code.test.services;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;

import to.my.code.test.domain.Student;
import to.my.code.test.mappers.StudentMapper;

public class StudentService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

//	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
//		this.sqlSessionTemplate = sqlSessionTemplate;
//	}

	@Cacheable(cacheName="customCache")
	public List<Student> findAllStudents() {
		StudentMapper studentMapper = sqlSessionTemplate.getMapper(StudentMapper.class);
		
		List<Student> students = studentMapper.findAllStudents();
		if(students.size() > 1) {
			throw new RuntimeException();
		}
		
		return students;
	}
	
	@Cacheable(cacheName="customCache")
	public Student findStudentById(Integer studId) {
		if( logger.isDebugEnabled() ) {
			logger.debug("Selet Student By ID:{}", studId);
		}
		
		StudentMapper studentMapper = sqlSessionTemplate.getMapper(StudentMapper.class);
		
		return studentMapper.findStudentById(studId);
	}
	
	@Transactional(value="transactionManager")
	@TriggersRemove(cacheName="customCache", removeAll=true, when=When.AFTER_METHOD_INVOCATION)
	public void createStudent(Student student) {
		StudentMapper studentMapper = sqlSessionTemplate.getMapper(StudentMapper.class);
		studentMapper.insertStudent(student);
	}
}

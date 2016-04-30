package to.my.code.test.mappers;

import java.util.List;

import to.my.code.test.domain.Student;

public interface StudentMapper {
	List<Student> findAllStudents();
	Student findStudentById(Integer id);
	void insertStudent (Student student);
}

package to.my.code;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import to.my.code.test.domain.Student;
import to.my.code.test.services.StudentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		try {
			List<Student> students = studentService.findAllStudents();
			for(Student student : students) {
				if( logger.isDebugEnabled() ) {
					logger.debug(student.toString());
				}
			}
			
		}catch(Exception e) {
			if( logger.isDebugEnabled() ) {
				logger.debug("에러");
			}
		}
		
		Student a = studentService.findStudentById(1);
		Student b = studentService.findStudentById(2);
		Student c = studentService.findStudentById(1);
		
		if(a == c) {
			System.out.println("같음");
		}
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}

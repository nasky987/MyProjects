package to.my.code;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/{param1}/{param2}")
	public String test(@PathVariable(value="param1") String a, 
						@PathVariable(value="param2") String b,
						Model model) {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		model.addAttribute("serverTime", a );
		model.addAttribute("test", b );
		
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String test(@RequestParam(value="test") String test, Model model) {
		model.addAttribute("test", test);
		
		return "home";
	}

	@RequestMapping("/json1")
	public String jsonData(Model model){
		System.out.println("----- FileDownloadController.jsonData() -----");
	
		List<String> list = new ArrayList<String>();
		list.add("사이트 관리");
		list.add("관리자 관리");
		list.add("공통 코드 관리");
		list.add("접속 이력");
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "cat");
		map.put("2", "dog");
		map.put("3", "tiger");
	
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("JSON");
//		modelAndView.addObject("menuList", list);
//		modelAndView.addObject("animal", map);
//		return modelAndView;
		
		model.addAttribute("menuList", list);
		model.addAttribute("animal", map);
		
		return "JSON";
	}
	
	@RequestMapping("/json2")
	public ModelAndView jsonData2(){
		System.out.println("----- FileDownloadController.jsonData() -----");
	
		List<String> list = new ArrayList<String>();
		list.add("사이트 관리");
		list.add("관리자 관리");
		list.add("공통 코드 관리");
		list.add("접속 이력");
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "cat");
		map.put("2", "dog");
		map.put("3", "tiger");
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("JSON");
		modelAndView.addObject("menuList", list);
		modelAndView.addObject("animal", map);
		
		return modelAndView;
	}
	
	@RequestMapping("/json3")
	public ModelAndView jsonData3(HttpServletResponse response){
		System.out.println("----- FileDownloadController.jsonData() -----");
		
		List<String> list = new ArrayList<String>();
		list.add("사이트 관리");
		list.add("관리자 관리");
		list.add("공통 코드 관리");
		list.add("접속 이력");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "cat");
		map.put("2", "dog");
		map.put("3", "tiger");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("JSON");
		modelAndView.addObject("menuList", list);
		modelAndView.addObject("animal", map);
		
//		response.setContentType("text/json");
//		response.setCharacterEncoding("UTF-8");
		
		return modelAndView;
	}
	
	@RequestMapping("/json4")
	@ResponseBody
	public Object jsonData4(){
		System.out.println("----- FileDownloadController.jsonData() -----");
		
		List<String> list = new ArrayList<String>();
		list.add("사이트 관리");
		list.add("관리자 관리");
		list.add("공통 코드 관리");
		list.add("접속 이력");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "cat");
		map.put("2", "dog");
		map.put("3", "tiger");
		map.put("4", list);
		
		return map;
	}
}

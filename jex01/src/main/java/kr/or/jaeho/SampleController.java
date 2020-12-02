package kr.or.jaeho;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.domain.SampleDTO;
import kr.or.domain.SampleListDTO;
import kr.or.domain.TodoDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic.............");
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic get.............");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get.............");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("dto는 : " + dto);
		return "/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") String age) {
		log.info("name은 : " + name + " age는 " + age);
		return "/ex01";
	}
	
	@GetMapping("/ex02List")
	   public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
	      log.info("ids 1번째:" + ids.get(0));
	      log.info("ids 2번째:" + ids.get(1));
	      log.info("ids 3번째:" + ids.get(2));
	      return "ex02List";
	   }
	
	@GetMapping("/ex02Bean")
	   public String ex02Bean(SampleListDTO list) {
		//%5B -> [
		//%5D -> ]
		// http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=aaa,list%5B2%5D.name=bbb
	      log.info("list dtos:" + list);
	      return "ex02Bean";
	   }
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	}
}
package to.my.code.board.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import to.my.code.board.service.BoardService;
import to.my.code.board.status.BoardStatus;
import to.my.code.board.vo.BoardVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	BoardService<BoardVo> boardService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String boardList(
			@RequestParam(name="query", required=false) String query,
			@RequestParam(name="page", required=false) String page,
			HttpServletRequest request,
			Model model) {
		if(null == request.getSession().getAttribute("memberVo")) {
			return "redirect:/";
		}
		
		System.out.println("query : " + query);
		System.out.println("page : " + page);
		
		List<BoardVo> boardList = boardService.listAll();
		
		System.out.println(Arrays.asList(boardList));
		for(BoardVo boardVo2 : boardList) {
			System.out.println(boardVo2);
			System.out.println(boardVo2.getNo());
		}
		
		model.addAttribute("boardList", boardList);
		
		System.out.println("여기로 왔넹");
		
		return "/board/boardList";
	}
	
	@RequestMapping(value="{item}", method=RequestMethod.GET)
	public String boardItem(@PathVariable Long item, Model model) {
		System.out.println(item);
		
		BoardVo boardVo = boardService.read(item);
		model.addAttribute("boardVo", boardVo);
		
		return "/board/item";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(HttpServletRequest request) {
		if(null == request.getSession().getAttribute("memberVo")) {
			return "redirect:/";
		}
		
		return "/board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardVo boardVo) {
		System.out.println(boardVo);
		BoardStatus boardStatus = boardService.write(boardVo);
		
		if(boardStatus == BoardStatus.INSERT_FAIL) {
			return "redirect:/";
		}
		
		return "redirect:/board";
	}
}

package com.mvc.step2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// void -> ActionForward -> String(spring4.0, 5.0, boot) -> ModelAndView(Object, scope처리: spring2.5)
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// 시중 교재에서는 어노테이션으로 url매핑 처리하지만
// 수업에서는 스프링 프레임워크를 최대한 흉내
// 1-4에서는 가급적 if문을 버리고 메소드로 독립시켜본다
public class ActionServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ActionServlet.class);

	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService 호출 성공");
		// 요청 URL을 통해서 해당하는 업무의 컨트롤 클래스 객체를 주입받고 
		// 메소드 이름까지도 결정할 수 있다면 좋을 것 같은데..
		String requestURI = req.getRequestURI(); // -> /board2/boardApp.kh?crud=select
		// 컨텍스트는 톰캣 서버의 server.xml에 배포된 위치 정보 값을 참조함
		// /dev_web or 
		String contextPath = req.getContextPath(); // 빈값이다 / server.xml에서 mapping하여 '/'로 하였기 때문에 아무것도 안찍힌다
		logger.info("ContextPath에 담긴값은 ==============>"+ contextPath.length());
		String command = requestURI.substring(contextPath.length()+1); // board2/boardList.kh 담김
		logger.info("커맨드에 담긴값은 ===============>" +command);
		int end = command.indexOf("."); 
		command = command.substring(0, end); // board2 / boardList 담김
		String upmu[] = null; 
		upmu = command.split("/"); // upmu[0] = board2 , upmu[1] =board2App
		logger.info(upmu[0]+","+upmu[1]);
		req.setAttribute("upmu", upmu);
		// Board2Controller에 전달
		Board2Controller boardController = new Board2Controller();
		// 컨트롤 클래스에서 리턴타입을 String, ModelAndView (Spring2.X) [scope] 이원화 해보기 / 1-4번 계획
		Object obj = null;
		// req,res 참조변수(원본)값을 boardController에게 넘겨준다
		obj = boardController.execute(req,res);
		// page로 넘어오는 값의 유형
		// redirect:board2/boardInsert -> :(콜론) 있는 경우
		// response.sendRedirect("XXX.jsp");
		// forward:board2/boardList -> :(콜론) 있는 경우
		// board2/boardList -> :(콜론) 없는 경우
		if(obj != null) {
			String pageMove[] = null;
			if(obj instanceof String) {
				if(((String)obj).contains(":")) {
					logger.info(":콜론이 포함되어 있어요");
					// pageMove[0] = redirect or forward  - 리다이렉트 유무담기
					// pageMove[1] = board2/boardList.jsp - 페이지 이름
					pageMove = obj.toString().split(":");
				}else {
					logger.info(":콜론이 포함되어 있지않아요");
					pageMove = obj.toString().split("/");
				}
				logger.info("pageMove==>" + pageMove[0]+ "," + pageMove[1]);
			} // end of String
			else if(obj instanceof ModelAndView) {
				
			}
			// 출력 결과에 대한 페이지 정보가 있니?
			// 스프링에서는 왜 이런 처리를 제공하게 되었나?
			// ActionServlet은 모든 서비스의 요청을 가로채어 관리하기 위한 목적으로 설계됨
			// 웹 서비스 제공을 위한 클래스의 라이프 사이클에 대한 제어권을 F/W 에서 갖고자 함
			// 업무에 대한 처리와 처리 결과에 대한 응답 페이지에 대한 정보는 각 컨트롤 클래스에 갖지만
			// 전체적인 관리 감독은 ActionServlet에서 관리하도록 함
			// 결과적으로 ActionServlet의 역할은 사용자 요청에 대한 서비스를 담당할 적절한 컨트롤 클래스를
			// 찾아서 연결해 주고 각 업무별 추가된 컨트롤 클래스에서 지정한 페이지에 대한 요청 URL 의 조립은
			// ActionServlet에서 제공해줌
			if(pageMove != null) { // forward:board/boardList
				String path = pageMove[1]; // board/boardList담김
				// Board2Controller에 리턴값이 return "redirect:boardList.jsp"일 때
				if("redirect".equals(pageMove[0])) { // 너 select 아니야?
					res.sendRedirect(path);
				// Board2Controller에 리턴값이 return "forward:boardList"일 때
				// 요청 url ==> localhost:8000/board2/boardList -> boardList.jsp출력
				// boardList.kh가 있으면 안되는 이유 -> boardList.kh.jsp로 요청 url조립이 되니까 404
				// scope 요청이 유지되는 동안에는 주소번지를 사용할 수 있음
				}else if("forward".equals(pageMove[0])) { // 난 유지하게 해줄래
					// 사용자는 board2/boardList.kh를 요청하였지만 /board2/boardList.jsp로 이동한다
					RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp"); 
					view.forward(req, res);
					
				}
				// Board2Controller에 리턴값이 return "board2:boardList"일 때
				else{ // redirect나 forward문자열이 없는 경우라면? 
					path = pageMove[0]+"/"+pageMove[1];
					RequestDispatcher view = 
								req.getRequestDispatcher("/WEB-INF/jsp/"+path+".jsp");
					view.forward(req, res);
				}
			}// end of 출력페이지 호출 URL패턴 조립하기
		} // end of 컨트롤 계층 리턴결과
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet 호출 성공");
		doService(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet 호출 성공");
		doService(req, res);
	}

}

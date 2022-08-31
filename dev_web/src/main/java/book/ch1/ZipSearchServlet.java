package book.ch1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc.step3.ActionSupport;

@WebServlet("/ZipSearchServlet")
public class ZipSearchServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.info("doPost 호출 성공");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String address = request.getParameter("address"); // 사용자가 입력한 주소
		response.getWriter().write(getJSON(address)); // json형태로 출력
	}
	// 사용자가 입력한 주소로 db 검색하여 json으로 출력
	public String getJSON(String address) {
		if(address ==null) address = "";
		StringBuilder result = new StringBuilder("");
		result.append("{\"result\":[");
		ZipDAO zipDao = new ZipDAO();
		List<Zip> zipList = zipDao.search(address);
		for(int i = 0; i< zipList.size();i++) {
			result.append("[{\"value\":\"" + zipList.get(i).getZipcode()+"\"},");
			result.append("[{\"value\":\"" + zipList.get(i).getDong()+"\"},");
			result.append("[{\"value\":\"" + zipList.get(i).getUpd_update()+"\"},");
			result.append("[{\"value\":\"" + zipList.get(i).getAddress()+"\"}],");
		}
		result.append("]}");
		return result.toString();
	}
}

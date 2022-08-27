package com.mvc.step2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 인터페이스 선언만, 구현체 없이
public interface Controller {
	public String execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
}

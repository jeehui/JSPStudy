package service;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import repository.EmpDAO;

public class DetailService implements EmpService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 파라미터 no의 null 처리
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(optNo.orElse("0"));
		
		// 사원번호 no를 가진 사원정보를 request에 속성으로 저장하고,
		request.setAttribute("emp", EmpDAO.getInstance().selectEmpByNo(no));
		
		//session 방식: request가 session보다 강하기에 session으로 보여주려면 ${sessionScope.emp식으로 해야함}
		HttpSession session = request.getSession();
		session.setAttribute("emp", EmpDAO.getInstance().selectEmpByNo(no));
		
		// detail.jsp로 forward 하기
		return new ActionForward("emp/detail.jsp", false);
		
	}

}
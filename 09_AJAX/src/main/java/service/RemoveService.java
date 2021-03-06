package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import repository.MemberDAO;


public class RemoveService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(opt.orElse("0"));
		
		response.setContentType("application; charset=UTF-8");
		
		JSONObject obj = new JSONObject();
		obj.put("res", MemberDAO.getInstance().deleteMember(no));
		
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
		out.flush();
		out.close();
			
		
	}

}

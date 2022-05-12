package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.StaffDTO;
import repository.StaffDAO;

public class DetailService implements StaffService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		response.setContentType("application/json; charset=UTF-8");
		
		StaffDTO staff = StaffDAO.getInstance().selectStaffByNo("sno");
		boolean result = false;
		if(staff != null) {
			result = true;
		}
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		obj.put("staff", staff==null? null : new JSONObject(staff));
		
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
		out.flush();
		out.close();
		
	}

}

package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;

import domain.MemberDTO;
import repository.MemberDAO;

public class AddService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		
		MemberDTO member = MemberDTO.builder()
				.id(id)
				.name(name)
				.gender(gender)
				.address(address)
				.build();
		int res = MemberDAO.getInstance().insertMember(member);
		
		//insertMember() 메소드의 실행이 실패하는 경우(아이디 중복, 데이터 누락, 칼럭 크기 오류 등
		//Mybatis의 경우 PersistanceException 발생
		
		PrintWriter out =null; //두 세번 작업할 수 없게 하도록 null처리
		
		try {
		
		//응답 데이터 형식
		//JSON(이 식 외워두기)
		response.setContentType("application/json; charset=UTF-8");
		//응답 데이터 예시
		//형식 {"res" : res)
		//성공 {"res" : 1)
		//실패 {"res" : 0)
		
		//응답 데이터 상세
		//res : 회원의 등록이 성공하면 1, 실패하면 0을 저장한다.
		
		//1. 라이브러리를 사용하지 않는 경우
		//String responseText = "{\"res\": " + res +"}";
		
		//2. 라이브러리(JSON IN JAVA)를 사용하는 경우
		JSONObject obj = new JSONObject();
		obj.put("res", res);
		String responseText = obj.toString();
		
		//응답하기
		//성공 했을 때 응답으로 status==200인 상황
		//성공 했을 때 응답은 jQuery.ajax의 success 프로퍼티로 넘어간다.
		
			out = response.getWriter();
			out.write(responseText); //out.print(responseText), out.println(responseText) 모두 가능
			//responseText는 프론트쪽 jsp의 ajax success: function(responseText)로 쓰임
			out.flush();
			out.close();
		}catch(PersistenceException e) {
			
			
			//실패 했을 때 응답으로 status!=200인 상황(기본적으로 서버 측 오류이면 status==500인 경우)
			//실패 했을 때 응답은 jQuery.ajax의 error 프로퍼티로 넘어간다.
			
			//실패 했을 때 응답은 alert으로 처리
			response.setContentType("text/plain; charset=UTF-8");
			
			//status 수정(원하면 할 수 있다. 무조건 하는 것이 아니다.)
			response.setStatus(1818);
			
			//실패 했을 때 응답할 텍스트
			out = response.getWriter();
			out.write("데이터베이스에 등록되지 않았습니다.");
			out.flush();
			out.close();
			
		}
		
		
	}

}

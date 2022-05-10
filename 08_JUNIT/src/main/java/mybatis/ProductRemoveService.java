package mybatis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductRemoveService implements ProductService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 productNo
		Long productNo = 0L;
		String strNo = request.getParameter("productNo");
		if(strNo == null || strNo.isEmpty()) {
		// 박스를 받지 못했음 || 박스를 받았으나 내용물이 없었음 같은 차이
			productNo = 0L; 
		// 0으로 데이터가 보내지지만 결국엔 삭제가 안된다. 시퀀스로 이루어져 있기에 1부터 시작
		} else {
			productNo = Long.parseLong(strNo);
		}
		
		int res = ProductDAO.getInstance().deleteProduct(productNo);
		
		/*삭제 성공 메시지 가지고 이동*/
		try {
		if(res>0) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('제품 정보가 삭제되었습니다.')");
			out.println("location.href='/JUNIT/list.do'");
			out.println("</script>");
			out.flush();
			out.close();
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
		
		/*삭제 성공 메시지 없이 이동
		ActionForward af = null;
		if(res > 0) {
			af = new ActionForward("/JUNIT/list.do", true); //삭제한후 이동은 redirect니까 true
		}

		return af;
		*/
	}

}

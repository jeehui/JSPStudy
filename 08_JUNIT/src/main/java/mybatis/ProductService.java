package mybatis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductService {
	public mybatis.ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}

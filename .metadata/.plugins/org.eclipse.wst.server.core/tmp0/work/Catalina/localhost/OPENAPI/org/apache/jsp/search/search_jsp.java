/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.43
 * Generated at: 2022-05-04 00:07:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.search;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.js\" integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("\t// 페이지 로드 이벤트\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\tfnSearch();\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t// 함수\r\n");
      out.write("\tfunction fnSearch(){\r\n");
      out.write("\t\t$('#btnSearch').on('click', function(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl: '/OPENAPI/search.do',\r\n");
      out.write("\t\t\t\tdata: $('#formSearch').serialize(),\r\n");
      out.write("\t\t\t\ttype: 'get',\r\n");
      out.write("\t\t\t\tdataType: 'json',\r\n");
      out.write("\t\t\t\tsuccess: function(responseText){\r\n");
      out.write("\t\t\t\t\t$('#products').empty();\r\n");
      out.write("\t\t\t\t\t$.each(responseText.items, function(i, product){\r\n");
      out.write("\t\t\t\t\t\tvar tr = '<tr>';\r\n");
      out.write("\t\t\t\t\t\ttr += '<td><a href=\"' + product.link + '\">' + product.title + '</a></td>'; \r\n");
      out.write("\t\t\t\t\t\ttr += '<td><a href=\"' + product.link + '\"><img src=\"' + product.image + '\" alt=\"' + product.title + '\"></a></td>';\r\n");
      out.write("\t\t\t\t\t\ttr += '<td>' + product.lprice + '</td>';\r\n");
      out.write("\t\t\t\t\t\ttr += '<td>' + product.hprice + '</td>';\r\n");
      out.write("\t\t\t\t\t\ttr += '<td>' + product.mallName + '</td>';\r\n");
      out.write("\t\t\t\t\t\t$('#products').append(tr);  // $(tr).appendTo('#products');\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(jqXHR){\r\n");
      out.write("\t\t\t\t\talert(jqXHR.responseText);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<form id=\"formSearch\">\r\n");
      out.write("\t\t\t<label for=\"query\">\r\n");
      out.write("\t\t\t\t검색\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"query\" id=\"query\">\t\r\n");
      out.write("\t\t\t</label>\r\n");
      out.write("\t\t\t<label for=\"display\">\r\n");
      out.write("\t\t\t\t검색결과건수\r\n");
      out.write("\t\t\t\t<select name=\"display\" id=\"display\">\r\n");
      out.write("\t\t\t\t\t<option value=\"10\" selected>10</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"20\">20</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"40\">40</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"60\">60</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"80\">80</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"100\">100</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</label>\r\n");
      out.write("\t\t\t<label for=\"sim\">유사도순<input type=\"radio\" name=\"sort\" id=\"sim\" value=\"sim\" checked></label>\r\n");
      out.write("\t\t\t<label for=\"date\">날짜순<input type=\"radio\" name=\"sort\" id=\"date\" value=\"date\"></label>\r\n");
      out.write("\t\t\t<label for=\"asc\">낮은가격순<input type=\"radio\" name=\"sort\" id=\"asc\" value=\"asc\"></label>\r\n");
      out.write("\t\t\t<label for=\"dsc\">높은가격순<input type=\"radio\" name=\"sort\" id=\"dsc\" value=\"dsc\"></label>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"검색\" id=\"btnSearch\">\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>상품명</td>\r\n");
      out.write("\t\t\t\t\t<td>썸네일</td>\r\n");
      out.write("\t\t\t\t\t<td>최저가</td>\r\n");
      out.write("\t\t\t\t\t<td>최고가</td>\r\n");
      out.write("\t\t\t\t\t<td>판매처</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody id=\"products\"></tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Covid19InfStateJsonService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//인증키(Decoding)
		String servicekey = "PDpueP7ioEqV8R0f0UbybCoFCgO6izDEu7zBd3Zc7GEUkQMsoZYrVbbcLm+WAWon/ZezrbFHxamiu3z/Ch1Mtg==";
		
		//API 주소
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
			sb.append("?serviceKey=").append(URLEncoder.encode(servicekey, "UTF-8"));
			sb.append("&pageNo=").append(URLEncoder.encode("1", "UTF-8"));
			sb.append("&numOfRows=").append(URLEncoder.encode("10", "UTF-8"));
			sb.append("&startCreateDt=").append(URLEncoder.encode("20200310", "UTF-8"));
			sb.append("&endCreateDt=").append(URLEncoder.encode("20200315", "UTF-8"));
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = sb.toString();
		
		//API 주소 연결
		URL url = null;
		HttpURLConnection con = null;
		try {
			url= new URL(apiURL);
			con= (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		} catch(MalformedURLException e) {
			e.printStackTrace(); 
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//연결된 API에서 xml 받아오기
		//응답 스트림 
		BufferedReader br = null;
		StringBuilder sb2 = new StringBuilder();
		try {
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			//xml 읽어 들이기
			String line = null;
			while((line = br.readLine())!=null){
				sb2.append(line + "\n");
			}
			
			if(br != null) {
				br.close();
			}
			if(con != null) {
				con.disconnect();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/xml; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(sb2.toString()); //ajax의 success로 넘어감
		out.flush();
		out.close();
		
	}
}

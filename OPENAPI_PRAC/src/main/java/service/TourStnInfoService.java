package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TourStnInfoService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String servicekey = "PDpueP7ioEqV8R0f0UbybCoFCgO6izDEu7zBd3Zc7GEUkQMsoZYrVbbcLm+WAWon/ZezrbFHxamiu3z/Ch1Mtg==";
		
		StringBuilder sb = new StringBuilder();
		try {
				sb.append("http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst\r\n");
				sb.append("?serviceKey=").append(URLEncoder.encode(servicekey, "UTF-8"));
				sb.append("&numOfRows=").append(URLEncoder.encode("10", "UTF-8"));
				sb.append("&pageNo=").append(URLEncoder.encode("1", "UTF-8"));
				sb.append("&CURRENT_DATE=").append(URLEncoder.encode("2016121010", "UTF-8"));
				sb.append("&HOUR=").append(URLEncoder.encode("24", "UTF-8"));
				sb.append("&COURSE_ID=").append(URLEncoder.encode("1", "UTF-8"));
					
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String apiURL = sb.toString();
		
		//API 주소 연결
		URL url = null;
		HttpURLConnection con= null;
		try {
			url = new URL(apiURL);
			con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = null;
		StringBuilder sb2 = new StringBuilder();
		try {
			// 응답 성공하면 정상 스트림, 응답 실패하면 에러 스트림
				if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
			//json 읽어들이기
				
			//스트림 , 연결 종료
				if(br!=null) {
					br.close();
				}
				if(con!=null) {
					con.disconnect();
				}
			}catch(IOException e) {
				e.printStackTrace();
		}
	}
}

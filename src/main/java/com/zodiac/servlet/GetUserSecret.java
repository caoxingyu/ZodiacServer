package com.zodiac.servlet;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zodiac.utils.NetworkConnection;


@WebServlet("/getUserId")
public class GetUserSecret extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final String APPID="wx5f57ec4e114278db",SECRET="f1655451e5f59aa67d67ecbce4937222";
    
    public GetUserSecret() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		StringBuilder sb=new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
		sb.append("appid="+APPID+"&");
		sb.append("secret="+SECRET+"&");
		sb.append("js_code="+code+"&");
		sb.append("grant_type=authorization_code");
		
		String result=NetworkConnection.get(sb.toString());
		System.out.println(result);
		
		response.getWriter().write(result);
         		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

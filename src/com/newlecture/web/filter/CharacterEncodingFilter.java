package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//1.web.xml, 2,어노테이션
@WebFilter(
		urlPatterns={"/*"},
		initParams= {@WebInitParam(name="encoding", value="UTF-8")}
		)
public class CharacterEncodingFilter implements Filter{
	private String encoding = "UTF-8";
	@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			String encoding = filterConfig.getInitParameter("encoding");
			
			if(encoding != null && encoding.equals(""))
				this.encoding = encoding;
		}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("필터 사전 실행");
		
		request.setCharacterEncoding(encoding);
		//dofilter-> 이것을 하게되면 다음체인 실행 맨마지막은 서블릿까지 실행.
		chain.doFilter(request, response);
		
		//System.out.println("필터 사후 실행");
	}

}

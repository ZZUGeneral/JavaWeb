package ts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class ServiceFilter implements Filter {
	// private String excludedPages;
	// private String[] excludedPageArray;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		boolean isExcludedPage = false;
		if (httpRequest.getPathInfo().contains("doLogin")) {
			isExcludedPage = true;
		}

		String path = httpRequest.getPathInfo();
		System.out.println("===========" + path + "===================" + isExcludedPage);
		if (!isExcludedPage) {
			String header = httpRequest.getHeader("token");
			System.out.println("===================" + header);
			if (header == null || header.length() == 0) {
				System.out.println("验证失败！！！");
				return;
			} /*
				 * else { JwtToken jwt = new JwtToken(); try {
				 * if(jwt.parseJWT(header).getId()!="111") { return; } } catch (Exception e) {
				 * // TODO Auto-generated catch block e.printStackTrace(); } }
				 */
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		/*
		 * excludedPages = filterConfig.getInitParameter("excludedPages");
		 * System.out.println(excludedPages+"================="); if
		 * (StringUtils.isNotEmpty(excludedPages)) { excludedPageArray =
		 * excludedPages.split(","); }
		 */
	}

}

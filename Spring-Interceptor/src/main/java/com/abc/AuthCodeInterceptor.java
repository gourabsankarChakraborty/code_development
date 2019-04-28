package com.abc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.abc.service.H2HService;

@Component
public class AuthCodeInterceptor implements HandlerInterceptor {

	@Autowired
	H2HService h2hService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("prehandle");
		boolean hasAccess = false;
		Map<Integer, List<String>> map = null;
		map = h2hService.getRollMapping();
		// }
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		String role = request.getHeader("userName");
		System.out.println(path);

		Object object = map.get(1);
		if (object != null) {
			List<String> urlList = (List<String>) (object);
			hasAccess = !CollectionUtils.isEmpty(urlList) ? urlList.contains(path) : false;
		} 
		if(!hasAccess){
			throw new HttpServerErrorException(HttpStatus.METHOD_NOT_ALLOWED);
		}
		return hasAccess;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("POST HANDLE");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AFTER HANDLE");

	}

}

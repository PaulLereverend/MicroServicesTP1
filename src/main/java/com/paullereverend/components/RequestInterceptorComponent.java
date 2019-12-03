package com.paullereverend.components;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.paullereverend.MicroServiceTp1Application;

@Component
public class RequestInterceptorComponent implements HandlerInterceptor {
 
    private static final Logger logger = Logger.getLogger(RequestInterceptorComponent.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    	long startTime = Instant.now().toEpochMilli();
    	  logger.info("Request URL::" + request.getRequestURL().toString() +
    	   ":: Start Time=" + Instant.now());
    	  request.setAttribute("startTime", startTime);
      return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
     Exception exception) throws Exception {


      /*long renderingStartTime = (Long)request.getAttribute("rendering-start-time");
      long renderingEndTime = System.currentTimeMillis();
      long renderingDuration = renderingEndTime - renderingStartTime;
      ThreadContext.put("rendering-duration", renderingDuration);
      logger.info("My interceptor handler message");
      ThreadContext.clearMap();*/
    }
}
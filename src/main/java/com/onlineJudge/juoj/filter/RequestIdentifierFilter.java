//package com.onlineJudge.juoj.filter;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.slf4j.MDC;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.ZonedDateTime;
//import java.util.Date;
//import java.util.UUID;
//
//@Component
//@Order(1)
//public class RequestIdentifierFilter extends OncePerRequestFilter {
//
//    private static final Logger LOGGER = LogManager.getLogger(RequestIdentifierFilter.class);
//
//    public String REQUEST_ID = "requestId";
//    public String REQUEST_TIME = "requestTime";
//    public String REQUEST_ID_LOGGING = "requestIdLogging";
//    public String X_USER_ID = "x-user-id";
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        String requestId = "c-" + System.nanoTime() + UUID.randomUUID();
//        String requestTime = new Date().toString();
//
//        MDC.put(REQUEST_ID, requestId);
//        request.setAttribute(REQUEST_ID_LOGGING, requestId);
//
//        String loggedInUserName = "shubham";
//        LOGGER.info("logged in username: " + loggedInUserName);
//        if (loggedInUserName != null) {
//            request.setAttribute(X_USER_ID, loggedInUserName);
//        }
//
//        ThreadLocalContext.putValue(ThreadLocalConstant.REQUEST_ID, requestId);
//        ThreadLocalContext.putValue(ThreadLocalConstant.REQUEST_TIME, requestTime);
//
//        try {
//            filterChain.doFilter(request, response);
//        } finally {
//            ThreadLocalContext.clear();
//        }
//    }
//}

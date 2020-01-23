package com.java.multitenancy.config;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MDCFilter extends OncePerRequestFilter {

  private static final String REQUEST_ID = "requestId";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    String requestId = StringUtils.isNotBlank(request.getHeader(REQUEST_ID))
        ? request.getHeader(REQUEST_ID) : UUID.randomUUID().toString();
    String rqHeader = URLEncoder.encode(requestId, StandardCharsets.UTF_8.displayName());

    MDC.put(REQUEST_ID, requestId);
    try {
      filterChain.doFilter(request, response);
    } finally {
      response.setHeader(REQUEST_ID, rqHeader);
      MDC.remove(REQUEST_ID);
    }
  }
}
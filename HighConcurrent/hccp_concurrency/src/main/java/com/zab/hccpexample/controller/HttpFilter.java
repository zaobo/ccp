package com.zab.hccpexample.controller;

import com.zab.hccpexample.example.threadlocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        RequestHolder.add(Thread.currentThread().getId());
        log.info("do filter, {}, {}", Thread.currentThread().getId(), ((HttpServletRequest) request).getServletPath());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

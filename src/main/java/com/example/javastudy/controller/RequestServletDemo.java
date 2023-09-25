package com.example.javastudy.controller;

import com.example.javastudy.utils.StringUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
@WebServlet("/request/*")
public class RequestServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String method = StringUtil.subUri(uri);
        switch (method){
            case "demo1" : {

            }
            case "demo2" : {

            }
            case "demo3" : {

            }
            case "demo4" : {

            }
            case "demo5" : {

            }
            case "demo6" : {

            }
            case "demo7" : {

            }
            case "demo8" : {

            }
            case "demo9" : {

            }
        }
    }

    private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("response demo1");
    }
    private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("response demo2");
    }
    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("response demo3");
    }
    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("response demo4");
    }
    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("response demo5");
    }
    private void demo6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("response demo6");
    }
    private void demo7(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("response demo7");
    }
    private void demo8(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        log.info("response demo8");
    }




}

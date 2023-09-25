package com.example.javastudy.controller;

import com.example.javastudy.utils.StringUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;


@Slf4j
@WebServlet("/response/*")

public class ResponseServletDemo extends HttpServlet {
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
                this.demo1(req,resp);
            }
            case "demo2" : {
                this.demo2(req,resp);
            }
            case "demo3" : {
                this.demo3(req,resp);
            }
            case "demo4" : {
                this.demo4(req,resp);
            }
            case "demo5" : {
                this.demo5(req,resp);
            }
            case "demo6" : {
                this.demo6(req,resp);
            }
            case "demo7" : {
                this.demo7(req,resp);
            }
            case "demo8" : {
                this.demo8(req,resp);
            }
        }
    }

  private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
      System.out.println("ResponseDemo1");
      // "访问responseDemo1，会自动跳转到／responseDemo2资源
      // 1．设置状态码为302
      resp.setStatus(302);
      // 设置响应头location
      resp.setHeader("location", "/day03/responseDemo2");
      req.setAttribute("msg", "response");
      //动态获取虚拟目录
      String contextPath = req.getContextPath();
      //简单的重定向方法
      //resp.sendRedirect(contextPath + "/responseDemo2");
      //重定向可以跨域访问
      resp.sendRedirect("https://www.baidu.cn");
      log.info("response demo1");
  }
    private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("responseDemo被访问...");
        Object msg = req.getAttribute("msg");
        System.out.println(msg);

        log.info("response demo2");
    }
    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/responseDemo2").forward(req,resp);
        log.info("response demo3");
    }
    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取流对象之前，设置流的默认编码：ISO—8859—1 设置为：GBK
        //response,setCharacterEncoding("utf-8");
        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码//response.setHeader("content-type","text/html;charset=utf-8");
        //简单形式设置编码
        resp.setContentType("text/html;charset=utf-8");
        //1．获取字符输出流
        PrintWriter pw = resp.getWriter();
        //2．输出数据
        //pw.write("<h1>hello response</h1>");
        pw.write("你好 response");
        log.info("response demo4");
    }
    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        //获取字节输出流
        ServletOutputStream sos = resp.getOutputStream();
        sos.write("你好".getBytes(StandardCharsets.UTF_8));
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

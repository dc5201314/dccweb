package com.example.javastudy.controller;

import com.example.javastudy.utils.StringUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet/*")
public class ServletContextDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String uri = req.getRequestURI();
        String method = StringUtil.subUri(uri);
        switch (method) {
            case "demo1": {

                this.demo1(req, resp);
            }
            case "demo2": {
                this.demo2(req, resp);
            }
            case "demo3": {
                this.demo3(req, resp);
            }
            case "demo4": {
                this.demo4(req, resp);
            }
            case "demo5": {
                this.demo5(req, resp);
            }
        }


    }

    private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //t通过request对象获取
        ServletContext context =req.getServletContext();
        //通过HttpServlet获取
        ServletContext context2 = req.getServletContext();
        System.out.println(context);
        System.out.println(context2);

        System.out.println(context == context2);
        return;

    }
    private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       /*
           ServletContext功能： 1．获取MIME类型：
           MIME类型：在互联网通信过程中定义的一种文件数据类型格式：大类型／小类型
           text/html
           image/jpeg 获取：String getMimeType（String file）
           2．域对象：共享数据
           3．获取文件的真实（服务器）路径*/
        //2．通过HttpServlet获取
        ServletContext context = this.getServletContext();
        //3．定义文件名称
        String filename = "a.jpg";
        //4．获取MIME类型
        String mimeType=context.getMimeType(filename); System. out.println(mimeType);

    }
    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //通过httpServlet获取
        ServletContext context = this.getServletContext();
        context.setAttribute("msg","你好");

    }
    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //通过httpServlet获取
        ServletContext context = this.getServletContext();
        Object msg =context.getAttribute("msg");
        System.out.println(msg);

    }
    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //通过httpServlet获取
        ServletContext context = this.getServletContext();

        String b = context.getRealPath("/b.txt");
        System.out.println(b);

        String c =context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        String a =context.getRealPath("/WEB-INF/a.txt");
        System.out.println(a);
    }
}
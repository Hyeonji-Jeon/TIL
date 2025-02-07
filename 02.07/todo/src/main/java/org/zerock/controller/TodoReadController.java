package org.zerock.controller;

import java.io.IOException;

import org.zerock.dto.TodoDTO;
import org.zerock.service.TodoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/todo/read/*"})
public class TodoReadController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TodoReadController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();
            String[] arr = uri.split("/");
            String tnoStr = arr[3];
            
            int tno = Integer.parseInt(tnoStr);
            
            TodoDTO dto = TodoService.INSTANCE.read(tno);
            
            request.setAttribute("dto", dto);
            
            request.getRequestDispatcher("/WEB-INF/views/todo/read.jsp").forward(request, response);
        } catch (Exception var7) {
            response.sendError(404, "에러가 발생했습니다! 상태 코드: 404");
        }

    }
}

package org.zerock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.zerock.dto.TodoAddDTO;
import org.zerock.service.TodoService;

/**
 * Servlet implementation class TodoAddController
 */
@WebServlet("/todo/add")
public class TodoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/todo/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("TodoAddController doPost.............");
		
		//전달되는 모든 데이터 인코딩 처리 한글 처리용
		request.setCharacterEncoding("UTF-8");
		
		String titleStr = request.getParameter("title");    //HTML폼에서 입력받은 데이터를 가져오는 코드
		String writerStr = request.getParameter("writer");
		
		System.out.println("title: " + titleStr);
		System.out.println("writer: " + writerStr);
		
		TodoAddDTO addDTO = new TodoAddDTO();
		addDTO.setTitle(titleStr);
		addDTO.setWriter(writerStr);
		
		System.out.println(addDTO);
		
		try {
			TodoService.INSTANCE.add(addDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// /todo/list 경로로 브라우저에게 이동하라고 명령한다.
		response.sendRedirect("/todo/list?result=add");
		
	}

}

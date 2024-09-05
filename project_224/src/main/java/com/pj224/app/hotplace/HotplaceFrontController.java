package com.pj224.app.hotplace;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Result;
import com.pj224.app.dao.HotplaceDAO;
import com.pj224.app.dto.HotplaceDTO;

/**
 * Servlet implementation class HotplaceFrontController
 */
//@WebServlet("/HotplaceFrontController")
public class HotplaceFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotplaceFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hotplace 서블릿 실행");


		// 전체 URI에서 ContextPath를 제외시킨 부분만 변수에 저장(분기처리할 때 비교할 변수로 사용)
		String target = request.getRequestURI().substring(request.getContextPath().length());

	    HotplaceDAO hotplaceDAO = new HotplaceDAO();
	    List<HotplaceDTO> hotplaceList = null;

		switch (target) {
		case "/hotplace/hotplace-euljiro.hp":
            hotplaceList = hotplaceDAO.showInfo("을지로입구역");

            request.setAttribute("hotplaceList", hotplaceList);
            request.getRequestDispatcher("/app/hotplace/hotplace-euljiro.jsp").forward(request, response);
            break;
        case "/hotplace/hotplace-gangnam.hp":
            hotplaceList = hotplaceDAO.showInfo("강남역");

            request.setAttribute("hotplaceList", hotplaceList);
            request.getRequestDispatcher("/app/hotplace/hotplace-gangnam.jsp").forward(request, response);
            break;
		case "/hotplace/hotplace-hongdae.hp":
            hotplaceList = hotplaceDAO.showInfo("홍대입구역");

            request.setAttribute("hotplaceList", hotplaceList);
            request.getRequestDispatcher("/app/hotplace/hotplace-hongdae.jsp").forward(request, response);
            break;
		case "/hotplace/hotplace-jamsil.hp":
            hotplaceList = hotplaceDAO.showInfo("잠실역");

            request.setAttribute("hotplaceList", hotplaceList);
            request.getRequestDispatcher("/app/hotplace/hotplace-jamsil.jsp").forward(request, response);
            break;
		case "/hotplace/hotplace-moonrae.hp":
            hotplaceList = hotplaceDAO.showInfo("문래역");

            request.setAttribute("hotplaceList", hotplaceList);
            request.getRequestDispatcher("/app/hotplace/hotplace-moonrae.jsp").forward(request, response);
            break;
		case "/hotplace/hotplace-seongsu.hp":
            hotplaceList = hotplaceDAO.showInfo("성수역");

            request.setAttribute("hotplaceList", hotplaceList);
            request.getRequestDispatcher("/app/hotplace/hotplace-seongsu.jsp").forward(request, response);
            break;

		}

	}

}
 
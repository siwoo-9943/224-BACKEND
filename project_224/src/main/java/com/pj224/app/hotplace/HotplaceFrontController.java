package com.pj224.app.hotplace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.Result;
import com.pj224.app.community.CommunityWriteOkController;
import com.pj224.app.dao.HotplaceDAO;
import com.pj224.app.dto.HotplaceDTO;
import com.pj224.app.dto.LikeDTO;
import com.pj224.app.dto.MemberDTO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;
		boolean isForwarded = false;

		request.setAttribute("target", target);

		switch (target) {
		case "/hotplace/pick.hp":
			result = new HotplacePickController().MemExecute(request, response);
			break;
		case "/hotplace/unpick.hp":
			result = new HotplaceUnPickController().MemExecute(request, response);
			break;
		default :
			result = new HotplaceListController().MemExecute(request, response);
			break;
		}
		
		if (!isForwarded && result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}

	}

}
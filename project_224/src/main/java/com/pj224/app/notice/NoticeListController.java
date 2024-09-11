package com.pj224.app.notice;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.Result;
import com.pj224.app.dto.NoticeDTO;


public class NoticeListController implements MemExecute  {

	   @Override
	   public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {

		   System.out.println("컨트롤러 들어옴");
		   request.setCharacterEncoding("UTF-8");

		   // 페이지 처리 관련 변수
		   int itemsPerPage = 5;  // 한 페이지에 보여줄 항목 수
		   int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

		   // DAO 사용하여 전체 데이터 가져오기
		   NoticeDAO noticeDAO = new NoticeDAO();
		   List<NoticeDTO> noticeList = noticeDAO.showList();  // 전체 리스트 조회
		   int totalItems = noticeList.size();  // 전체 항목 수
		   int maxPages = (int) Math.ceil((double) totalItems / itemsPerPage);  // 전체 페이지 수 계산

		   // 현재 페이지에 표시할 데이터만 추출
		   int start = (currentPage - 1) * itemsPerPage;
		   int end = Math.min(start + itemsPerPage, totalItems);
		   List<NoticeDTO> paginatedList = noticeList.subList(start, end);  // 페이지에 맞는 데이터 추출

		   // 페이지네이션 범위 설정 (5페이지씩 표시)
		   int pageBlockSize = 5;
		   int startPage = ((currentPage - 1) / pageBlockSize) * pageBlockSize + 1;
		   int endPage = Math.min(startPage + pageBlockSize - 1, maxPages);

		   // JSP로 데이터를 전달
		   request.setAttribute("noticeList", paginatedList);  // 추출한 데이터만 전달
		   request.setAttribute("currentPage", currentPage);
		   request.setAttribute("maxPages", maxPages);
		   request.setAttribute("startPage", startPage);
		   request.setAttribute("endPage", endPage);

		   System.out.println(paginatedList);

		   // 결과 처리
		   Result result = new Result();
//		   result.setRedirect(false); 
//		   result.setPath(request.getContextPath() + "/app/notice/notice-admain.jsp");
		   System.out.println("실행확인");

		   return result;
	   }
	}

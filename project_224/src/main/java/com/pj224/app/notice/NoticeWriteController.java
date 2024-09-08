package com.pj224.app.notice;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.Execute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.NoticeDTO;

public class NoticeWriteController {
//	@Override
//	public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
//	      	request.setCharacterEncoding("UTF-8");
//	      	
//			System.out.println("컨드롤러 들어옴4");
//			Result result = new Result();
//	      	
//	        NoticeDTO noticeDTO = new NoticeDTO();
//	        NoticeDAO noticeDAO = new NoticeDAO();
//	      	
//	      	List<noticeDTO> writeList = null;
//	      	
//	      	try {
//	      		writeList = new noticeDAO().select();
//	      	} catch(SQLException e) {
//	      		e.printStackTrace();
//	      	}
//	      	
//	      	request.setAttribute("writeList", writeList);
//	      	
//	      	return result;
//	}
}
//public class NoticeWriteController implements MemExecute {
//
//		@Override
//		public void MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
//		      	request.setCharacterEncoding("UTF-8");
//			     
//				System.out.println("컨드롤러 들어옴2");
//				Result result = new Result();
				//

//		        NoticeDTO noticeDTO = new NoticeDTO();
//		        NoticeDAO noticeDAO = new NoticeDAO();
//		        noticeDTO.setNoticeCate(request.getParameter("noticeCate"));
//		        noticeDTO.setNoticeTitle(request.getParameter("noticeTitle"));
//		        noticeDTO.setNoticeContent(request.getParameter("noticeContent"));
//		        noticeDTO.setMemberNumber(Integer.parseInt(request.getParameter("memberNumber")));
//
//		        SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory();
//		        NoticeDAO noticeDAO = new NoticeDAO(sqlSession);
//		        noticeDAO.write(noticeDTO);
		        
		        
				//
//		        NoticeDAO noticeDAO = new NoticeDAO();
		        

		        // 리스트를 가져와서 request에 설정
//		        NoticeDTO noticeDTO = noticeDAO.write();
//		        request.setAttribute("noticewrite", noticeDTO);
//		        
//		        System.out.println(noticeDTO);
//		        
//		        result.setRedirect(false);
//		        result.setPath(request.getContextPath() + "/app/notice/notice-write.jsp");
		        
		        // 포워드 처리는 프론트 컨트롤러에서 담당
//		        return result;
//	   }


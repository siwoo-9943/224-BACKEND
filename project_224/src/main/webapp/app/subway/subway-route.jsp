<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<%@ include file="../../header.jsp"%>
<body>
<div class="sub-map" style="text-align: center;">
<h1>2호선 지하철 노선도</h1>
    <div style="width: 70%; display: inline-block;">
      <img src="${pageContext.request.contextPath }/assets/images/subwayLine2.png" style="width:70%">
    </div>
  </div>

</body>
<%@ include file="../../footer.jsp"%>
</html>
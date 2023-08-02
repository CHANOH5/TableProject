<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


	<link href="/resources/css/list.css" rel="stylesheet">

	<script
	  src="https://code.jquery.com/jquery-3.4.1.js"
	  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	  crossorigin="anonymous">
	</script>

</head>
<body>

	<h1> 게시물 페이지 </h1>
	<a href="/board/enroll">게시판 등록페이지로 이동</a>
	
	<table>
		<thead>
			<tr>
				<th class="bno_width">번호</th>
				<th class="title_width">제목</th>
				<th class="content_width">내용</th>
				<th class="writer_width">작성자</th>
				<th class="regdate_width">등록일</th>
				<th class="updatedate_width">수정일</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="ol">
			<tr>
				<td>${ol.bno}</td>
				<td>
					<a class="move" href='/board/get?bno=${ol.bno}'>${ol.title }</a>
				</td>
				<td>${ol.content }</td>
				<td>${ol.writer }</td>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${ol.regdate}"/></td>
                <td><fmt:formatDate pattern="yyyy/MM/dd" value="${ol.updateDate}"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="pageInfo_wrap">
		<div class="pageInfo_area">
			<ul id="pageInfo" class="pageInfo">
			
			    <!-- 이전페이지 버튼 -->
                <c:if test="${pageMaker.prev}">
                    <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
                </c:if>
			
                <!-- 각 번호 페이지 버튼 -->
                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"><a href="${num}">${num}</a></li>
                </c:forEach>
                
                <!-- 다음페이지 버튼 -->
                <c:if test="${pageMaker.next}">
                    <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
                </c:if>    
            </ul>
		</div>
	</div>
	
	<form id="moveForm" method="get">
        <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
        <input type="hidden" name="amount" value="${pageMaker.cri.amount }">  
	</form>
	
	
	
	<script>
	
		$(document).ready(function(){
		    
			let result = "${result}";
		    
		    checkAlert(result);
		    console.log(result);
		    
		    function checkAlert(result){
		        
		        if(result === ''){
		            return;
		        }
		        
		        if(result === "enroll success"){
		            alert("등록이 완료되었습니다.");
		        }
		        
		        if(result === "modify success"){
		            alert("수정이 완료되었습니다.");
		        }
		        
		        if(result === "delete success"){
		        	alert("게시물이 삭제 되었습니다.");
		        }
			    
		    }    
		    
		});
		
		let moveForm = $("#moveForm"); 
		
	    $(".pageInfo a").on("click", function(e){
	    	 
	        e.preventDefault();
	        
	        moveForm.find("input[name='pageNum']").val($(this).attr("href"));
	        moveForm.attr("action", "/board/list");
	        moveForm.submit();
	        
	    });
	    
	</script>


</body>
</html>
<%@page import="com.newlecture.web.dao.oracle.NoticeView"%>
<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    /* NoticeDao noticeDao = new FileNoticeDao();
    List<NoticeView> notices = noticeDao.getList();
    //MVC
/*     List<Notice> notices = new ArrayList<>(); */
    //자바 프로그래밍의 입장
    // 데이터를 제공하는 코드블록 -> data service Object:DAO
    //List<Notice> getNoticeList(){
 /*    FileInputStream fis = new FileInputStream("D:\\java\\workspace\\JSPPrj\\WebContent\\WEB-INF\\data\\notice-file.df");
    Scanner fscan = new Scanner(fis);
    
    String line = "";
    
    while(fscan.hasNextLine()){
    line = fscan.nextLine();	
   /*  line = line.replaceAll("^\\s+", ""); */
   /*  Notice notice = new Notice(line.split(","));
    notices.add(notice);
    }
    
    fscan.close();
    fis.close(); */ 
    //여기까지가------
    //} */
    %>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<mete name="viewport" content="width=device-width, initial-scale=1">
<title>Document</title>
<!-- 스타일 속성(X)-> 외부파일에 따로 두기. 불러옴. import방법도 있음.(로딩시간 걸릴수도있음.--> <!-- <link rel="stylesheet" href="../CSS/reset.css" type="text/css"> -->
<link rel="stylesheet" href="../CSS/style.css" type="text/css">
<style>
#footer {
	width: 100px;
}
</style>
</head>

<body>


	<!--     <header id="header">
        <div class="content-box">
            <h1 id="logo">뉴렉처 온라인</h1>
            <section>
                <h1 class="d-none">머릿말</h1>

                <nav id="main-menu">
                    <h1 class="d-none">메인메뉴</h1>
                    <ul>
                        <li><a href="">학습가이드</a></li>
                        <li><a href="">강좌선택</a></li>
                        <li><a href="">AnswerIs</a></li>
                    </ul>
                </nav>

                <section id="lecture-search-form">
                    <h1 class="d-none">강좌검색 폼</h1>
                    <form>
                        <label>과정검색</label>
                        <input type="text">
                        <input type="submit" value="검색">
                    </form>
                </section>

                <nav id="member-menu">
                    <h1 class="d-none">회원메뉴</h1>
                    <ul>
                        <li>HOME</li>
                        <li>로그인</li>
                        <li>회원가입</li>
                    </ul>
                </nav>

                <nav id="direct-menu">
                    <h1 class="d-none">자주 사용하는 메뉴</h1>
                    <ul>
                        <li>마이페이지</li>
                        <li>고객센터</li>
                    </ul>
                    <nav>
            </section>
    </header> -->
	<jsp:include page="../inc/header.jsp" />
	</div>
	<!-- visual block -->
	<div id="visual">
		<div class="content-boxa" style="position: relative">
			<!-- <div class="test">

            </div>
            static 자동 relative static에서 얼마더 absolute 수동 fixed 고정 sticky
            <span >사진</span>
            <img style="left:100px;top:100px;position: absolute;"
                src="https://image.fmkorea.com/files/attach/new/20180417/486616/41170129/1021006724/554449902566a4417eee09a4fdb7bd79.jpg">
            <span>사진사진</span>
            <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHPHV0j5HE7nNGbRAmkdPqwLC8tVaQ5rp48ZgIQDa5yH6Qhm8"> -->
		</div>
	</div>

	<!-- main block -->
	<div id="body">
		<!-- clear-fix 이제 안씀.-->
		<div class="content-boxa">
			<!--           <aside>

                <h1 id="aside-title">고객센터</h1>

                <nav id="customer-menu">
                    <h1>고객센터메뉴</h1>
                    <ul>
                        <li><a herf="">공지사항</a></li>
                        <li><a herf="">자주하는 질문</a></li>
                        <li><a herf="">수강문의</a></li>
                        <li><a herf="">이벤트</a></li>
                    </ul>
                </nav>

                <nav id="coworker">
                    <h1>협력업체</h1>
                    <ul>
                        <li><a href="">노트펍스</a></li>
                        <li><a href="">나무랩연구소</a></li>
                        <li><a href="">한빛미디어</a></li>
                    </ul>
                </nav>
            </aside> -->
			<jsp:include page="../inc/aside.jsp" />
			<main>
			<section>
				<h1>공지사항</h1>

				<section id="breadcrumb">
					<h3 class="d-none">경로</h3>
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</section>
				<section>
					<h1>공지사항 검색</h1>
					<form>
						<select>
							<option>제목</option>
							<option>작성자</option>
							<option>내용</option>
						</select> <input type="text"> <input type="submit" value="검색">
					</form>
				</section>

				<section id="notice">
					<h3 class="d-none">공지사항 목록</h3>
					<table>
						<thead>
							<tr>
								<td class="num">번호</td>
								<td class="title">제목</td>
								<td class="writer">작성자</td>
								<td class="date">작성일</td>
								<td class="hit">조회수</td>
							</tr>
						</thead>
						<tbody>
							<style>
.even {
	background: #e9e9e9;
}
</style>
							<c:forEach var="n" items="${list}" varStatus="v">
								
								<c:if test="${v.count%2==0}">
									<tr class="even">
								</c:if>
								
								<c:if test="${v.count%2!=0}">
									<tr>
								</c:if>
								<td class="num">${n.id}</td>
								<td class="title"><a href="detail?id=${n.id}">${n.title}</a></td>
								<td class="writer">${n.writerId}</td>
								<td class="date">${n.regDate}</td>
								<td class="hit">${n.hit}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<a href="reg">글쓰기</a>
					</div>
				</section>
			</section>
		<!-- 1,6,11,16,21,....-> page + total 레코드 수 -> 마지막 번호 
               
               page : 1     start ==> 1
               page : 13     start ==> 11
               page : 44     start ==> 41
               page : 39     start ==> 36 
               
               page : 1~5    :=> 1
               page : 6~10    :=> 6
               
               start =page - (page%5-1)
               -->
			<section id="page-index">
				<h1 style="font-size: 2rem" class="d-none">페이지 정보</h1>
				<div>
					<span class="color-highlight font-bold">1</span> / 1 pages
				</div>
			</section>

			<c:set var="page" value="${(empty param.p)? 1:param.p}"/>
			
			<c:set var="start" value="${page-((page-1)%5)}"/>
			<c:set var="last" value=""/>
			
			<section id="pager">
				<h1 class="d-none">페이지</h1>
				<div>
					<div><a href="list1?p=${(page<6)?1:(start-1)}">이전</a></div>
					<ul>
						<c:forEach begin="${ start}" end="${ start+4}" varStatus="s" var="n">
							<li><a href="list1?p=${n}">${n}</a></li>
						</c:forEach>
					</ul>
					<div><a href="list1?p=${start+5}">다음</a></div>
				</div>
			</section>
			</main>

			<!-- <div style="clear:left;">막내</div> .clear-fix사용-->
		</div>
	</div>

	<!--     <footer id="footer">
        <div>
             <h2>회사정보</h2>

    <div>
    <h3>소유권자 정보</h3>
    <dl>
        <dt>
            주소:
        </dt>
        <dd>
            서울특별시 마포구 토정로35길 11, 인우빌딩 5층 266호
        </dd>
        <dt>
            관리자메일:
        </dt>
        <dd>
            admin@newlecture.com
        </dd>
        <dt>
            사업자 등록번호:
        </dt>
        <dd>
            132-18-46763
        </dd>
        <dt>
            통신 판매업:
        </dt>
        <dd>
            신고제 2013-서울강동-0969 호
        </dd>
        <dt>
            상호:
        </dt>
        <dd>
            뉴렉처
        </dd>
        <dt>
            대표:
        </dt>
        <dd>
            박용우
        </dd>
        <dt>
            전화번호:
        </dt>
        <dd>
            070-4206-4084
        </dd>
    </dl>
</div>

<div>
    <h3>저작권정보</h3>
    <div>
        Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information
    </div>
</div> 
        </div>
    </footer> -->
	<jsp:include page="../inc/footer.jsp" />
</body>

</html>
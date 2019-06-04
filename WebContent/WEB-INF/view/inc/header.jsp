<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <header id="header">
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
                        <li><a href="../member/login">로그인</a></li>
                      <!--   //인크루드는 상대경로로 들어가면안돼 헤더는 경로와 상관없이 아무데나 붙을수도 있자나 
                      		인덱스 페이지에도 헤더가 있자나 페이지마다 경로가 달라지기 때문에 상대경로로 가면안돼  -->
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
    </header>
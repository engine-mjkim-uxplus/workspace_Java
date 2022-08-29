<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>인증처리 - 쿠키와 세션</title>
	<%@ include file="../common/easyui_common.jsp" %>
	<style type="text/css">
	a{text-decoration:none;}
	</style>
	<script type="text/javascript">
		function login(){
			const tb_id = $("#mem_id").val();
			const tb_pw = $("#mem_pw").val();			
			location.href="./login.pj?mem_id="+tb_id+"&mem_pw="+tb_pw;
		}
		function logout(){
			location.href="./logout.jsp";
		}
		// 순서지향적인, 절차지향적인 코딩 -> 모듈화 -> 비동기처럼 처리 하기(연습-await, async)
		function memberList(){
			alert("회원목록 호출 성공");
			//before
			//아래 코드는 클라이언트 측에 같이 다운로드가 완료된 상태에서 처리가 된다 - 결정이 되었다.
			//시점
			//jeasyUI datagrid에서도 get방식과 psot방식 지원함 - 차이점
			//url소석에 XXX.jsp가 오면 표준 서블릿인 HttpServlet이 관여하는 것이고
			//XXX.PJ로 요청하면 ActionSupport가 관여하는 것이다
			$("#dg_member").datagrid({
				//오라클서버에서 요청한 결과를 myBatis를 사용하면 자동으로 컬럼명이 대문자
				//단 List<XXXVO>형태라면 그땐 소문자 된다
				columns:[[
					{field: 'MEM_ID', title:'아이디', width: 100}
				   ,{field: 'MEM_NAME', title:'이름', width: 120}
				   ,{field: 'MEM_ADDRESS', title:'주소', width: 200}
				]]
				,method: "post"
			   	,url:"/member/memberList.pj" // 응답페이지는 JSON포맷의 파일이어야 한다(html이 아니라)
			});
			$("#d_member").show();
			//after

			$("#d_memberInsert").hide();
		}
		function memberInsert(){
			alert("회원등록 호출 성공");
			$("#d_member").hide();
			$("#d_memberInsert").show();
		}
	</script>
</head>
<body>
<script>
	//DOM트리가 다 그려 진거니? - yes
	//DON트리가 그려졌을 때 - 준비되었을 때
	$(document).ready(function(){
		$("#d_member").hide();
		$("#d_memberInsert").hide();
	});
</script>
    <div style="margin:20px 0;"></div>
    <div class="easyui-layout" style="width:1000px;height:500px;">
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'west',split:true" title="KH정보교육원" style="width:200px;">
			<div style="margin: 10px 0;"></div>
<%
	String s_name = (String)session.getAttribute("s_name");
	//s_name = "이순신";
	if(s_name == null){
%>  			
<!--################ 로그인 영역 시작 ################-->
			<div id="d_login" align="center">
			<div style="margin: 3px 0;"></div>
			<input id="mem_id" name="mem_id" class="easyui-textbox"/>
			<script type="text/javascript">
			$("#mem_id").textbox({
				iconCls:'icon-man',
				iconAlign: 'right',
				prompt:'아이디'
			});
			</script>
			<div style="margin: 3px 0;"></div>
			<input id="mem_pw" name="mem_pw" class="easyui-passwordbox"/>
			<script type="text/javascript">
			$("#mem_pw").passwordbox({
				iconAlign: 'right',
				prompt:'비밀번호'
			});
			</script>
			<div style="margin: 3px 0;"></div>
			<a id="btn_login" href="javascript:login()" class="easyui-linkbutton" data-options="iconCls:'icon-man'">
			로그인
			</a>			
			<a id="btn_member" href="javascript:memberShip()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">
			회원가입
			</a>			
			</div>
<!--################ 로그인 영역 끝 ################-->
<%
	}else{
%>      
<!--################ 로그아웃 영역 시작 ################-->      
			 <div id="d_logout" align="center">
			 	<div id="d_ok"><%=s_name%>님 환영합니다.</div>
			 	<div style="margin:3px 0"></div>
				<a id="btn_logout" href="javascript:logout()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">
				로그아웃
				</a>			
				<a id="btn_member" href="javascript:memberUpdate()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">
				정보수정
				</a>				 	
			 </div>
<!--################ 로그아웃 영역  끝 ################-->        
<%
	}// end of 로그아웃
%>
<!--################ 메뉴 영역 시작 ################-->
    <div style="margin:20px 0;"></div>
    <ul id="tre_gym" class="easyui-tree" style="margin:0 6px;">
        <li data-options="state:'closed'">
            <span>회원관리</span>
            <ul>
                <li>
                    <a href="javascript:memberList()">회원목록</a>
                </li>
                <li>
                   <a href="javascript:memberInsert()"> 회원등록</a>
                </li>
                <li>
                    회원삭제
                </li>
            </ul>
        </li>
        <li data-options="state:'closed'">
            <span>쪽지관리</span>
            <ul>
                <li>
                    <span>받은쪽지함</span>
                </li>
                <li>
                    <span>보낸쪽지함</span>
                </li>
            </ul>
        </li>
        <li data-options="state:'closed'">
            <span>게시판</span>
            <ul>
                <li>
                    <span>1:1</span>
                </li>
                <li>
                    <span>공지사항</span>
                </li>
                <li>
                    <span>Q&A</span>
                </li>
            </ul>
        </li>        
    </ul>
    </div>          
<!--################ 메뉴 영역  끝  ################-->
        <div data-options="region:'center',title:'TerrGYM System',iconCls:'icon-ok'">
        
        <!-- [[ 회원 관리 {회원목록, 회원등록, 회원삭제}]] -->	
        	<div id="d_member">
        	<div style="margin: 5px 0;"></div>
        	Home > 회원관리 > 회원목록
        	<hr>
        	<div style="margin: 20px 0;"></div>
        	<div id="dg_member"></div>
        	</div>
        	<div id="d_memberInsert">
        	<div style="margin: 5px 0;"></div>
        	Home > 회원관리 > 회원목록
        	<hr>
        	<div style="margin: 20px 0;"></div>
        	<div>회원등록화면 보여주기</div>
        	</div>
        <!-- [[ 쪽지 관리 {받은 쪽지함, 보낸 쪽지함} ]] -->
        </div>
    </div>
 
</body>
</html>
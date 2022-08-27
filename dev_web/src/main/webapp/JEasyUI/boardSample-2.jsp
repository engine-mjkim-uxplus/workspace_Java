<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data grid test</title>
<%@ include file="../common/easyui_common.jsp" %>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function(){
      alert("DOM 구성 완료"+$("#dg_board"));
      $('#dg_board').datagrid({
         title :'계층형 게시판 목록',
         url:'./board.json',
          columns:[[
              {field:'b_no', title:'글번호', width:100, align:'center'},
              {field:'b_title', title:'제목', width:200, align:'center'},
              {field:'b_writer', title:'작성자', width:100, align:'center'}
          ]],
         data: [
            {b_no:1, b_title:'연습입니다1', b_writer:'김유신'},
            {b_no:2, b_title:'연습입니다2', b_writer:'이순신'},
            {b_no:3, b_title:'연습입니다3', b_writer:'강감찬'}
         ]
      });
   })
</script>
<table id="dg_board"></table>
</body>
</html>

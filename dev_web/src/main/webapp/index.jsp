<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- cdn방식으로 하면 react 페이지를 jsp안에 넣을 수 있다 -->
    <script
      crossorigin
      src="https://unpkg.com/react@17/umd/react.development.js"
    ></script>
    <script
      crossorigin
      src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"
    ></script>
    <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
    <div id="root"></div>
    <!-- 이런식으로 한다면 리액트를 스프링에서 사용하는 것도 가능하다 -->
    <script type="text/babel">
      const root = document.getElementById("root");
      const msg = (
        <div
          className="box"
          children={[
            React.createElement("h1", null, "One"),
            React.createElement("h2", null, "Two"),
            React.createElement("h3", null, "Three"),
          ]}
        />
      );
      ReactDOM.render(msg, root);
    </script>
</body>
</html>
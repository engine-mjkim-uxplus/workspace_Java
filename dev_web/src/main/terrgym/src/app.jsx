import React from "react";
import "./app.css";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const name = "이순신";
  return (
    /* 리액트에서는 태그를 선언하여 사용함 - 멀티라인을 작성하려면 최외곽에 반드시 Fragment 태그
      jsp => java + html 쓸 수 있다
      리액트 UI안에는 html태그와 javascript혼용하여 쓸 수 있다. 반드시 return안에 작성. return안에 있는 것을 렌더링한다  
    */
    <>
      <h1>Hello! {name}</h1>
      <h1>Hello! {name}</h1>
      {
        // 자바스크립트 코드를 작성할 수 있다.
        name && <h1>Hi!!! {name}</h1>
      }
      {["🍭", "🍟", "🧀"].map(
        (item, index) => (console.log(index), (<h1>{item}</h1>))
      )}
    </>
  );
}

export default App;

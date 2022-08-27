import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import WorkoutApp from "./workoutApp";
import "@fortawesome/fontawesome-free/js/all.js";
import BootStrapApp from "./service/bootStrapApp";

const root = ReactDOM.createRoot(document.getElementById("root5"));
root.render(
  <React.StrictMode>
    <BootStrapApp />
    {/* <App/> */}
  </React.StrictMode>
);

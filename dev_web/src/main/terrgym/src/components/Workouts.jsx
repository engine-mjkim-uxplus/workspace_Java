import React from "react";
import { responsivePropType } from "react-bootstrap/esm/createUtilityClasses";
import Workout from "./Workout";
// 멀티라인을 처리한다
function Workouts(props) {
  console.log(props); // 객체로 받는 경우
  console.log(props.workouts); // 배열
  // workout에서 부터 이벤트 버블링/ workout -> workouts -> workoutApp
  const handleIncrement = (workout) => {
    props.onIncrement(workout);
  };
  // 바닐라스크립트에서 함수는 객체이다
  const handleDecrement = (workout) => {
    props.onDecrement(workout);
  };
  const handleDelete = (workout) => {
    props.onDelete(workout);
  };
  return (
    <div className="workouts">
      <ul>
        {props.workouts.map((workout) => (
          <Workout
            key={workout.id}
            onIncrement={handleIncrement}
            onDecrement={handleDecrement}
            onDelete={handleDelete}
            workout={workout}
          /> //
        ))}
      </ul>
    </div>
  );
}

export default Workouts;

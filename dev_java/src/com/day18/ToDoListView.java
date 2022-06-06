package com.day18;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
// 얘는 화면만 찍는 역할... VIEW제공
public class ToDoListView extends JFrame { 
	JLabel jlb_timer = new JLabel("현재시간 : ");
	Font f = new Font("궁서체",Font.BOLD,30); // (string, int, int) 폰트 설정
	public ToDoListView() {
		// 화면을 그리는 메소드를 디폴트 생성자에서 호출해 보기 - 표현력을 키운다
		initDisplay();
		TimeClient tc = new TimeClient(jlb_timer); // 타임클라이언트 실행, JLabel 물고 들어간다// 주소번지를 넘긴다
		tc.start(); // 타임클라이언트의 쓰레드 실행
	}
	public void initDisplay() {
		jlb_timer.setFont(f); // JLabel의 폰트 바꿔주기. setFont안에 폰트인스턴스 대입
		this.setTitle("ToDo Ver1.0");
		this.setLayout(new FlowLayout()); // default가 borderLayout인데 FlowLayout으로 하면 가운데가 디폴트로 offset으로 위치 설정
		this.add(jlb_timer); // JFrame에 JLabel 붙여 넣었다
		this.setSize(500, 300); // this = JFrame이다
		this.setVisible(true); // this는 JFrame이다 
	}

	public static void main(String[] args) {
		ToDoListView v = new ToDoListView();
	}

}
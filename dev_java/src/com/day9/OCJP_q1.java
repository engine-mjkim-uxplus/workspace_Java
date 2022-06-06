package com.day9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class OCJP_q1 {
	public static void main(String[] args) {
	new GameStart();
	}
}

class GameStart extends JFrame {
	JButton btn;
	JTextField answer; // 사용자 입력 값
	JPanel panel; 
	JLabel label; // 질문 레이블
	int chance; // 기회
	int num; // 0~9까지의 난수 저장
	GameStart(){
		super("숫자 맞추기 게임"); // 부모 생성자는 첫줄에 쓸 것. 밑에쓰면 컴파일 에러
		this.num = (int)(Math.random()*10); 
		this.chance = 5;
		System.out.println("게임을 시작합니다. 결과는 Console창에서 확인 해 주세요");
		setDisplay();
		btn_mapping();
	}
	// 화면설정 메서드 
	public void setDisplay(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(100, 100, 150, 40); //	
		getContentPane().add(panel); 
		
		// JLabel로 질문창
		JLabel question = new JLabel("Enter a number between 0 and 9");
		question.setSize(200,30);
		question.setLocation(55,5);
		add(question);
		//question.setBounds(150, 150, 100, 30);
		
		// 입력창 생성
		answer = new JTextField();
		answer.setSize(40,20);
		answer.setLocation(120, 50);
		add(answer);
		
		// 버튼 생성
		btn = new JButton("입력");
		btn.setBounds(90, 180, 110, 30);
		getContentPane().add(btn);
		
		// 레이블 생성
		label = new JLabel();
		label.setBounds(100,220,150,30);
		label.setText("기회 " + chance + "번 남음");
		getContentPane().add(label); // 프레임에 레이블 추가
		
		getContentPane().setLayout(null); // 콤포넌트의 크기와 위치를 일일이 다 지정 해 줘야한다. 즉 절대위치 사용!!
		setLocation(700,300); // 프레임의 (x,y)위치 조정
		setSize(300,300); // 프레임 크기 지정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JVM에서 완전히 지움. 메모리 관리르 위해 씀. 정상 종료된다.
		setVisible(true);
	} // end of setDisplay
	// 버튼의 이벤트 처리
	public void btn_mapping(){
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { // 파라미터 arg0으로 입력해야 입력값 받음
				try {
				int input = Integer.parseInt(answer.getText()); // 입력값 int로 변환하여 저장
				if(chance <= 0) {
					System.out.println("틀렸습니다. 기회가 없어서 프로그램을 종료합니다");
					System.exit(0);
				}else if(input == num) {
					System.out.print("정답입니다.\n프로그램을 종료합니다.");
					System.exit(0);
				}else if(input > num) {
					--chance;
					if(chance <= 0) {
						System.out.print("틀렸습니다. 정답은 " + num + "입니다. \n프로그램을 종료합니다.");
						
						System.exit(0);
						}
					label.setText("기회 " + chance + "번 남음");
					System.out.println("틀렸습니다. 더 작은 수를 입력하세요.");
				}else if(input< num) {
					--chance;
					if(chance <= 0) {
						System.out.println("틀렸습니다. 정답은 " + num + "입니다. \n프로그램을 종료합니다.");
						System.exit(0);
						}
					label.setText("기회 " + chance + "번 남음");
					System.out.println("틀렸습니다. 더 큰 수를 입력하세요");
					}
				}catch(NumberFormatException n) { // 문자를 입력했을 때 발생하는 예외 처리(NumberFormatException은 숫자 형식 오류)
					System.out.println("숫자만 입력해 주세요");
				}
			} // end of actionPerforemd
		}); // end of new ActionListner()
	} // end of initDisplay
} // end of GameStart class
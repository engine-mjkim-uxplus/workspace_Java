package com.day18;

import java.util.StringTokenizer;

public class MessageParser {

	public static void main(String[] args) {
		String msg = "100#tomato#banna#오늘 스터디 할 까?"; // tomato님이 입장하였습니다
		StringTokenizer st = new StringTokenizer(msg, "#"); // 지정된 토큰값을 기준으로 우리가 원하는 값을 자를 수 있다.
//		String protocol =st.nextToken();
//		String nickName = st.nextToken();
//		String studyName = st.nextToken();
//		String mssage = st.nextToken();
//		System.out.println(protocol);
//		System.out.println(nickName);
//		System.out.println(studyName);
//		System.out.println(mssage);
		// 위의 문장 iterator 쓰는 것처럼 줄여서 씀
//		while(st.hasMoreTokens() ) {
//			String imsi = st.nextToken();
//			System.out.println(imsi);
//			int i = st.countTokens();
//			System.out.println(i);
//		}
		String a = st.nextToken();
		System.out.println(a);
		String b = st.nextToken();
		System.out.println(b);
		int i = st.countTokens();
		System.out.println(i);
		
	}

}

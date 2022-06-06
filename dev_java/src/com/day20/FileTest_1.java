package com.day20;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest_1 {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(".\\src\\com\\day20\\log.txt");
			fw.write("97");
			fw.write("65");
		} catch (FileNotFoundException fe) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} catch (Exception e) {
			// 예외가 발생 했을 때 에러상황을 기록해 두는 stack메모리 영역에 있는 에러메시지를 출력해준다
			// print메소드 안에서 사용하지 말것
			e.printStackTrace();
		}finally{
			try {
				// 입출력의 경우 악의적인 목적으로 접근하여 외부에 노출 될 수 있으므로 
				// 사용한 객체는 반드시 닫아야하는 컨벤션이 있다
				fw.close();
			} catch(Exception e2) {
				
			} // end of finally
		}// end of main
		
	} // end of fileTest1

}

package quiz;

import javax.swing.JOptionPane;


public class Quiz2 {
 
	// 사용자로부터 50개의 숫자를 입력받고 -1을 입력하면 프로그램 종료후 각 배열의 숫자를 출력하는 프로그램
	
    public static void main(String[] args) {
    	int[] tmp = new int[50];
    	
    	for(int i=0; i<tmp.length;i++) {
    		String input = JOptionPane.showInputDialog("1~50사이의 숫자를 입력하세요");
    		int number = Integer.valueOf(input);
    		if(number != -1) {
    			tmp[i] = number;
    		System.out.println("input = " + number);
    		} else{
    			if(number == -1) {
    			break;
    			}	
    		}
    	}   		
    	for(int i = 0; i < tmp.length;i++) {
    		System.out.println("tmp[" + i + "] = " + tmp[i]);
    			
    	}
    	
    	
    }
 
}
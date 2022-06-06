package com.day14;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog_1 extends JDialog {
	String title= null;
	
	
	// 디폴트 생성자는 생략가능하다
	// 언제? 인스턴스화를 했을 때 - 어디서?
	// Dialog_1 dialog = null;
	// dialog = new Dialog_1();
	// Dialog_1 dialog = new Dialog_1();
   public void initDisplay() {
       this.setTitle(title);
       this.setSize(300, 400);
       this.setVisible(true);
   }

public void set(String title) {
	this.title = title;
}

}



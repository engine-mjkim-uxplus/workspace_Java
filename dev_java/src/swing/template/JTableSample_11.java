package swing.template;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableSample_11 implements ActionListener {

	JFrame jf = new JFrame();

	String cols[] = { "HTML", "자바", "총점" };

	String data[][] = new String[3][3];

	DefaultTableModel dtm = new DefaultTableModel(data, cols);

	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// 속지를 그리는데 사용됨 - 이 속지에 처리 버튼과 종료 버튼을 추가해 보자
	JPanel jp_north = new JPanel();
	JButton jbtn_add = new JButton("성적처리");
	JButton jbtn_exit = new JButton("종료");

	public void initDisplay() {
		jbtn_add.addActionListener(this);
		jp_north.setBackground(Color.orange);
		jp_north.add(jbtn_add);
		jp_north.add(jbtn_exit);
		jf.add("North", jp_north);
		jf.add("Center", jsp);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		JTableSample_11 jtb = new JTableSample_11();
		jtb.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_add) {
			int datas[][] = { 
			{ 85, 76, 0}, 
			{ 100, 100, 0},
			{ 100, 90, 0} 
			};

			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j< data[i].length; j++) {
					dtm.setValueAt(datas[i][j] , i ,  j);
				}
			}

		}
	}

}

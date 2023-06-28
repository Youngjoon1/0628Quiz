package quiz;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends Thread{
	private JLabel label;
	private JFrame frame;
	private boolean flag;
	public MyFrame() {
		frame = new JFrame("제목");
		Container c = frame.getContentPane();
		
		label = new JLabel("test gui");
		c.add( label );
		label.setFont( new Font(null, 0, 32) );
		label.setHorizontalAlignment( JLabel.CENTER );
		
		frame.setLocation(1000 , 200);
		frame.setPreferredSize( new Dimension(500,200) );
		frame.pack(); //프레임 사이즈 설정
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	public void setFlag(boolean flag) { this.flag = flag; }
	public void setLable(String time) {
		label.setText( time );
	}
	public void run() {
		frame.setVisible( true );
		flag = true;
		SimpleDateFormat date = 
				new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		while( flag ) {
			label.setText( date.format(new Date() ) );
		}
	}
}




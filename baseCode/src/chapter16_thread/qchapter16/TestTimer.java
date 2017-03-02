package chapter16_thread.qchapter16;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestTimer{
	public static void main(String args[]){
		JFrame jf = new JFrame("Clock");
		JLabel clock = new JLabel("Clock");
		clock.setHorizontalAlignment(JLabel.CENTER);
		jf.add(clock,"Center");
		jf.setSize(140,80);
		jf.setLocation(500,300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		Timer t = new Timer();
		TimerTask tt = new MyTask(clock);	
		t.schedule(tt,0,1000);
	}		
}

class MyTask extends TimerTask{
	private JLabel clock;
	public MyTask(JLabel clock){
		this.clock = clock;	
	}
	public void run(){
		clock.setText(this.getTime());
	}
	public String getTime(){
		Calendar c = new GregorianCalendar();
		String time = 	c.get(Calendar.YEAR) + "-" +
					(c.get(Calendar.MONTH) + 1) + "-" +
					c.get(Calendar.DATE)  + "  " ;
		int h = c.get(Calendar.HOUR_OF_DAY);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		String ph = h<10 ? "0":"";
		String pm = m<10 ? "0":"";
		String ps = s<10 ? "0":"";		
		time += ph + h + ":" + pm + m + ":" + ps + s; 
		return time;
	}
}
package chapter16_thread.hchapter16;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

public class DigitalClock{
	public static void main(String[] args){
		JFrame jf = new JFrame("Clock");
		JLabel clock = new JLabel("Clock");
		clock.setHorizontalAlignment(JLabel.CENTER);
		jf.add(clock,"Center");
		jf.setSize(140,80);
		jf.setLocation(500,300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		Thread t = new MyThread(clock);
		t.start();
	}	
}

class MyThread extends Thread{
	private JLabel clock;
	public MyThread(JLabel clock){
		this.clock = clock;
	}
	public void run(){
		while(true){
			clock.setText(this.getTime());
			try{
				Thread.sleep(1000); //this.sleep(1000);	
			}catch(InterruptedException e){
				e.printStackTrace();	
			}	
		}	
	}
	public String getTime(){
		Calendar c = new GregorianCalendar();
		String time = c.get(Calendar.YEAR) + "-" +
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
package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timerDao {
	public static void main(String[] args) {
		gettime();
	}
	public static String gettime() {
		//��õ�ǰ���ڷ����ַ���
		
		
		Date date = new Date();
		 SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		String flag=ft.format(date);
	       System.out.println(flag);
	       
	       
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package mvn;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Adacin {
	public static void main(String[] args) throws IOException, InterruptedException {
		LibGlobal l =  new LibGlobal();
		l.getdriver("chrome");
		l.geturl("http://adactinhotelapp.com/");
		
		WebElement txt = l.findElementByid("username");
		l.inserttextbox(txt, l.getExcel("Sheet2",0, 0));
		WebElement pass = l.findElementByid("password");
		l.inserttextbox(pass, l.getExcel("Sheet2", 1, 0));
		WebElement clk = l.findElementByid("login");
		l.btnclk(clk);
		WebElement loc = l.findElementByid("location");
		l.select(loc, l.getExcel("Sheet2", 2, 0));
		WebElement hotal = l.findElementByid("hotels");
		l.select(hotal, l.getExcel("Sheet2", 3, 0));
		WebElement room = l.findElementByid("room_type");
		l.select(room, l.getExcel("Sheet2", 4, 0));
		WebElement roomnos = l.findElementByid("room_nos");
		l.select(roomnos, l.getExcel("Sheet2", 5, 0));
		WebElement datein = l.findElementByid("datepick_in");
		l.inserttextbox(datein, "05/05/2022");
		WebElement dateout = l.findElementByid("datepick_out");
		l.inserttextbox(dateout, "06/05/2022");
		WebElement room1 = l.findElementByid("adult_room");
		l.select(room1, l.getExcel("Sheet2", 8, 0));
		WebElement room2 = l.findElementByid("child_room");
		l.select(room2, l.getExcel("Sheet2", 9, 0));
		WebElement submit = l.findElementByid("Submit");
		l.btnclk(submit);
		WebElement radiobtn = l.findElementByid("radiobutton_0");
		l.btnclk(radiobtn);
		WebElement contin = l.findElementByid("continue");
		l.btnclk(contin);
		WebElement frst = l.findElementByid("first_name");
		l.inserttextbox(frst, l.getExcel("Sheet2", 10, 0));
		WebElement last = l.findElementByid("last_name");
		l.inserttextbox(last, l.getExcel("Sheet2", 11, 0));
		WebElement address = l.findElementByid("address");
		l.inserttextbox(address, l.getExcel("Sheet2", 12, 0));
		WebElement cc = l.findElementByid("cc_num");
		l.inserttextbox(cc, l.getExcel("Sheet2", 13, 0));
		WebElement type = l.findElementByid("cc_type");
		l.select(type, l.getExcel("Sheet2", 14, 0));
		WebElement cc_exp_month = l.findElementByid("cc_exp_month");
		l.select(cc_exp_month, l.getExcel("Sheet2", 15, 0));
		WebElement cc_exp_year = l.findElementByid("cc_exp_year");
		l.select(cc_exp_year, l.getExcel("Sheet2", 16, 0));
		WebElement cc_cvv = l.findElementByid("cc_cvv");
		l.inserttextbox(cc_cvv, l.getExcel("Sheet2", 17, 0));
		WebElement book_now = l.findElementByid("book_now");
		l.btnclk(book_now);
		Thread.sleep(5000);
		WebElement order_no = l.findElementByid("order_no");
		String getvalue = l.getvalue(order_no);
        l.writeexcel("Sheet2", 5, 5, getvalue);		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

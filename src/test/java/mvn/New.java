package mvn;

import org.openqa.selenium.WebElement;

public class New {
	public static void main(String[] args) throws InterruptedException {
		LibGlobal l = new LibGlobal();
		l.getdriver("chrome");
		l.geturl("http://www.flipkart.com/");
		l.waitsss();
		WebElement clk = l.findElementbyxpath("/html/body/div[2]/div/div/button");
		l.btnclk(clk);
		WebElement srch = l.findElementbyxpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");
		l.inserttextbox(srch, "mobiles");
		WebElement srchbtn = l.findElementbyxpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button");
		l.btnclk(srchbtn);
		WebElement phn = l.findElementbyxpath("//div[text()='SAMSUNG Galaxy F12 (Sea Green, 64 GB)']");
		l.btnclk(phn);
		l.singlewindow();
		WebElement cart = l.findElementbyxpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button");
		l.btnclk(cart);
		l.multipleWindow();
		WebElement phnn = l.findElementbyxpath("//div[text()='realme C11 2021 (Cool Grey, 32 GB)']");
		l.btnclk(phnn);
		l.singlewindow();
		WebElement cart1 = l.findElementbyxpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button");
		l.btnclk(cart1);
	}

}

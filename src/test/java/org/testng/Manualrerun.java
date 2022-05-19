package org.testng;

public class Manualrerun {
	int min=0;
	int max=5;
	public boolean retry() {
		if(min<max) {
			min++;
			return true;
		}
		return false;
	}

}

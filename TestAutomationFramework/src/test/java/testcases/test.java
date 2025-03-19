package testcases;

import org.checkerframework.checker.units.qual.cd;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "Welcome To Automation Framework";
	    
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                upperCaseCount++;
            } else if (c >= 'a' && c <= 'z') {
                lowerCaseCount++;
            }
        }
        
        System.out.println("Uppercase characters: " + upperCaseCount);
        System.out.println("Lowercase characters: " + lowerCaseCount);
		

	}

}

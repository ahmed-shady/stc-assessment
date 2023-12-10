package com.aboshady.stc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StcApplicationTests {

	private final static char OPEN_BRACKET = '(';
	private final static char CLOSE_BRACKET = ')';
	@Test
	void contextLoads() {
		System.out.println("####");
		System.out.println(reverse("abcdefghijk"));
		System.out.println(reverse("abc(abc)abc"));
		System.out.println(reverse("(a)(bc)(abc)abc"));
		System.out.println(reverse("(abcedefghijk)"));
	}

	String reverse(String str){
		int currentIndex = 0;

		StringBuilder stringBuilder = new StringBuilder(str.length());
		while(currentIndex < str.length()){
			char currentChar = str.charAt(currentIndex);
			if (currentChar == OPEN_BRACKET) {
				int indexOfClosedBracket = str.indexOf(CLOSE_BRACKET, currentIndex);
				for (int i = indexOfClosedBracket - 1; i > currentIndex; i--) {
					stringBuilder.append(str.charAt(i));
				}
				currentIndex = indexOfClosedBracket + 1;
			}else{
				stringBuilder.append(currentChar);
				currentIndex++;
			}
		}

		return  stringBuilder.toString();
	}

}

/*
SELECT U.user_id, U.username, TD.training_id, TD.training_date, count(*)
FROM User U
INNER JOIN Training_details TD
ON U.user_id = TD.user_id
GROUP BY U.user_id, TD.training_id, TD.training_date
having count(*) > 1;
 */

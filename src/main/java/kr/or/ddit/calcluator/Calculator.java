package kr.or.ddit.calcluator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//문자열 계산기
//String text = "1,5,10,20"; --> 
//calculate(text) --> text안의 합 = 36
//1. 문자열 안에 숫자를 구분짓는 구분자를 제거한 남은 숫자들을 전부 더한 값을 구한다.
//2. 구분자는 두가지(',' 또는 ':') -> 어느것이 들어와도 남은 숫자들을 전부 더한 값을 구한다.
//3. 문자열이 공백이거나, null이면 0을 return.
//4. 문자열 시작이 '//' 과 '\n' 일때 커스텀 구분자를 지정할 수 있다.
//	"//;\n1;5;10;20" --> 36
//5. 숫자 구분자는 커스텀과 구분자와, 기본 구분자 두가지를 섞어 사용할 수 있다.
//	"//;\n1,5;10:20" --> 36
public class Calculator {
	private String regex = ":|,";	
	
	public int calculate(String text) {
		if(isEmptyOrNull(text)) 
			return 0;
		
		if(text.startsWith("//")) {
			text = text.split("//")[1];
			String seperator = text.split("\n")[0];
			regex += "|"+"["+seperator+"]";
			text = text.split("\n")[1];
		}
		
		return calcSum(text);
	}

	private boolean isEmptyOrNull(String text) {
		return text==null || text.isEmpty();
	}
	
	public int calculate2(String text) {
		if(isEmptyOrNull(text)) 
			return 0;
		
	
		text = getTexts(text);
		
		return calcSum(text);
	}

	private String getTexts(String text) {
		if(text.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			String customSeperator = null;
			if(m.find()) {
				customSeperator = m.group(1);
				text =  m.group(2);
			}
			regex += "|"+"["+customSeperator+"]";
		}
		return text;
	}

	private int calcSum(String text) {
		int result = 0;
		String[] nums = text.split(regex);
		for(String num : nums) {
			result += Integer.parseInt(num);
		}
		return result;
	}
}

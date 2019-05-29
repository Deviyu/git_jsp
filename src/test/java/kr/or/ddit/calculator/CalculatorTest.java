package kr.or.ddit.calculator;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DebugGraphics;

import kr.or.ddit.calcluator.Calculator;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CalculatorTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CalculatorTest.class);
	
	Calculator calc;
	@Before
	public void setup() {
		calc = new Calculator();
	}
	
	@Test
	public void emptyTest() {
		/***Given***/
		String text = "";
		/***When***/
		int result = calc.calculate(text);
		/***Then***/
		assertEquals(0, result);
	}

	@Test
	public void nullTest() {
		/***Given***/
		String text = null;
		/***When***/
		int result = calc.calculate(text);
		/***Then***/
		assertEquals(0, result);
	}
	
	@Test
	public void defaultSeperatorTest() {
		/***Given***/
		String text = "1,5,10,20";
		String text2 = "1,5:10:20";
		/***When***/
		int result = calc.calculate(text);
		int result2 = calc.calculate(text2);
		/***Then***/
		assertEquals(36, result);
		assertEquals(36, result2);
	}
	
	@Test
	public void customSeperatorTest() {
		/***Given***/
		String text = "//;\n1;5;10;20";
		/***When***/
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		String customSeperator = null;
		String textNums = null;
		if(m.find()) {
			logger.debug("{}",m.groupCount());
			customSeperator = m.group(1);
			textNums = m.group(2);
		}
		int result = calc.calculate(text);
		int result2 = calc.calculate2(text);
		/***Then***/
		logger.debug(text);
		logger.debug(customSeperator);
		logger.debug(textNums);
		assertEquals(36, result);
		assertEquals(36, result2);
	}
	
	@Test
	public void mixedSeperatorTest() {
		/***Given***/
		String text = "//-\n1-5:10,20";
		/***When***/
		int result = calc.calculate(text);
		int result2 = calc.calculate2(text);
		/***Then***/
		assertEquals(36, result);
		assertEquals(36, result2);

	}
}

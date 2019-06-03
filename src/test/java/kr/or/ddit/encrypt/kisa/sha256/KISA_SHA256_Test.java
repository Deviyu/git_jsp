package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256.SHA256_INFO;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256_Test {
	private static final Logger logger = LoggerFactory
			.getLogger(KISA_SHA256_Test.class);
	/**
	 * Method : SHA256Test
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-03 처음 생성
	 * Method 설명 : 복호화가 불가능한 hash 알고리즘 테스트
	 */
	@Test
	public void sha256Test() {
		/***Given***/
		String plainText = "java201902";
		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		/***Then***/
		logger.debug("plainText : {}", plainText);
		logger.debug("encryptText : {}",encryptText);
		
	}

}

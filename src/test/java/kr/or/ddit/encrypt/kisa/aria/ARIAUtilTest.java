package kr.or.ddit.encrypt.kisa.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.AfterClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARIAUtilTest {
	private static final Logger logger = LoggerFactory
			.getLogger(ARIAUtilTest.class);
	
	@Test
	public void encryptTest() throws InvalidKeyException, UnsupportedEncodingException {
		/***Given***/
		String plainText = "java201902";
		
		/***When***/
		String encryptText = ARIAUtil.ariaEncrypt(plainText);
		String decryptText = ARIAUtil.ariaDecrypt(encryptText);
		/***Then***/
		//DA857C0F59AE63A90B89E1C111DD5274
		//F468215DE8E7119AEB9ADFCF0C894503
		assertEquals(plainText, decryptText);
		logger.debug("encryptText : {}",encryptText);
		logger.debug("decryptText : {}",decryptText);
	}

}

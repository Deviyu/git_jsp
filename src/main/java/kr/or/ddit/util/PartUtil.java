package kr.or.ddit.util;

public class PartUtil {

	/**
	 * Method : getFileName
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-03 처음 생성
	 * @param contentDisposition
	 * @return String filename
	 * Method 설명 : content-disposition 헤더에서 파일명을 반환하는 메서드
	 */
	public static String getFileName(String contentDisposition) {
		if(contentDisposition!=null) {
			String[] headers = contentDisposition.split("; ");
			for(String header : headers) {
				if(header.startsWith("filename=")){
					return header.substring(header.indexOf("\"")+1, header.lastIndexOf("\""));
				}
			}
		}
		return "";
	}
	
	/**
	 * Method : getExtention
	 * 작성자 : jakeh
	 * 변경이력 : 2019-06-03 처음 생성
	 * @param contentDispositon
	 * @return
	 * Method 설명 : content-disposition 헤더에서 파일의 확장자를 반환하는 메서드
	 */
	public static String getExtention(String fileName) {
		if(fileName!=null && fileName.contains(".")) {
			return fileName.substring(fileName.lastIndexOf("."));
		}
		return "";
	}
	
}

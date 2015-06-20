package samples.http.common;

/**
 * Created by izeye on 15. 6. 20..
 */
public interface HttpConstants {
	
	String HTTP_VERSION_1_1 = "HTTP/1.1";

	String HEADER_CONNECTION = "Connection";
	String CONNECTION_CLOSE = "Close";

	String HEADER_HOST = "Host";
	
	String HEADER_TRANSFER_ENCODING = "Transfer-Encoding";
	String TRANSFER_ENCODING_CHUNKED = "chunked";

	byte CR = '\r';
	byte LF = '\n';
	String NEW_LINE = "\r\n";
	int NEW_LINE_LENGTH = NEW_LINE.length();

	String DELIMITER_COLON = ":";
	String DELIMITER_SPACE = " ";
	char DELIMITER_EQUALS = '=';
	char DELIMITER_AMPERSAND = '&';
	
}

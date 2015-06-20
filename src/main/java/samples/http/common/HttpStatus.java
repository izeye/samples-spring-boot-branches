package samples.http.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by izeye on 15. 6. 20..
 */
public enum HttpStatus {
	
	OK(200);
	
	public static final Map<Integer, HttpStatus> valueByCode = new HashMap<>();
	static {
		for (HttpStatus value : values()) {
			valueByCode.put(value.getCode(), value);
		}
	}
	
	private final int code;
	
	private HttpStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static HttpStatus valueOf(int code) {
		return valueByCode.get(code);
	}
	
}

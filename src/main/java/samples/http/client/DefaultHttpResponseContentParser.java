package samples.http.client;

import samples.http.common.HttpResponse;
import samples.http.common.HttpResponseParsingException;
import samples.http.util.ArrayUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static samples.http.common.HttpConstants.*;

/**
 * Created by izeye on 15. 6. 20..
 */
public class DefaultHttpResponseContentParser implements HttpResponseContentParser {
	
	@Override
	public HttpResponse parse(byte[] bytes) {
		int index = ArrayUtils.indexOf(bytes, CR);
		if (bytes[index + 1] != LF) {
			throw new HttpResponseParsingException();
		}
		String statusLine = new String(ArrayUtils.subarray(bytes, 0, index));
		bytes = ArrayUtils.subarray(bytes, index + NEW_LINE_LENGTH, bytes.length);
		
		Map<String, String> headers = new HashMap<>();
		while (true) {
			index = ArrayUtils.indexOf(bytes, CR);
			if (bytes[index + 1] != LF) {
				throw new HttpResponseParsingException();
			}
			String header = new String(ArrayUtils.subarray(bytes, 0, index));
			bytes = ArrayUtils.subarray(bytes, index + NEW_LINE_LENGTH, bytes.length);
			if (header.isEmpty()) {
				break;
			}
			String[] headerNameAndValue = header.split(DELIMITER_COLON);
			headers.put(headerNameAndValue[0], headerNameAndValue[1].trim());
		}

		String transferEncoding = headers.get(HEADER_TRANSFER_ENCODING);
		String body = transferEncoding != null
				&& transferEncoding.equals(TRANSFER_ENCODING_CHUNKED) ?
				parseChunked(bytes) : new String(bytes);
		return new HttpResponse(statusLine, headers, body);
	}
	
	private String parseChunked(byte[] bytes) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int cursor = 0;
		while (true) {
			int chunkSizeStartIndex = cursor;
			int chunkSizeEndIndex = ArrayUtils.indexOf(bytes, CR, cursor);
			if (bytes[chunkSizeEndIndex + 1] != LF) {
				throw new HttpResponseParsingException();
			}
			int chunkSize = Integer.parseInt(new String(ArrayUtils.subarray(
					bytes, chunkSizeStartIndex, chunkSizeEndIndex)), 16);
			if (chunkSize == 0) {
				return baos.toString();
			}
			cursor = chunkSizeEndIndex + NEW_LINE_LENGTH;
			byte[] chunk = ArrayUtils.subarray(bytes, cursor, cursor + chunkSize);
			try {
				baos.write(chunk);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			cursor = cursor + chunkSize + NEW_LINE_LENGTH;
		}
	}
	
}

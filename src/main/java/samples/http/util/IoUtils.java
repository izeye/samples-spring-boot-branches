package samples.http.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by izeye on 15. 6. 20..
 */
public abstract class IoUtils {

	private static final int BUFFER_SIZE = 1024;
	
	public static byte[] toByteArray(InputStream is) {
		BufferedInputStream bis = new BufferedInputStream(is);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int readBytes;
		try {
			while ((readBytes = bis.read(buffer)) > 0) {
				baos.write(buffer, 0, readBytes);
			}
			return baos.toByteArray();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}

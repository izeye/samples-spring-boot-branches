package samples.http.util;

/**
 * Created by izeye on 15. 6. 20..
 */
public abstract class ArrayUtils {
	
	private static final int NOT_FOUND = -1;
	
	public static int indexOf(byte[] bytes, byte value) {
		return indexOf(bytes, value, 0);
	}

	public static int indexOf(byte[] bytes, byte value, int startIndex) {
		for (int i = startIndex; i < bytes.length; i++) {
			if (bytes[i] == value) {
				return i;
			}
		}
		return NOT_FOUND;
	}
	
	public static byte[] subarray(byte[] bytes, int startIndexInclusive, int endIndexExclusive) {
		int length = endIndexExclusive - startIndexInclusive;
		byte[] subarray = new byte[length];
		System.arraycopy(bytes, startIndexInclusive, subarray, 0, length);
		return subarray;
	}
	
}

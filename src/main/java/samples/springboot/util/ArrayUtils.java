package samples.springboot.util;

/**
 * Created by izeye on 15. 4. 5..
 */
public class ArrayUtils {
	
	public static int[][] copy(int[][] src) {
		int[][] dst = new int[src.length][];
		for (int i = 0; i < src.length; i++) {
			dst[i] = src[i].clone();
		}
		return dst;
	}
	
}

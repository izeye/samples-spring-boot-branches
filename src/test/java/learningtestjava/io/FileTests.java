package learningtestjava.io;

import org.junit.Test;

import java.io.File;

/**
 * Created by izeye on 15. 3. 24..
 */
public class FileTests {

	@Test
	public void test() {
		File file = new File(".");
		System.out.println(file.getTotalSpace());
		System.out.println(file.getUsableSpace());
		System.out.println(file.getFreeSpace());
	}

}

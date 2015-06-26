package learningtest.org.junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;

/**
 * Created by izeye on 15. 6. 26..
 */
public class TemporaryFolderTests {
	
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();
	
	@Test
	public void test() throws IOException {
		System.out.println(this.temp.newFile());
	}
	
}

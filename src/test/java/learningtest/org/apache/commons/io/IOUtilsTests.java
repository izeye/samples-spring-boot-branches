package learningtest.org.apache.commons.io;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 3. 26..
 */
public class IOUtilsTests {

	@Test
	public void readLines() throws IOException {
		String resourceLocation = "classpath:data/keywords.txt";
		File file = ResourceUtils.getFile(resourceLocation);
		FileReader fr = new FileReader(file);

		List<String> lines = IOUtils.readLines(fr);
		
		// NOTE:
		// The last empty line has been ignored.
		assertThat(lines.size(), is(2));
		
		// NOTE:
		// The trailing space is preserved.
		assertThat(lines.get(0), is("Hello, "));
		assertThat(lines.get(1), is("world!"));
	}

}

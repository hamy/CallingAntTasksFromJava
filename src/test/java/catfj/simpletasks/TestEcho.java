/**
 * 
 */
package catfj.simpletasks;

import org.apache.tools.ant.taskdefs.Echo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;

import catfj.AbstractCatfjTestCase;

/**
 * Test case for the Ant "echo" task.
 */
public class TestEcho extends AbstractCatfjTestCase {

	private Echo echo;

	@Before
	public void setUp() {
		String mn = debugEntering("setUp");
		echo = new Echo();
		debug(mn, "echo created: ", echo);
		debugLeaving(mn);
	}

	@Test
	public void testSimpleEcho() throws Exception {
		String mn = debugEntering("testSimpleEcho");
		echo.setMessage("Hello world (from " + mn + ")");
		echo.execute();
		debugLeaving(mn);
	}

	@Test
	public void testEchoToFile() throws Exception {
		String mn = debugEntering("testEchoToFile");
		String msg = "Hello world (from " + mn + ")";
		echo.setMessage(msg);
		File file = File.createTempFile(mn, ".txt");
		debug(mn, "file: ", file);
		echo.setFile(file);
		echo.execute();
		assertTrue(file.exists());
		assertTrue(file.isFile());
		assertTrue(file.length() > 0);
		StringBuilder sb = new StringBuilder();
		FileInputStream fis = new FileInputStream(file);
		while (true) {
			int ch = fis.read();
			if (ch < 0) {
				break;
			}
			sb.append((char) ch);
		}
		fis.close();
		String msg2 = sb.toString().trim();
		debug(mn, "expected file contents: ", msg);
		debug(mn, "actual file contents (trimmed): ", msg2);
		assertEquals(msg, msg2);
		debugLeaving(mn);
	}
}

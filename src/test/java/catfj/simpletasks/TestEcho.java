/**
 * 
 */
package catfj.simpletasks;

import org.apache.tools.ant.taskdefs.Echo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import catfj.AbstractCatfjTestCase;

/**
 * This is the base class for test cases of this projects. It provides logging.
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
		echo.setMessage("Hello world (from " + mn + ")");
		File file = File.createTempFile(mn, ".txt");
		debug(mn,"file: ",file);
		echo.setFile(file);
		echo.execute();
		assertTrue(file.exists());
		assertTrue(file.isFile());
		assertTrue(file.length()>0);
		debugLeaving(mn);
	}
}

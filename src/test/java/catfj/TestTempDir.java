/**
 * 
 */
package catfj;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the base class for test cases of this projects. It provides logging.
 */
public class TestTempDir extends AbstractCatfjTestCase {

	private TempDir tempDir;
	private File baseDir;

	@Before
	public void setUp() throws Exception {
		tempDir = new TempDir();
		baseDir = tempDir.getBaseDir();
	}

	@Test
	public void testSetUp() throws Exception {
		String mn = debugEntering("testSetUp");
		assertNotNull(tempDir);
		assertNotNull(baseDir);
		assertTrue(baseDir.exists());
		assertTrue(baseDir.isDirectory());
		debugLeaving(mn);
	}
}

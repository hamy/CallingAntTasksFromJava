/**
 * 
 */
package catfj;

import org.apache.tools.ant.Main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/**
 * This is the base class for test cases of this projects. It provides logging.
 */
public class TestAntVersion extends AbstractCatfjTestCase {

	@Test
	public void testAntVersion() throws Exception {
		String mn = debugEntering("testAntVersion");
		InputStream is = getClass().getResourceAsStream(
				"TestAntVersion.properties");
		assertNotNull("input stream resource must not be null.", is);
		Properties props = new Properties();
		props.load(is);
		is.close();
		debug(mn, "properties read: ", props);
		String expected = props.getProperty("expectedAntVersion");
		debug(mn, "expected Ant version: ", expected);
		String actual = Main.getAntVersion();
		debug(mn, "actual Ant version: ", actual);
		assertTrue("version mismatch: ", actual.contains(expected));
		debugLeaving(mn);
	}
}

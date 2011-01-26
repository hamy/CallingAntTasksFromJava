/**
 * 
 */
package catfj.simpletasks;

import org.apache.tools.ant.taskdefs.Echo;
import org.apache.tools.ant.util.Base64Converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import catfj.AbstractCatfjTestCase;

/**
 * Test case for the Ant Base64 encoder utility.
 */
public class TestBase64Converter extends AbstractCatfjTestCase {

	private Base64Converter converter;

	@Before
	public void setUp() {
		String mn = debugEntering("setUp");
		converter = new Base64Converter();
		debug(mn, "converter created: ", converter);
		debugLeaving(mn);
	}

	@Test
	public void testOneSpace() throws Exception {
		String mn = debugEntering("testOneSpace");
		String encoded = converter.encode(" ");
		debug(mn, "encoded space: \"", encoded, "\"");
		assertNotNull(encoded);
		assertEquals("encoding mismatch: ", "IA==", encoded);
		debugLeaving(mn);
	}

	@Test
	public void testBaseAuth() throws Exception {
		String mn = debugEntering("testBaseAuth");
		String original = "guest:guest";
		String encoded = converter.encode(original);
		debug(mn, "encoded: \"", encoded, "\"");
		assertNotNull(encoded);
		assertTrue(encoded.length() > original.length());
		debugLeaving(mn);
	}
}

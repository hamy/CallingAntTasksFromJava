package catfj;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

public class TempDir extends DebuggableObject {

	private File baseDir;

	public File getBaseDir() {
		return baseDir;
	}

	public TempDir() throws IOException {
		debugEntering(MN_INIT);
		baseDir = File.createTempFile("catfj-", "-tempdir");
		debug(MN_INIT, "base dir: ", baseDir);
		if (baseDir.exists()) {
			baseDir.delete();
		}
		assertFalse(baseDir.exists());
		baseDir.mkdirs();
		assertTrue(baseDir.exists());
		assertTrue(baseDir.isDirectory());
		debugLeaving(MN_INIT);
	}
}

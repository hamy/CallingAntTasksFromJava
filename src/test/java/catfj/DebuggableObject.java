/**
 * 
 */
package catfj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This base class provides a very crude set of logging methods.
 */
public class DebuggableObject {

	/**
	 * The "method name" for constructors.
	 */
	public static final String MN_INIT = "<<INIT>>";

	private final Logger logger;

	/**
	 * Initializes the instance. A {@link Logger} instance is associated with
	 * the fully-qualified class name.
	 */
	public DebuggableObject() {
		logger = LoggerFactory.getLogger(getClass());
	}

	private void buildMessage(String mn, String mnDetails,
			Object... messageParts) {
		if (!logger.isDebugEnabled())
			return;
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append(mn);
		if (mnDetails != null) {
			sb.append('/');
			sb.append(mnDetails);
		}
		sb.append("] ");
		for (Object messagePart : messageParts) {
			sb.append(messagePart);
		}
		logger.debug(sb.toString());
	}

	/**
	 * Method specific prolog.
	 * 
	 * @param mn
	 *            The name of the method.
	 * @param messageParts
	 *            The message details.
	 * @return The method name.
	 */
	public String debugEntering(String mn, Object... messageParts) {
		buildMessage(mn, "Entering", messageParts);
		return mn;
	}

	/**
	 * Method specific epilog.
	 * 
	 * @param mn
	 *            The name of the method.
	 * @param messageParts
	 *            The message details.
	 */
	public void debugLeaving(String mn, Object... messageParts) {
		buildMessage(mn, "Leaving", messageParts);
	}

	/**
	 * Debug method.
	 * 
	 * @param mn
	 *            The name of the method.
	 * @param messageParts
	 *            The message details.
	 */
	public void debug(String mn, Object... messageParts) {
		buildMessage(mn, null, messageParts);
	}
}

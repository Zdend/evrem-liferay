package net.evrem.commons.util;

import org.apache.commons.lang.StringEscapeUtils;

import com.Ostermiller.util.Base64;

public class FormDataUtil {

	public static final String ENCRYPTER_KEY = "jA7DFaAMVdYpi81xaSv1r5WE";
	public static final String ENCRYPTER_PARAM = "z74qgVm3";
	public static final String CLIENT_ID_PREFIX = "CLIENTID";

	/**
	 * utility class
	 */
	private FormDataUtil() {

	}

	/**
	 * Replaces characters in user input that can potentially cause XSS attack
	 * 
	 * @param input
	 * @return
	 */
	public static String escape(final String data) {
		if (data == null) {
			return null;
		}
		String result = data.replaceAll("<", "").replaceAll(">", "");
		return result;
	}

	/**
	 * Replaces characters in user input that can potentially cause XSS attack
	 * 
	 * @param input
	 * @return
	 */
	public static String escapeField(final String data) {
		if (data == null) {
			return null;
		}
		String result = StringEscapeUtils.escapeHtml(data);
		return result;
	}

	/**
	 * Encodes client unique id
	 * 
	 * @param userId
	 * @param clientUniqueId
	 * @return
	 */
	public static String encodeClientUniqueId(Long clientUniqueId) {
		Encrypter encrypter = new Encrypter(ENCRYPTER_KEY, ENCRYPTER_PARAM);

		String encrypted = CLIENT_ID_PREFIX + Base64.encode(encrypter.encrypt(String.valueOf(clientUniqueId)));
		return encrypted;
	}

	/**
	 * Decodes client unique id
	 * 
	 * @param userId
	 * @param encodedClientUniqueId
	 * @return
	 */
	public static Long decodeClientUniqueId(String encodedClientUniqueId) {
		if (encodedClientUniqueId == null) {
			return null;
		}

		if (encodedClientUniqueId.startsWith(CLIENT_ID_PREFIX)) {
			Encrypter encrypter = new Encrypter(ENCRYPTER_KEY, ENCRYPTER_PARAM);

			String tmpEncoded = encodedClientUniqueId.substring(CLIENT_ID_PREFIX.length());
			String decrypted = encrypter.decrypt(Base64.decode(tmpEncoded));

			return Long.valueOf(decrypted);
		} else {
			return Long.valueOf(encodedClientUniqueId);
		}

	}
}

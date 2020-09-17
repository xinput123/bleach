package com.xinput.bleach.util.sign;

import com.xinput.bleach.util.Logs;
import com.xinput.bleach.util.StringUtils;
import org.slf4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64算法
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-09-16 15:12
 */
public final class BASE64Utils {

    private static final Logger logger = Logs.get();

    /**
     * Base64加密
     *
     * @param source str
     * @return base64 str
     */
    public static String encode(final String source) {
        final Base64.Encoder encoder = Base64.getEncoder();
        byte[] textByte = source.getBytes();
        return encoder.encodeToString(textByte);
    }

    /**
     * Base64加密
     *
     * @param source      str
     * @param charsetName 指定编码格式
     * @return base64 str
     */
    public static String encode(final String source, String charsetName) {
        final Base64.Encoder encoder = Base64.getEncoder();
        try {
            byte[] textByte = source.getBytes(charsetName);
            return encoder.encodeToString(textByte);
        } catch (final UnsupportedEncodingException e) {
            logger.error("BASE64 encode exception. source:[{}],charset:[{}].", source, charsetName, e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * Base64解码
     *
     * @param source base64 str
     * @return str
     */
    public static String decode(final String source) {
        final Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(source));
    }

    /**
     * Base64解码
     *
     * @param source base64 str
     * @return str
     */
    public static String decode(final String source, String charsetName) {
        final Base64.Decoder decoder = Base64.getDecoder();
        try {
            return new String(decoder.decode(source), charsetName);
        } catch (final UnsupportedEncodingException e) {
            logger.error("BASE64 decode exception. source:[{}],charset:[{}].", source, charsetName, e);
            return StringUtils.EMPTY;
        }
    }
}

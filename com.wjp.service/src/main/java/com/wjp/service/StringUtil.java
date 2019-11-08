package com.wjp.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StringUtil extends StringUtils {
    private final static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 字符串连接
     *
     * @param list
     * @param joinChar
     * @return
     */
    public static String join(List<String> list, String joinChar) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return join(list.toArray(), joinChar);
    }

    /**
     * 字符串连接
     *
     * @param arrays
     * @param joinChar
     * @return
     */
    public static String join(String[] arrays, String joinChar) {
        if (arrays == null || arrays.length <= 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrays.length; i++) {
            sb.append(arrays[i]);
            if (i >= arrays.length - 1) {
                continue;
            }
            sb.append(joinChar == null ? "" : joinChar);
        }
        return sb.toString();
    }

    /**
     * 截取内容
     *
     * @param message
     * @param maxLength
     * @return
     */
    public static String subLenMessage(String message, int maxLength) {
        if (isEmpty(message) || maxLength <= 0) {
            return "";
        }
        if (message.length() > maxLength) {
            return message.substring(0, maxLength);
        }
        return message;
    }

}

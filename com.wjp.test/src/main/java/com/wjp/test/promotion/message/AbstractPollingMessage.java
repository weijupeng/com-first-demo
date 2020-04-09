package com.wjp.test.promotion.message;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kancy
 * @date 2019/12/19 22:06
 **/
@NoArgsConstructor
public abstract class AbstractPollingMessage extends HashMap<String, Object> implements PollingMessage {
    /**
     * 缓存这个值，避免每次解析
     */
    private static transient Map<Class<? extends AbstractPollingMessage>, String> messageKeyCache = new HashMap<>();

    /**
     * 消息渠道配置对应的key
     * @return
     */
    @Override
    public String getMessageKey() {
        if (!messageKeyCache.containsKey(this.getClass())) {
            synchronized (this.getClass()) {
                if (!messageKeyCache.containsKey(this.getClass())) {
//                    initKey();
                }
            }
        }
        return messageKeyCache.get(this.getClass());
    }

    /**
     * 初始化
     */
//    private void initKey() {
//        String messageKey = null;
//        // 用注解的方式
//        MessageKey annotation = this.getClass().getDeclaredAnnotation(MessageKey.class);
//        if (Objects.nonNull(annotation)) {
//            messageKey = annotation.value();
//        }
//        if (Objects.isNull(messageKey) || messageKey.trim().isEmpty()) {
//            throw new IllegalStateException(String.format("PollingMessage [%s] message key is empty", this.getClass().getUserName()));
//        }
//        messageKeyCache.put(this.getClass(), messageKey);
//    }
}

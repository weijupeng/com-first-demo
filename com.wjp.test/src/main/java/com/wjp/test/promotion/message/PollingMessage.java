package com.wjp.test.promotion.message;

import java.io.Serializable;

/**
 * @author kancy
 * @date 2019/12/19 21:58
 **/
public interface PollingMessage extends Serializable {

   /**
    * 消息渠道配置对应的key
    * @return
    */
   String getMessageKey();
}

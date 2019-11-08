package com.wjp.service.test.game;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wjp
 * @date 2019/10/28 14:58
 */
@Data
@AllArgsConstructor
public class GameCharacter implements Serializable {
    private static final long serialVersionUID = -4788750597216714384L;
    private int power;
    private String type;
    private String[] weapons;


}

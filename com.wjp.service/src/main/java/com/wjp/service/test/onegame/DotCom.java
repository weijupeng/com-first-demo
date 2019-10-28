package com.wjp.service.test.onegame;

import lombok.Data;

import java.util.List;

@Data
class DotCom  {

    private String name;
    private List<String> locationCells;


    /**
     * 检查是否命中
     *
     * @param userGuess 用户猜测
     * @return 是否命中
     */
    String checkYourself(String userGuess) {
        String result = "miss";
        int index = locationCells.indexOf(userGuess);
        if (index >= 0) {
            locationCells.remove(index);

            if (getLocationCells().isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " :( ");
            } else {
                result = "hit";
            }
        }
        System.out.println("result = " + result);
        return result;
    }

}

package com.wjp.service.test.inherited;

import lombok.Data;

/**
 * @author weijupeng
 */
@Data
public class FamilyDoctor extends Doctor {
    private boolean makeHouseCells;

    @Override
    void treatPatient() {
        System.out.println("子类的方法");
    }

    void giveAdvice() {

    }

}

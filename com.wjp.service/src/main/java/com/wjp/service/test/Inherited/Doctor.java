package com.wjp.service.test.inherited;

import lombok.Data;

/**
 * @author weijupeng
 */
@Data
public class Doctor {
    private boolean worksAtHospital;

    void treatPatient() {
        System.out.println("父类的方法");

    }
}

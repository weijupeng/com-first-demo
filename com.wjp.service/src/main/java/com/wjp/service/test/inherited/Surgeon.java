package com.wjp.service.test.inherited;

public class Surgeon extends Doctor {
    @Override
    void treatPatient() {
        Doctor doctor = new FamilyDoctor();
        doctor.treatPatient();
    }

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon();
        surgeon.treatPatient();
    }

    void makeIncision() {
        //好恶心
    }
}

package com.example.pondd.mvcstructue.manager.bus.event;

/**
 * Created by nuuneoi on 12/4/2014.
 */
public class BusEventPill {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BusEventPill(String value) {

        this.value = value;
    }
}

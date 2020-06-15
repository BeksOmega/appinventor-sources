package com.google.appinventor.components.common;

import com.google.appinventor.components.common.OptionList;

public enum Animal implements OptionList {
    Lion("lion"),
    @Default
    Giraffe("giraffe"),
    Elephant("elephant"),
    @Deprecated
    Dodo("dodo");

    private String animal;

    Animal(String anim) {
        this.animal = anim;
    }

    public String getValue() {
        return animal;
    }
}
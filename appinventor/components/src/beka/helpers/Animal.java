package beka.helpers;

import com.google.appinventor.components.common.OptionList;
import com.google.appinventor.components.common.Default;

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
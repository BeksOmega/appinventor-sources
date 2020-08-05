package beka.helpers;

import com.google.appinventor.components.common.OptionList;
import com.google.appinventor.components.common.Default;

public enum Animal implements OptionList<String> {
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

    public String toUnderlyingValue() {
        return animal;
    }

    public static Animal fromUnderlyingValue(String val) {
        return Animal.Lion;
    }
}
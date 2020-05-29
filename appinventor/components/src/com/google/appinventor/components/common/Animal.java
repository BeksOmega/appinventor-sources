
package com.google.appinventor.components.common;

import com.google.appinventor.components.annotations.OptionList;

/**
 * Test.
 */
public enum Animal implements OptionList {
    /**
     * Test2.
     */
    Lion("lion"),
    Giraffe("giraffe"),
    Elephant("elephant"),
    @Deprecated
    Dodo("dodo");

    private String value;

    Animal(String anim) {
        this.value = anim;
    }

    public String getValue() {
        return value;
    }
}

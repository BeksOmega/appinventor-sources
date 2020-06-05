package beka.helpers;

public enum Animal {
    /**
     * A very dandy lion.
     */
    Lion("lion"),

    /**
     * A tremendously tall giraffe.
     */
    Giraffe("giraffe"),

    /**
     * An elegant elephant.
     */
    Elephant("elephant"),

    /**
     * Dodo has been deprecated. Use Bird.Ostrich instead.
     */
    @Deprecated
    Dodo("dodo");

    private String value;

    Animal(String animal) {
        this.value = animal;
    }

    public String getValue() {
        return value;
    }

    private static final java.util.Map<String, Animal> lookup = new java.util.HashMap<>();

    static {
        for(Animal anim : Animal.values()) {
            lookup.put(anim.getValue(), anim);
        }
    }

    public static Animal get(String anim) {
        return lookup.get(anim);
    }
}

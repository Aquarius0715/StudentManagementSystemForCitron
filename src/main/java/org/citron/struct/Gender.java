package org.citron.struct;

public enum Gender {
    male,
    female,
    noAnswer;

    public static Gender getByString(String gender) {
        for (Gender value : Gender.values()) {
            if (value.toString().equals(gender)) {
                return value;
            }
        }
        return null;
    }
}

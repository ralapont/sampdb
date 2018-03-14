package org.sampdb.modeljpa.entities;

public enum Sex {

    M("Male"),
    F("Female");

    private String code;

    Sex(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Sex fromCode(String code) {
        for (Sex sex: Sex.values()){
            if (sex.getCode().equals(code)){
                return sex;
            }
        }
        throw new UnsupportedOperationException(
                "The code " + code + " is not supported!");
    }
}

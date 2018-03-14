package org.sampdb.modeljpa.entities;

public enum Category {

    T("Test"),
    Q("Query");

    private String code;

    Category(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Category fromCode(String code) {
        for (Category sex: Category.values()){
            if (sex.getCode().equals(code)){
                return sex;
            }
        }
        throw new UnsupportedOperationException(
                "The code " + code + " is not supported!");
    }
}

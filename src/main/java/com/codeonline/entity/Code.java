package com.codeonline.entity;

public class Code {
    private String language;
    private String code;

    public Code(String language, String code) {
        this.language = language;
        this.code = code;
    }

    public Code() {

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Code{" +
                "langauge='" + language + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

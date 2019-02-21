package com.ballistic.fserver.model.dto.http;

import com.google.gson.Gson;

public class Data {

    public static final String DATA = "data";
    public static final String DOC_NAME = "doc_name";
    public static final String DOC_DESCRIPTION = "doc_description";

    private String doc_name;
    private String doc_description;

    public Data() {}

    public Data(String doc_name, String doc_description) {
        this.doc_name = doc_name;
        this.doc_description = doc_description;
    }

    public String getDoc_name() { return doc_name; }
    public void setDoc_name(String doc_name) { this.doc_name = doc_name; }

    public String getDoc_description() { return doc_description; }
    public void setDoc_description(String doc_description) { this.doc_description = doc_description; }

    @Override
    public String toString() { return new Gson().toJson(this); }

}

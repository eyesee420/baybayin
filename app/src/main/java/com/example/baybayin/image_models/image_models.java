package com.example.baybayin.image_models;

public class image_models   {
    public String imageuri , docId;

    public image_models() {
    }

    public image_models(String imageuri, String docId) {
        this.imageuri = imageuri;
        this.docId = docId;
    }

    public String getImageuri() {
        return imageuri;
    }

    public void setImageuri(String imageuri) {
        this.imageuri = imageuri;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }
}

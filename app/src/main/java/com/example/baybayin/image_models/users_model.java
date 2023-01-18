package com.example.baybayin.image_models;

public class users_model {
    public String doc_id ,nickname ,fullname,email,password;

    public users_model() {
    }

    public users_model(String doc_id, String nickname, String fullname, String email, String password) {
        this.doc_id = doc_id;
        this.nickname = nickname;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

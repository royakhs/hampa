package com.arayeh.hampa.models;

public class Message {
   private String text;
   private int memberID;
   public Message(String text){
       this.text=text;
   }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}

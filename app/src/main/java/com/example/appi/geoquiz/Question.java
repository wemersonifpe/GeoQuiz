package com.example.appi.geoquiz;

/**
 * Created by 20161d13gr0112 on 01/03/2018.
 */

public class Question {

    private int textResId;

    private boolean isBtrue;

    public Question(int textresid, boolean isbtrue){
        this.textResId = textresid;
        this.isBtrue = isbtrue;
    }

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public boolean isBtrue() {
        return isBtrue;
    }

    public void setBtrue(boolean btrue) {
        isBtrue = btrue;
    }
}

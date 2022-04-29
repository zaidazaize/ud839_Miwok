package com.example.android.miwok.dataclass;

public class LangData {

    public LangData(String s){
        this.engWord = s;
        this.miwokWord =s;
    }
    private String engWord, miwokWord;

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public void setMiwokWord(String miwokWord) {
        this.miwokWord = miwokWord;
    }


}

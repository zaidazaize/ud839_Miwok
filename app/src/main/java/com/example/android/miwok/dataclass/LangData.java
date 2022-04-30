package com.example.android.miwok.dataclass;

public class LangData {
    private String engWord, miwokWord;
    private int mImageResourseId;
    public boolean isImage;

    public LangData(String s){
        this.engWord = s;
        this.miwokWord =s;
    }

    public LangData(String engWord, String miwokWord, int mImageResourseId) {
        this.engWord = engWord;
        this.miwokWord = miwokWord;
        this.mImageResourseId = mImageResourseId;
        this.isImage = true;
    }

    public LangData(String engWord, String miwokWord) {
        this.engWord = engWord;
        this.miwokWord = miwokWord;
        this.isImage = false;
    }


    public int getmImageResourseId() {
        return mImageResourseId;
    }

    public void setmImageResourseId(int mImageResourseId) {
        this.isImage = true;
        this.mImageResourseId = mImageResourseId;
    }

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

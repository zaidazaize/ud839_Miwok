package com.example.android.miwok.dataclass;

public class LangData {

    /**
     * The given class holds the data, that should be represented in the list items of the miwok app.
     *
     */
    private String engWord, miwokWord;
    private int mImageResourseId,mAudioResourseId;
    public boolean isImage;

    /*
    * Constructor that accepts all the value */
    public LangData(String engWord, String miwokWord, int mImageResourseId ,int mAudioResourseId) {
        this.engWord = engWord;
        this.miwokWord = miwokWord;
        this.mImageResourseId = mImageResourseId;
        this.isImage = true;
        this.mAudioResourseId = mAudioResourseId;
    }
    public LangData(String engWord, String miwokWord, int mAudioResourseId ) {
        this.engWord = engWord;
        this.miwokWord = miwokWord;
        this.mAudioResourseId = mAudioResourseId;
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


    public int getmAudioResourseId() {
        return mAudioResourseId;
    }

    public void setmAudioResourseId(int mAudioResourseId) {
        this.mAudioResourseId = mAudioResourseId;
    }
}

package com.example.android.miwok;

/**
 * Created by dwarf on 9/18/2017.
 */

public class Word {

    String mEWord;
    String mMWord;
    int mImageId = CHECK_AVAILABILITY;
    private static final int CHECK_AVAILABILITY = -1;

    public Word(String mWord, String eWord, int mImageId){
        this.mEWord = eWord;
        this.mMWord = mWord;
        this.mImageId = mImageId;
    }

    public Word(String mWord, String eWord){
        this.mEWord = eWord;
        this.mMWord = mWord;
    }

    public String getmWord() {
        return mMWord;
    }

    public String geteWord() { return mEWord; }

    public int getmImageId() { return mImageId; }

    public boolean hasImage(){
        return CHECK_AVAILABILITY != mImageId;
    }
}

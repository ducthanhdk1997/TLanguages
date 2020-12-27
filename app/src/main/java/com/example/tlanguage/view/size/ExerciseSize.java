package com.example.tlanguage.view.size;

import com.example.tlanguage.R;
import com.example.tlanguage.app_constant.ExerciseConstants;

public class ExerciseSize extends SizeUnit{

    public ExerciseSize() {
        super();
    }

    public int getItemAnswerHeight() {
        int itemAnswerHeight = 0;
        int displayHeight = mTLanguageSizeDataManager.getHeight();
        int answerHeight = (int) (displayHeight * ExerciseConstants.ANSWER_HEIGHT);
        int itemMarginTop = getDimensionPixelSize(R.dimen.item_answer_margin_top);
        itemAnswerHeight = (answerHeight - itemMarginTop * 4) /3;
        return itemAnswerHeight;
    }

    public int getItemAnswerWidth() {
        int itemAnswerWidth = 0;
        int displayWidth = mTLanguageSizeDataManager.getWidth();
        int itemMargin = getDimensionPixelSize(R.dimen.item_answer_margin_left);
        int answerMargin = getDimensionPixelSize(R.dimen.answer_margin_left);
        itemAnswerWidth = (displayWidth - itemMargin*2 - answerMargin*2) / 2;
        return itemAnswerWidth;
    }
}

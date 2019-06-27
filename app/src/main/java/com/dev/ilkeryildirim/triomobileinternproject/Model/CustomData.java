package com.dev.ilkeryildirim.triomobileinternproject.Model;

import com.dev.ilkeryildirim.triomobileinternproject.R;

import java.util.ArrayList;
import java.util.List;

public class CustomData {

    private String foundName,foundExplainText;
    private int foundersCount,foundTotal,foundGoal,foundPhotoID;

    public String getFoundName() {
        return foundName;
    }

    public void setFoundName(String foundName) {
        this.foundName = foundName;
    }

    public String getFoundExplainText() {
        return foundExplainText;
    }

    public void setFoundExplainText(String foundExplainText) {
        this.foundExplainText = foundExplainText;
    }

    public int getFoundersCount() {
        return foundersCount;
    }

    public void setFoundersCount(int foundersCount) {
        this.foundersCount = foundersCount;
    }

    public int getFoundTotal() {
        return foundTotal;
    }

    public void setFoundTotal(int foundTotal) {
        this.foundTotal = foundTotal;
    }

    public int getFoundGoal() {
        return foundGoal;
    }

    public void setFoundGoal(int foundGoal) {
        this.foundGoal = foundGoal;
    }

    public int getFoundPhotoID() {
        return foundPhotoID;
    }

    public void setFoundPhotoID(int foundPhotoID) {
        this.foundPhotoID = foundPhotoID;
    }


    public CustomData(String foundName, String foundExplainText, int foundersCount, int foundTotal, int foundGoal, int foundPhotoID) {
        this.foundName = foundName;
        this.foundExplainText = foundExplainText;
        this.foundersCount = foundersCount;
        this.foundTotal = foundTotal;
        this.foundGoal = foundGoal;
        this.foundPhotoID=foundPhotoID;
    }





}



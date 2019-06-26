package com.dev.ilkeryildirim.triomobileinternproject.Model;

import com.dev.ilkeryildirim.triomobileinternproject.R;

import java.util.ArrayList;
import java.util.List;

public class CustomData {

    private String foundName,foundExplainText;
    private int foundersCount,foundTotal,foundGoal,foundPhotoID;

    public CustomData(String foundName, String foundExplainText, int foundersCount, int foundTotal, int foundGoal, int foundPhotoID) {
        this.foundName = foundName;
        this.foundExplainText = foundExplainText;
        this.foundersCount = foundersCount;
        this.foundTotal = foundTotal;
        this.foundGoal = foundGoal;
        this.foundPhotoID=foundPhotoID;
    }

    private List<CustomData> founds;

    private void initializeData(){
        founds = new ArrayList<>();
        founds.add(new CustomData("School for childrens",
                "We need your help for a new school",
                3,
                2100,
                50000,
                R.drawable.facebookicon));

    }

}



package com.example.tlanguage.viewmodel;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.tlanguage.model.Group;

import java.util.ArrayList;
import java.util.List;

public class ListGroupViewModel extends AbstractViewModel {
    private List<Group> mGroups;

    public ListGroupViewModel() {
        mGroups = new ArrayList<>();
        initData();
    }

    @Override
    public void onInit() {

    }

    @Override
    public void onClick(@NonNull View view) {

    }

    public List<Group> getGroups() {
        return mGroups;
    }

    private void initData() {
        Group group1 = new Group(1, "Group1", 1, 100);
        Group group2 = new Group(2, "Group2", 1, 100);
        Group group3 = new Group(3, "Group3", 2, 100);
        Group group4 = new Group(4, "Group4", 2, 100);
        Group group5 = new Group(5, "Group5", 3, 100);
        Group group6 = new Group(6, "Group6", 3, 100);
        Group group7 = new Group(7, "Group7", 4, 100);
        Group group8 = new Group(8, "Group8", 5, 100);
        Group group9 = new Group(9, "Group8", 1, 100);
        Group group10 = new Group(10, "Group10", 2, 100);

        mGroups.add(group1);
        mGroups.add(group2);
        mGroups.add(group3);
        mGroups.add(group4);
        mGroups.add(group5);
        mGroups.add(group6);
        mGroups.add(group7);
        mGroups.add(group8);
        mGroups.add(group9);
        mGroups.add(group10);
    }
}

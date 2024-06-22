package com.example.appfood.ui.test;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.appfood.R;
import com.example.appfood.databinding.ActivityTestBinding;
import com.example.appfood.di.component.ActivityComponent;
import com.example.appfood.ui.base.BaseActivity;
import com.google.android.flexbox.AlignContent;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.databinding.BR;

public class TestActivity extends BaseActivity<ActivityTestBinding, TestViewModel> {

    FlexibleAdapter mFlexibleAdapter;
    TestAdapter mTestAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public int getBindingVariable() {
        return BR.vm;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFlexibleAdapter = new FlexibleAdapter(getTestItems());
        mTestAdapter = new TestAdapter(getTestItemsString());
        viewBinding.rcvTest.setAdapter(mTestAdapter);


        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.COLUMN);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
        flexboxLayoutManager.setAlignItems(AlignItems.FLEX_START);
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);


    }

    public List<String> getTestItemsString(){
        List<String> testItems = new ArrayList<>();
        testItems.add("Test 1");
        testItems.add("Test 2");
        testItems.add("Test 3");
        testItems.add("Test 4");
        testItems.add("Test 5");

        testItems.add("Test 6");
        testItems.add("Test 7");
        testItems.add("Test 8");
        testItems.add("Test 9");
        testItems.add("Test 10");

        testItems.add("Test 11");
        testItems.add("Test 12");
        testItems.add("Test 13");
        testItems.add("Test 14");
        testItems.add("Test 15");

        return testItems;
    }

    public List<TestItem> getTestItems(){
        List<TestItem> testItems = new ArrayList<>();
        testItems.add(new TestItem("Test 1"));
        testItems.add(new TestItem("Test 2"));
        testItems.add(new TestItem("Test 3"));
        testItems.add(new TestItem("Test 4"));
        testItems.add(new TestItem("Test 5"));

        testItems.add(new TestItem("Test 6"));
        testItems.add(new TestItem("Test 7"));
        testItems.add(new TestItem("Test 8"));
        testItems.add(new TestItem("Test 9"));
        testItems.add(new TestItem("Test 10"));

        testItems.add(new TestItem("Test 11"));
        testItems.add(new TestItem("Test 12"));
        testItems.add(new TestItem("Test 13"));
        testItems.add(new TestItem("Test 14"));
        testItems.add(new TestItem("Test 15"));

        testItems.add(new TestItem("Test 16"));
        testItems.add(new TestItem("Test 17"));
        testItems.add(new TestItem("Test 18"));
        testItems.add(new TestItem("Test 19"));
        testItems.add(new TestItem("Test 20"));

        testItems.add(new TestItem("Test 21"));
        testItems.add(new TestItem("Test 22"));
        testItems.add(new TestItem("Test 23"));
        testItems.add(new TestItem("Test 24"));
        testItems.add(new TestItem("Test 25"));

        return testItems;
    }
}

package com.example.appfood.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;


import androidx.annotation.Nullable;

import com.example.appfood.BR;
import com.example.appfood.R;
import com.example.appfood.databinding.ActivityMainBinding;
import com.example.appfood.di.component.ActivityComponent;
import com.example.appfood.ui.base.BaseActivity;
import com.example.appfood.ui.main.adapter.PartTicket;
import com.example.appfood.ui.main.adapter.TicketAdapter;
import com.example.appfood.ui.main.model.TicketPartItem;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>{

    TicketAdapter mTicketAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
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


        mTicketAdapter = new TicketAdapter(getTicketItems(), this);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.COLUMN);
//        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
//        flexboxLayoutManager.setAlignItems(AlignItems.FLEX_START);
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);
        viewBinding.rcvOrder.setAdapter(mTicketAdapter);
        viewBinding.rcvOrder.setLayoutManager(flexboxLayoutManager);



    }

    public List<TicketPartItem> getTicketItems(){
        List<TicketPartItem> listTicketItems = new ArrayList<>();

        listTicketItems.add(new TicketPartItem(20, 10, "Nguyễn Văn Bảnh", "Coca cola", PartTicket.TYPE_HEADER));
        for (int i = 0; i < 10; i++) {
            listTicketItems.add(new TicketPartItem(1, "Cocacola", 10000.0, PartTicket.TYPE_ITEM));
        }
        listTicketItems.add(new TicketPartItem("02:40", "02:40", "02:40", PartTicket.TYPE_FOOTER));

        listTicketItems.add(new TicketPartItem(20, 10, "Nguyễn Văn Bảnh", "Coca cola", PartTicket.TYPE_HEADER));
        for (int i = 0; i < 20; i++) {
            listTicketItems.add(new TicketPartItem(1, "Cocacola", 10000.0, PartTicket.TYPE_ITEM));
        }
        listTicketItems.add(new TicketPartItem("02:40", "02:40", "02:40", PartTicket.TYPE_FOOTER));


        return listTicketItems;
    }

}
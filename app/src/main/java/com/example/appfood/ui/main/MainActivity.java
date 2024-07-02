package com.example.appfood.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.android.flexbox.FlexboxLayout;
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
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);

        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);
        viewBinding.rcvOrder.setAdapter(mTicketAdapter);
        viewBinding.rcvOrder.setLayoutManager(flexboxLayoutManager);

        List<View> views = new ArrayList<>();
        List<View> viewsNext = new ArrayList<>();


        viewBinding.rcvOrder.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Loại bỏ listener để tránh gọi lại nhiều lần
                viewBinding.rcvOrder.getViewTreeObserver().removeOnGlobalLayoutListener(this);


                int recyclerViewHeight = viewBinding.rcvOrder.getHeight();

                int max = 0;
                int viewHeight = 0;
                // Get max bottom
                for (int i = 0; i < viewBinding.rcvOrder.getChildCount(); i++) {
                    View view = viewBinding.rcvOrder.getChildAt(i);
                    viewHeight = view.getHeight();
                    if (view.getBottom() < recyclerViewHeight ){
                        max = Math.max(max, view.getBottom());
                    }
                }

                Log.e("TAG", "onGlobalLayout: " + max);
                // Get views with bottom = min
                for (int i = 0; i < viewBinding.rcvOrder.getChildCount(); i++) {
                    View view = viewBinding.rcvOrder.getChildAt(i);
                    if (view.getBottom() == max) {

                        views.add(view);
                        if (i + 1 < viewBinding.rcvOrder.getChildCount())
                            viewsNext.add(viewBinding.rcvOrder.getChildAt(i + 1));
                    }

                }
                Log.e("TAG", "onGlobalLayout: " + views.size());
                // Gọi phương thức cập nhật lề dưới
//                for (View view : views) {
//                    view.setPadding(
//                            (int) view.getResources().getDimension(com.intuit.sdp.R.dimen._5sdp),
//                            (int) view.getResources().getDimension(com.intuit.sdp.R.dimen._5sdp),
//                            (int) view.getResources().getDimension(com.intuit.sdp.R.dimen._5sdp),
//                            (int) view.getResources().getDimension(com.intuit.sdp.R.dimen._15sdp));
//                }
                // Gọi phương thức cập nhật lề trên
                for (View view : viewsNext) {

//                    view.setPadding(
//                            (int) view.getResources().getDimension(com.intuit.sdp.R.dimen._5sdp),
//                            (int) view.getResources().getDimension(com.intuit.sdp.R.dimen._7sdp),
//                            (int) view.getResources().getDimension(com.intuit.sdp.R.dimen._5sdp),
//                            (int) view.getResources().getDimension(com.intuit.sdp.R.dimen._5sdp));
                }

            }
        });

    }


    public List<TicketPartItem> getTicketItems(){
        List<TicketPartItem> listTicketItems = new ArrayList<>();

        listTicketItems.add(new TicketPartItem(20, 10, "Nguyễn Văn Bảnh", "Coca cola", false, false, PartTicket.TYPE_HEADER));
        for (int i = 0; i < 10; i++) {
            listTicketItems.add(new TicketPartItem(1, "Cocacola", 10000.0, PartTicket.TYPE_ITEM));
        }
        listTicketItems.add(new TicketPartItem("02:40", "02:40", "02:40", PartTicket.TYPE_FOOTER));

        listTicketItems.add(new TicketPartItem(20, 10, "Nguyễn Văn Bảnh", "Coca cola", true, false, PartTicket.TYPE_HEADER));
        for (int i = 0; i < 20; i++) {
            listTicketItems.add(new TicketPartItem(1, "Cocacola", 10000.0, PartTicket.TYPE_ITEM));
        }
        listTicketItems.add(new TicketPartItem("02:40", "02:40", "02:40", PartTicket.TYPE_FOOTER));

        listTicketItems.add(new TicketPartItem(20, 10, "Nguyễn Văn Bảnh", "Coca cola", true, false, PartTicket.TYPE_HEADER));
        for (int i = 0; i < 20; i++) {
            listTicketItems.add(new TicketPartItem(1, "Cocacola", 10000.0, PartTicket.TYPE_ITEM));
        }
        listTicketItems.add(new TicketPartItem("02:40", "02:40", "02:40", PartTicket.TYPE_FOOTER));

        listTicketItems.add(new TicketPartItem(20, 10, "Nguyễn Văn Bảnh", "Coca cola", true, false, PartTicket.TYPE_HEADER));
        for (int i = 0; i < 20; i++) {
            listTicketItems.add(new TicketPartItem(1, "Cocacola", 10000.0, PartTicket.TYPE_ITEM));
        }
        listTicketItems.add(new TicketPartItem("02:40", "02:40", "02:40", PartTicket.TYPE_FOOTER));

        listTicketItems.add(new TicketPartItem(20, 10, "Nguyễn Văn Bảnh", "Coca cola", true, true, PartTicket.TYPE_HEADER));
 
        return listTicketItems;
    }

}
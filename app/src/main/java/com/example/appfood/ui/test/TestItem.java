package com.example.appfood.ui.test;

import android.view.View;
import android.widget.TextView;

import com.example.appfood.R;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestItem extends AbstractFlexibleItem<TestItem.TestViewHolder> {

    String test;

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.rcv_item_test;
    }

    @Override
    public TestViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter) {
        return new TestViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, TestViewHolder holder, int position, List<Object> payloads) {
        holder.tvTest.setText(test);
    }

    public static class TestViewHolder extends FlexibleViewHolder {

        TextView tvTest;
        public TestViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            tvTest = view.findViewById(R.id.tv_test);
        }
    }
}

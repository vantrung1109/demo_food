package com.example.appfood.ui.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.R;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder2>{

    @Getter
    @Setter
    private List<String> testItems;

    public TestAdapter(List<String> testItems) {
        this.testItems = testItems;
    }

    @NonNull
    @Override
    public TestViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_item_test, parent, false);
        return new TestViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder2 holder, int position) {
        String item = testItems.get(position);
        holder.tvTest.setText(item);
    }

    @Override
    public int getItemCount() {
        return testItems.size();
    }

    public static class TestViewHolder2 extends RecyclerView.ViewHolder {
        TextView tvTest;
        public TestViewHolder2(@NonNull View itemView) {
            super(itemView);
            tvTest = itemView.findViewById(R.id.tv_test);
        }
    }
}

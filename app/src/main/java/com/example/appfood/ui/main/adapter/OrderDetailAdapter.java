package com.example.appfood.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.R;
import com.example.appfood.ui.main.model.TicketPartItem;

import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.OrderDetailViewHolder>{

    private List<TicketPartItem> listOrderDetails;


    public OrderDetailAdapter(List<TicketPartItem> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
    }

    @NonNull
    @Override
    public OrderDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_item_ticket, parent, false);
        return new OrderDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailViewHolder holder, int position) {
        TicketPartItem item = listOrderDetails.get(position);
        holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(String.valueOf(item.getPrice()));

    }

    @Override
    public int getItemCount() {
        return listOrderDetails.size();
    }

    public static class OrderDetailViewHolder extends RecyclerView.ViewHolder{
        TextView tvQuantity, tvName, tvPrice;
        public OrderDetailViewHolder(@NonNull View view) {
            super(view);
            tvQuantity = view.findViewById(R.id.tv_quantity);
            tvName = view.findViewById(R.id.tv_name_product);
            tvPrice = view.findViewById(R.id.tv_price);
        }
    }
}

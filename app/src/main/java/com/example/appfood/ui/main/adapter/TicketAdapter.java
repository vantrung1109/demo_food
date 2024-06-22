package com.example.appfood.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.R;
import com.example.appfood.ui.main.model.TicketPartItem;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.OrderViewHolder>{



    private List<TicketPartItem> listTicketItems;

    private Context context;

    public TicketAdapter(List<TicketPartItem> listTicketItems, Context context) {
        this.listTicketItems = listTicketItems;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        TicketPartItem item = listTicketItems.get(position);
        if (item.getType() == PartTicket.TYPE_HEADER)
            return PartTicket.TYPE_HEADER;
        else if (item.getType() == PartTicket.TYPE_ITEM)
            return PartTicket.TYPE_ITEM;
        else
            return PartTicket.TYPE_FOOTER;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == PartTicket.TYPE_HEADER)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_header_ticket_item, parent, false);
        else if (viewType == PartTicket.TYPE_ITEM)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_item_ticket, parent, false);
        else
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_footer_ticket_item, parent, false);

        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        TicketPartItem item = listTicketItems.get(position);

        if (item == null)
            return;

        switch (holder.getItemViewType()){
            case PartTicket.TYPE_HEADER:
                holder.tvOrderNumber.setText(String.valueOf(item.getOrderId()));
                holder.tvTableNumber.setText(String.valueOf(item.getTableId()));
                holder.tvNameCustomer.setText(item.getNameCustomer());
                holder.tvNote.setText(item.getNote());
                break;
            case PartTicket.TYPE_ITEM:
                holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
                holder.tvName.setText(item.getName());
                holder.tvPrice.setText(String.valueOf(item.getPrice()));
                break;
            case PartTicket.TYPE_FOOTER:
                holder.tvTimeDrink.setText(String.valueOf(item.getTimeDrink()));
                holder.tvTimeFood.setText(String.valueOf(item.getTimeFood()));
                holder.tvTimeIce.setText(String.valueOf(item.getTimeIce()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listTicketItems.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        // Header
        TextView tvOrderNumber, tvTableNumber, tvNameCustomer;
        TextView tvNote;
        RecyclerView rcvOrderDetail;

        // Item
        TextView tvQuantity, tvName, tvPrice;

        // Footer
        RelativeLayout layoutDrink, layoutFood, layoutIce;
        TextView tvTimeDrink, tvTimeFood, tvTimeIce;

        public OrderViewHolder(@NonNull View view) {
            super(view);
            // Header
            tvOrderNumber = view.findViewById(R.id.tv_order_number);
            tvTableNumber = view.findViewById(R.id.tv_table_number);
            tvNameCustomer = view.findViewById(R.id.tv_name_customer);
            tvNote = view.findViewById(R.id.tv_note);

            // Item
            tvQuantity = view.findViewById(R.id.tv_quantity);
            tvName = view.findViewById(R.id.tv_name_product);
            tvPrice = view.findViewById(R.id.tv_price);

            // Footer
            layoutDrink = view.findViewById(R.id.layout_drink);
            layoutFood = view.findViewById(R.id.layout_food);
            layoutIce = view.findViewById(R.id.layout_ice);
            tvTimeDrink = view.findViewById(R.id.tv_time_drink);
            tvTimeFood = view.findViewById(R.id.tv_time_food);
            tvTimeIce = view.findViewById(R.id.tv_time_ice);
        }

    }
}

package com.example.appfood.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
                holder.tvOrderNumber.setText("#" + item.getOrderId());
                holder.tvTableNumber.setText("Bàn " + String.valueOf(item.getTableId()));
                holder.tvNameCustomer.setText(item.getNameCustomer());
                holder.tvNote.setText(item.getNote());


                if (item.getStatus() != null && item.getStatus()){
                    holder.imgStatus.setImageResource(R.drawable.icon_ticket_done);
                    holder.tvOrderNumber.setTextColor(context.getResources().getColor(R.color.color_number_table_done));
                    holder.layoutHeader.setBackground(context.getResources().getDrawable(R.drawable.background_item_table_done));
                    holder.tvTableNumber.setTextColor(context.getResources().getColor(R.color.black));
                    holder.tvNameCustomer.setTextColor(context.getResources().getColor(R.color.black));
                    holder.tvNote.setTextColor(context.getResources().getColor(R.color.black));
                    holder.dividerIn.setBackgroundColor(context.getResources().getColor(R.color.divider_color));
                }
                else if (item.getStatus() != null && item.getStatus() == false){
                    holder.imgStatus.setImageResource(R.drawable.icon_ticket_working);
                    holder.tvOrderNumber.setTextColor(context.getResources().getColor(R.color.color_number_order_red));
                    holder.layoutHeader.setBackground(context.getResources().getDrawable(R.drawable.background_item_table));
                    holder.tvTableNumber.setTextColor(context.getResources().getColor(R.color.white));
                    holder.tvNameCustomer.setTextColor(context.getResources().getColor(R.color.white));
                    holder.tvNote.setTextColor(context.getResources().getColor(R.color.white));
                    holder.dividerIn.setBackgroundColor(context.getResources().getColor(R.color.bg_item_table));
                }

                if (item.getIsPaid() != null && item.getIsPaid()){
                    holder.layoutHeader.setBackground(context.getResources().getDrawable(R.drawable.bg_header_is_paid));
                    holder.layoutHeader.setAlpha(0.9f);
                    holder.dividerOut.setVisibility(View.GONE);
                    holder.dividerIn.setVisibility(View.GONE);
                    holder.tvNote.setVisibility(View.GONE);
                    holder.dividerIsPaid.setVisibility(View.VISIBLE);
                }
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
        ImageView imgStatus;
        TextView tvNote;
        RelativeLayout layoutHeader;
        View dividerIn, dividerOut, dividerIsPaid;
        CardView cardView;

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
            imgStatus = view.findViewById(R.id.img_status);
            layoutHeader = view.findViewById(R.id.layout_header);
            dividerIn = view.findViewById(R.id.divider_in);
            dividerOut = view.findViewById(R.id.divider_out);
            dividerIsPaid = view.findViewById(R.id.divider_is_paid);

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

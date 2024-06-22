package com.example.appfood.ui.main.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketPartItem {
    // Header
    Integer orderId;
    Integer tableId;
    String nameCustomer;
    String note;

    // Item
    Integer quantity;
    String name;
    Double price;

    // Footer
    String timeDrink;
    String timeFood;
    String timeIce;

    // Type
    Integer type;

    // Constructor for Header
    public TicketPartItem(Integer orderId, Integer tableId, String nameCustomer, String note, Integer type) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.nameCustomer = nameCustomer;
        this.note = note;
        this.type = type;
    }

    // Constructor for Item
    public TicketPartItem(Integer quantity, String name, Double price, Integer type) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    // Constructor for Footer
    public TicketPartItem(String timeDrink, String timeFood, String timeIce, Integer type) {
        this.timeDrink = timeDrink;
        this.timeFood = timeFood;
        this.timeIce = timeIce;
        this.type = type;
    }
}

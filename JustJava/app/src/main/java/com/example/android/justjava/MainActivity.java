// Add your package below
 package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Spannable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox check_box_whippedcream = findViewById(R.id.checkbox_id);
        CheckBox check_box_chocolate = findViewById(R.id.checkbox_chocolate_id);
        EditText editText = findViewById(R.id.userName_id);
        Spannable Name = editText.getText();
        String userName = Name.toString();
        boolean hasWhippedCream = check_box_whippedcream.isChecked();
        boolean hasChocolate = check_box_chocolate.isChecked();
        int price = calculatePrice(hasWhippedCream,hasChocolate);


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, "vemuri.skarthik@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject, userName));
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(userName, price, hasWhippedCream, hasChocolate));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public String createOrderSummary(String name, int number, boolean hasWhippedCream, boolean hasChocolate){
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String totalPrice = "$" + price;
        String orderMessage = getString(R.string.order_summary_name, name);
        orderMessage += "\n" + getString(R.string.order_summary_whipped_cream, hasWhippedCream);
        orderMessage += "\n" + getString(R.string.order_summary_chocolate, hasChocolate);
        orderMessage += "\n" + getString(R.string.order_summary_quantity, quantity);
        orderMessage += "\n" + getString(R.string.order_summary_price, totalPrice);
        orderMessage += "\n" + getString(R.string.thank_you);

        //displayMessage(orderMessage);
        return orderMessage;
    }

    /**
     * Calculates the price of the order.
     *
     *
     */
    private int calculatePrice(boolean hasWhip, boolean hasChoc) {

        int price = 5;
        int whippedCreamPrice = 1;
        int chocolatePrice = 2;

        if(hasWhip)
            price = price + 1;

        if(hasChoc)
            price = price + 2;

        return price * quantity;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    public void increment(View view){
        if(quantity == 99)
            Toast.makeText(this, "You can order only 99 coffees", Toast.LENGTH_SHORT).show();
        else
            quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if(quantity == 1)
            Toast.makeText(this, "You must have at least 1 coffee", Toast.LENGTH_SHORT).show();
        else
            quantity = quantity - 1;
        displayQuantity(quantity);
    }
}
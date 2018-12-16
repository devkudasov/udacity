/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.devkudasov.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuantity();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }

    /**
     * This method called when the plus button is clicked
     */
    public void increment(View view) {
        this.quantity++;
        displayQuantity();
    }

    /**
     * This method called when the minus button is clicked
     */
    public void decrement(View view) {
        this.quantity--;
        displayQuantity();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity() {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + this.quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private String createOrderSummary(int price) {
        String priceString = NumberFormat.getCurrencyInstance().format(price);
        return String.format("Name: Dima\nQuantity: %s\nTotal: %s\nThank you!", quantity, priceString);
    }

    /**
     * This method display string parameter
     *
     * @param message that should be displayed
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method calculate price of order
     *
     * @return int price of order
     */
    private int calculatePrice() {
        return quantity * 5;
    }
}
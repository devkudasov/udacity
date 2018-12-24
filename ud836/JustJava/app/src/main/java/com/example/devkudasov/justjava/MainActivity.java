/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.devkudasov.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private int quantity = 99;

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
        CheckBox whippedCreamCheckbox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckbox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        EditText nameField = findViewById(R.id.name_field);
        String nameString = nameField.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name) + " order for " + nameString);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(nameString, hasWhippedCream, hasChocolate, price));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method called when the plus button is clicked
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, getString(R.string.is_max_quantity), Toast.LENGTH_LONG).show();
            return;
        }
        this.quantity++;
        displayQuantity();
    }

    /**
     * This method called when the minus button is clicked
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, getString(R.string.is_min_quantity), Toast.LENGTH_LONG).show();
            return;
        }
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
    private String createOrderSummary(String name, boolean hasWhippedCream, boolean hasChocolate, int price) {
        String priceString = NumberFormat.getCurrencyInstance().format(price);

        return getString(R.string.entered_name, name) + "\n" +
                        getString(R.string.is_whipped_cream_added, hasWhippedCream) + "\n" +
                        getString(R.string.is_chocolate_added, hasChocolate) + "\n" +
                        getString(R.string.total_quantity, quantity) + "\n" +
                        getString(R.string.total_price, priceString) + "\n" +
                        getString(R.string.thank_you);
    }

    /**
     * This method calculate price of order
     *
     * @param hasWhippedCream
     * @param hasChocolate
     * @return int price of order
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int price = 5;

        if (hasWhippedCream) {
            price++;
        }

        if (hasChocolate) {
            price += 2;
        }

        return quantity * price;
    }
}
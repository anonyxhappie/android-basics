package com.anonyxhappie.dwarf.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity;
    CheckBox wc_checkBox;
    CheckBox c_checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = 0;
        wc_checkBox = (CheckBox) findViewById(R.id.cb_whippedCream);
        c_checkBox = (CheckBox) findViewById(R.id.cb_chocolate);
    }

    /**
     *  Calculate the order
     * @param
     */
    public int calculate(){
        int price = 5;
        if(wc_checkBox.isChecked()) price += 1;
        if(c_checkBox.isChecked()) price += 2;
        return price*quantity;
    }

    /**
     *  submitOrder - Triggered on Order Button
     * @param view
     */
    public void submitOrder(View view){
        int price = calculate();
        EditText editText = (EditText) findViewById(R.id.et_name);
        String name = editText.getText().toString();
        //displayPrice(createOrderSummary(price, name));
        Toast.makeText(this, getString(R.string.toast_msg), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(price, name));
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    /**
     * Create summary of the order.
     *
     * @param price of the order
     * @return text summary
     */
    String createOrderSummary(int price, String name){

        String summary = getString(R.string.order_summary_name, name);
        if (wc_checkBox.isChecked() && c_checkBox.isChecked()){
            summary+=getString(R.string.order_summary_toppings);
        } else if (c_checkBox.isChecked()){
            summary+=getString(R.string.order_summary_chocolate);
        } else if (wc_checkBox.isChecked()){
            summary+=getString(R.string.order_summary_whippedCream);
        }
        summary+=getString(R.string.order_summary_quantity) + quantity +
                getString(R.string.order_summary_total) + price +
                getString(R.string.order_summary_thankYou);
        return summary;
    }

    /**
     * Increment the quantity value by 1
     * and call display method with updated quantity
     *
     * @param view
     */
    public void increment(View view) {
        quantity+=1;
        display(quantity);
    }

    /**
     * Decrement the quantity value by 1
     * and call display method with updated quantity
     *
     * @param view
     */
    public void decrement(View view) {
        if (quantity > 0 ){
            quantity-=1;
            display(quantity);
        }
    }

    /**
     * To update the quantity TextView
     *
     * @param number
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+ number);
    }

    /**
     * To update the price TextView with summary
     *
     * @param summary
     */
//    private void displayPrice(String summary){
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(summary);
//    }
}

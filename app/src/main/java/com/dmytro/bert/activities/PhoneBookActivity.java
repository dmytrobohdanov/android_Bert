package com.dmytro.bert.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmytro.bert.PhonesKeeper;
import com.dmytro.bert.R;

import java.util.HashMap;
import java.util.Map;

public class PhoneBookActivity extends AppCompatActivity {
    private final int LAYOUT_ID = R.id.phonebookLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);


        showAllPhoneNumbers(this);
    }

    /**
     * Displaying phonebook to layout
     *
     * @param activity this
     */
    private void showAllPhoneNumbers(Activity activity) {
        LinearLayout layout = (LinearLayout) activity.findViewById(LAYOUT_ID);

        PhonesKeeper phonesKeeper = PhonesKeeper.getInstance(activity);
//        HashMap<String, String> phonebook = phonesKeeper.getPhoneBook();
        //todo: change order of displaying entries
        for(Map.Entry<String, String> entry: phonesKeeper.getPhoneBook().entrySet()){
            String name = entry.getKey();
            String phone = entry.getValue();

            String textToDisplay = "Name: " + name + " phone: " + phone;

            TextView textView = createTextView(this, textToDisplay);

            layout.addView(textView, 0);
        }

        //todo add button to add new entry
        //todo add possibility to delete entry and edit it
    }

    private TextView createTextView(final Activity activity, String text) {
        TextView textView = new TextView(activity);
        textView.setText(text);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);

        textView.setTextSize(17);

        return textView;
    }
}

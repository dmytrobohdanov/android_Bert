package com.dmytro.bert;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ViewSwitcher;

/**
 * Activity with all settings
 */
public class SettingsActivity extends AppCompatActivity {

    private Activity activity; //todo find another way

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        activity = this;

        final ViewSwitcher viewSwitcher = (ViewSwitcher) this.findViewById(R.id.viewSwitcher);
        Button addNewEntryToPhonebook = (Button) this.findViewById(R.id.addNewPhonenumber);
        Button submitAdding = (Button) this.findViewById(R.id.addToPhoneBookButton);

        assert submitAdding != null;
        assert viewSwitcher != null;
        assert addNewEntryToPhonebook != null;

        addNewEntryToPhonebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switching to add phone number form
                //todo make it nicer
                viewSwitcher.showNext();
            }
        });

        submitAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo inline all this

                EditText nameView = (EditText) activity.findViewById(R.id.nameToAdd);
                EditText phoneView = (EditText) activity.findViewById(R.id.phoneToAdd);

                String name = nameView.getText().toString();
                String phone = phoneView.getText().toString();

                PhonesKeeper phonesKeeper = PhonesKeeper.getInstance(activity);
                phonesKeeper.addPhoneNumber(name, phone);

                viewSwitcher.showPrevious();
                nameView.setText("");
                phoneView.setText("");
                Log.d("test", "size is" + phonesKeeper.getPhoneBookSize());
            }
        });


        //should do:
        //
        // identify user
        //
        // set key locations: home, work
        //   - user can add own labels, app keeps pair: label - location
        //
        // add new phone numbers
        //
        // on/off buttons for:
        //      - sms notifications
        //      - push notifications
        //
        // add triplet: emergency - text of notification - users to send
        //
        //
    }
}

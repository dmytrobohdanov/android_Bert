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

    private final int VIEW_SWITCHER_ID = R.id.viewSwitcher;
    private final int ADD_NEW_ENTRY_BUTTON_ID = R.id.addNewPhonenumber;
    private final int ADD_TO_PHONEBOOK_SUBMIT_BUTTON_ID = R.id.addToPhoneBookButton;

    private ViewSwitcher viewSwitcher;
    private Button addNewEntryToPhonebook;
    private Button submitAdding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setAddPhoneNumberBlock(this);


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


    /**
     * initialization of block
     * which is responsible for adding new phone to phone book
     * consist of ViewSwitcher
     *
     * @param activity setting activity
     */
    private void setAddPhoneNumberBlock(final Activity activity) {

        viewSwitcher = (ViewSwitcher) this.findViewById(VIEW_SWITCHER_ID);
        addNewEntryToPhonebook = (Button) this.findViewById(ADD_NEW_ENTRY_BUTTON_ID);
        submitAdding = (Button) this.findViewById(ADD_TO_PHONEBOOK_SUBMIT_BUTTON_ID);


        /**
         * set onClick listener to addNewEntry button
         * shows next from view switcher
         * shows form to add phone number
         */
        addNewEntryToPhonebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //switching to add phone number form
                viewSwitcher.showNext();
            }
        });

        /**
         * add onClick listener to submit button
         * onClick: take name and phone number and adds it to phone book
         */
        submitAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo change ids to constants
                EditText nameView = (EditText) activity.findViewById(R.id.nameToAdd);
                EditText phoneView = (EditText) activity.findViewById(R.id.phoneToAdd);

                String name = nameView.getText().toString();
                String phone = phoneView.getText().toString();
                //todo: validate name and phone fields

                PhonesKeeper phonesKeeper = PhonesKeeper.getInstance(activity);
                phonesKeeper.addPhoneNumber(name, phone);

                viewSwitcher.showPrevious();
                nameView.setText("");
                phoneView.setText("");
                Log.d("test", "size is" + phonesKeeper.getPhoneBookSize());
            }
        });

    }
}

package com.dmytro.bert.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.dmytro.bert.PhonesKeeper;
import com.dmytro.bert.R;

/**
 * Activity with all settings
 */
public class SettingsActivity extends AppCompatActivity {

    private final int VIEW_SWITCHER_ID = R.id.viewSwitcher;
    private final int ADD_NEW_ENTRY_BUTTON_ID = R.id.addNewPhonenumber;
    private final int ADD_TO_PHONEBOOK_SUBMIT_BUTTON_ID = R.id.addToPhoneBookButton;
    private final int SHOW_PHONEBOOK_VIEW = R.id.showPhoneBook;

    private ViewSwitcher viewSwitcher;
    private Button addNewEntryToPhonebook;
    private Button submitAdding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setAddPhoneNumberBlock(this);

        initializeShowPhonebookBlock(this);

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
     * Sets onClick listener to TextView
     * onClick shows activity with phonebook
     *
     * @param activity
     */
    private void initializeShowPhonebookBlock(Activity activity) {
        TextView showPhonebook = (TextView) activity.findViewById(SHOW_PHONEBOOK_VIEW);
        //todo if will need to show phonebook from somewhere else - rewrite this with 2nd parameter - view
        showPhonebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phonebook = new Intent(SettingsActivity.this, PhoneBookActivity.class);
                startActivity(phonebook);
            }
        });
    }


    /**
     * initialization of block
     * which is responsible for adding new phone to phone book
     * consist of ViewSwitcher
     *
     * @param activity setting activity
     */
    private void setAddPhoneNumberBlock(final Activity activity) {
        //todo rewrite this method. Should create viewSwitcher with children, but not finding. Will be able to use in other places, like phoneBookActivity
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

                //save phone to phonebook
                PhonesKeeper phonesKeeper = PhonesKeeper.getInstance(activity);
                phonesKeeper.addPhoneNumber(name, phone);

                //switch viewSwitcher to addNewEntryButton
                viewSwitcher.showPrevious();
                //clean text from fields: name and phone
                nameView.setText("");
                phoneView.setText("");
            }
        });

    }
}

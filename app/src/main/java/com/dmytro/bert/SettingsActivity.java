package com.dmytro.bert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Activity with all settings
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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

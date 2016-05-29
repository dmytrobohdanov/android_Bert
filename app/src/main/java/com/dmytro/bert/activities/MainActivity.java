package com.dmytro.bert.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dmytro.bert.PhonesKeeper;
import com.dmytro.bert.R;

/**
 * Main activity
 *
 * Keeps phone call buttons,
 * user can call from it other activities on touch events
 */
public class MainActivity extends AppCompatActivity {
    //setting constants
    public static final String POLICE = "police";
    public static final String AMBULANCE = "ambulance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo: set swipe listener: right - video activity start, left - notification sender activity start

        //todo: refactor this hell

        //get phone book
        final PhonesKeeper phonesKeeper = PhonesKeeper.getInstance(this);

        //temp adding to phonebook:
        phonesKeeper.addPhoneNumber(POLICE, "111");

        //set onClick to Settings button which opens settings activity
        Button settingsButton = (Button) this.findViewById(R.id.settingsButton);
        assert settingsButton != null;
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        //temp part just for testing
        {
            Button callToPolice = (Button) this.findViewById(R.id.call1);
            assert callToPolice != null;

            callToPolice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(phonesKeeper.getPhoneNumber(POLICE)));

                    if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Log.d("MainActivity", "Have no permission to call");
                        //todo change to something like "Dear user, you haven't allowed us make calls..."
                        return;
                    }
                    startActivity(intent);
                }
            });
        }


        //here should be:
        //Call ambulance button
        //call police button
        //settings button


        //on swipe listener:
        //to left: camera
        //right: emergency activity

    }
}

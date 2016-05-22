package com.dmytro.bert;

import android.content.Context;
import java.util.HashMap;

/**
 * Keeps all needed telephone's number
 */
public class PhonesKeeper {
    //instance of PhoneKeeper
    private static PhonesKeeper instance;

    //keeps pairs name-phone number
    private HashMap<String, String> phoneBook;


    /**
     * Constructor
     * take all phones from DB
     *
     * @param context context
     */
    private PhonesKeeper (Context context){
        //get phone numbers from DB
    }


    /**
     * Ruturning instance of PhonesKeeper
     *
     * @param context context
     * @return instance of PhonesKeeper
     */
    public static PhonesKeeper getInstance(Context context){
        if(instance == null){
            instance = new PhonesKeeper(context);
        }
        return instance;
    }

    /**
     * Adds new number to base
     *
     * @param ownersName of number's owner
     * @param phoneNumber actually phone number
     */
    public void addNumber(String ownersName, String phoneNumber){

    }

    /**
     * deleting phone number of specified person
     *
     * @param ownersName owner of phone number
     */
    public void deleteNumber(String ownersName){

    }

    /**
     * Getting phone number of specified person
     *
     * @param ownersName name of phone number owner
     * @return (for now) string containing phone number
     */
    public String getNumber(String ownersName){
        String number;
        //todo: find out what number format is needed to call someone, so could parse string to this format
        return number;
    }
}

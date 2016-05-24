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
    private PhonesKeeper(Context context) {
        phoneBook = new HashMap<>();
    }

    /**
     * Ruturning instance of PhonesKeeper
     *
     * @param context context
     * @return instance of PhonesKeeper
     */
    public static PhonesKeeper getInstance(Context context) {
        if (instance == null) {
            instance = new PhonesKeeper(context);
        }
        return instance;
    }

    /**
     * Adds new number to base
     *
     * @param ownersName  of number's owner
     * @param phoneNumber actually phone number
     */
    public void addPhoneNumber(String ownersName, String phoneNumber) {
        phoneBook.put(ownersName, reformatNumberToCall(phoneNumber));
    }

    /**
     * Reformats phone number from user's format to android's
     * adds "tel:" to it
     *
     * @param phoneNumber in user's format
     * @return phone number in format "uselble" to call it from activity
     */
    private String reformatNumberToCall(String phoneNumber) {
        return "tel:" + phoneNumber;
    }

    /**
     * deleting phone number of specified person
     *
     * @param ownersName owner of phone number
     */
    public void deletePhoneNumber(String ownersName) {
        phoneBook.remove(ownersName);
    }

    /**
     * Checks is there specified name in phone book
     *
     * @param ownersName needs to be checked
     * @return true if there is already such name in base
     */
    public boolean hasName(String ownersName) {
        return phoneBook.containsKey(ownersName);
    }

    /**
     * Getting phone number of specified person
     *
     * @param ownersName name of phone number owner
     * @return string containing phone number
     */
    public String getPhoneNumber(String ownersName) {
        return phoneBook.get(ownersName);
    }

    /**
     * todo will do later
     */
    public int getPhoneBookSize(){
        return phoneBook.size();
    }

    /**
     * todo: temp method, rethink this
     */
    public HashMap<String, String> getPhoneBook(){
        return phoneBook;
    }
}

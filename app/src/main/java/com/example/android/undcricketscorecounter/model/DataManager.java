package com.example.android.undcricketscorecounter.model;

import android.content.Context;

public class DataManager {
    private static DataManager sDataManager;
    private static PreferenceHelper sPreferenceHelper;

    /**
     * SingleTon DataManager object
     *
     * @param context context of application
     * @return DataManager instance
     */
    public static DataManager getInstance(Context context) {
        if (sDataManager == null) {
            sDataManager = new DataManager();
            sPreferenceHelper = PreferenceHelper.getInstance(context);
        }
        return sDataManager;
    }

    /**
     * Store data into preferences
     *
     * @param key   data key
     * @param value data
     */
    public void storeDataToPref(String key, int value) {
        sPreferenceHelper.writeData(key, value);
    }

    /**
     * Load data from preferences
     *
     * @param key data key
     * @return data
     */
    public int loadDataFromPref(String key) {
        return sPreferenceHelper.readData(key);
    }

    /**
     * Store string into preference
     *
     * @param key   key
     * @param value data
     */
    public void storeStringToPref(String key, String value) {
        sPreferenceHelper.writeStringData(key, value);
    }

    /**
     * Load string from preference
     *
     * @param key key
     * @return data
     */
    public String loadStringFromPref(String key) {
        return sPreferenceHelper.readStringData(key);
    }

    /**
     * Use for clearing all the preferences
     */
    public void clearPref() {
        sPreferenceHelper.clearData();
    }

    /**
     * Use for finding data is available in preference or not
     *
     * @param key preference kay
     * @return true or false depending on preference availability
     */
    public boolean isDataAvailableInPref(String key) {
        return sPreferenceHelper.isDataAvailable(key);
    }
}

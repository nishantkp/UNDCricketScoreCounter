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
    public void storeDataToPref(String key, String value) {
        sPreferenceHelper.writeData(key, value);
    }

    /**
     * Load data from preferences
     *
     * @param key data key
     * @return data
     */
    public String loadDataFromPref(String key) {
        return sPreferenceHelper.readData(key);
    }

    /**
     * Use for clearing all the preferences
     */
    public void clearPref() {
        sPreferenceHelper.clearData();
    }
}
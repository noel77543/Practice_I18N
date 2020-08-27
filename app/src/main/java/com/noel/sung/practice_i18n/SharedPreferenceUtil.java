package com.noel.sung.practice_i18n;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by noel on 2020/8/26.
 */
public class SharedPreferenceUtil {

    public static final String FILE_NAME = "SharedPreferenceFile";

    public static final String LANGUAGE = "language";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public SharedPreferenceUtil(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    //---------


    /***
     * 設置 選擇的語系
     */
    public void setSelectedLanguage(String language) {
        editor.putString(LANGUAGE, language).commit();
    }

    //--------

    /***
     * 取得 選擇的語系
     */
    public String getSelectedLanguage() {
        return sharedPreferences.getString(LANGUAGE, "");
    }

}

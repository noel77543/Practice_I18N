package com.noel.sung.practice_i18n;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

/**
 * Created by noel on 2020/8/26.
 */
public class SecondActivity extends AppCompatActivity {

    public static final String LANGUAGE_DEFAULT = "";
    public static final String LANGUAGE_JAPANESE = Locale.JAPANESE.getLanguage();
    public static final String LANGUAGE_ENGLISH = Locale.ENGLISH.getLanguage();


    private SharedPreferenceUtil sharedPreferenceUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferenceUtil = new SharedPreferenceUtil(this);

        init();
    }

    private void init() {
        setContentView(R.layout.activity_second);

        findViewById(R.id.button_default).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeLanguage(LANGUAGE_DEFAULT);
                init();
            }
        });

        findViewById(R.id.button_japanese).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeLanguage(LANGUAGE_JAPANESE);
                init();
            }
        });


        findViewById(R.id.button_english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeLanguage(LANGUAGE_ENGLISH);
                init();
            }
        });
    }


    private void changeLanguage(String language) {
        sharedPreferenceUtil.setSelectedLanguage(language);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}

package com.noel.sung.practice_i18n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

/**
 * Created by noel on 2020/8/26.
 */
public class MainActivity extends AppCompatActivity {
    private SharedPreferenceUtil sharedPreferenceUtil;

    private String lastLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        lastLanguage = sharedPreferenceUtil.getSelectedLanguage();
        initViews();
    }


    //---------------

    @Override
    protected void onResume() {
        super.onResume();
        String currentLanguage = sharedPreferenceUtil.getSelectedLanguage();
        if(!lastLanguage.equals(currentLanguage)){
            lastLanguage = currentLanguage;
            initViews();
        }
    }

    //---------------

    private void initViews(){
        initLanguage(lastLanguage);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    //---------------

    private void initLanguage(String localeCode) {
        Resources resources = getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(new Locale(localeCode));
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
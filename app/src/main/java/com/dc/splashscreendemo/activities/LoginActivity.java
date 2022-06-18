package com.dc.splashscreendemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.dc.splashscreendemo.R;
import com.dc.splashscreendemo.utils.MySharedPref;
import com.dc.splashscreendemo.utils.Utils;

public class LoginActivity extends AppCompatActivity {

    private EditText mEdtName, mEdtAge;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEdtName = findViewById(R.id.edt_name);
        mEdtAge = findViewById(R.id.edt_age);
        mBtnLogin = findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEdtName.getText().toString().trim();
                String age = mEdtAge.getText().toString().trim();
                saveLoginData(name, age);
            }
        });
    }

    /**
     * @param name
     * @param age
     */
    private void saveLoginData(String name, String age) {
        if (TextUtils.isEmpty(name)) {
            mEdtName.setError(getString(R.string.empty_msg));
        } else if (TextUtils.isEmpty(age)) {
            mEdtAge.setError(getString(R.string.empty_msg));
        } else {
            mEdtName.setError(null);
            mEdtAge.setError(null);

            int ageReturn = Utils.validateAge(age);
            if (ageReturn != -1) {
                MySharedPref pref = MySharedPref.getPreferences(this);
                pref.storeLoginData(name, ageReturn);
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                mEdtAge.setError(getString(R.string.invalid_age));
            }
        }
    }
}
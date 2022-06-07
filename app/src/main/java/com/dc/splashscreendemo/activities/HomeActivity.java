package com.dc.splashscreendemo.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.dc.splashscreendemo.R;
import com.dc.splashscreendemo.utils.MySharedPref;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //TODO start here with your own login
        TextView tvName = findViewById(R.id.tv_label_name);
        TextView tvAge = findViewById(R.id.tv_label_age);
        Button btnLogout = findViewById(R.id.btn_logout);

        MySharedPref pref = MySharedPref.getPreferences(this);
        tvName.setText(pref.getUserName());
        tvAge.setText(String.valueOf(pref.getAge()));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayAlertDialog();
            }
        });
    }

    private void displayAlertDialog() {
        new AlertDialog.Builder(HomeActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.logout_title)
                .setMessage(R.string.logout_msg)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MySharedPref.getPreferences(HomeActivity.this).clearSharedPref();
                        dialog.dismiss();
                        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                        finish();
                    }
                }).setNegativeButton(R.string.no, null).show();
    }

   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == androidx.appcompat.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }*/
}
package com.dc.splashscreendemo.mvvm;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dc.splashscreendemo.R;
import com.dc.splashscreendemo.models.WaterBottle;

/**
 * This class is a Example of MVVM
 */
public class MVVMActivity extends AppCompatActivity {
    TextView tvBrandName, tvPackedOn, tvQuantity;
    private AppViewModel appViewModel;
    ImageView imgBottle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmactivity);
        setUpActionBar();
        tvBrandName = findViewById(R.id.tv_brand_name);
        tvPackedOn = findViewById(R.id.tv_packed_date);
        tvQuantity = findViewById(R.id.tv_quantity);
        imgBottle = findViewById(R.id.img_bottle);

        findViewById(R.id.btn_bottle_details).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appViewModel.getWaterBottleData();
            }
        });

        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);
        appViewModel.waterBottleMutableLiveData.observe(this, new Observer<WaterBottle>() {
            @Override
            public void onChanged(WaterBottle waterBottle) {
                tvBrandName.setText(getString(R.string.brand) + " " + waterBottle.getBrandName());
                tvPackedOn.setText(getString(R.string.packed) + " " + waterBottle.getPackedDate());
                tvQuantity.setText(waterBottle.getWaterQuantity() + " " + getString(R.string.ltr));
                imgBottle.setImageDrawable(getDrawable(R.drawable.aquafina));
            }
        });
    }

    private void setUpActionBar() {
        ActionBar toolBar = getSupportActionBar();
        if (toolBar != null) {
            toolBar.setDisplayShowHomeEnabled(true);
            toolBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
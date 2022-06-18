package com.dc.splashscreendemo.mvvm_databinding;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dc.splashscreendemo.R;
import com.dc.splashscreendemo.databinding.ActivityMvvmWaterBottleBinding;
import com.dc.splashscreendemo.models.WaterBottle;

public class MvvmWaterBottleActivity extends AppCompatActivity {

    DataBindingViewModel mDataBindingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * ActivityMvvmDataBindingBinding = activity_mvvm_water_bottle + binding
         * We need to follow the naming convention as above format
         * eg. MainActivity.java, activity_main.xml then binding class name will be ActivityMainBinding
         * Data Binding is null safe so we don't need to worry about NullPointerException
         */
        ActivityMvvmWaterBottleBinding binding = ActivityMvvmWaterBottleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpActionBar();

        mDataBindingViewModel = new ViewModelProvider(this).get(DataBindingViewModel.class);
        binding.btnBottleDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataBindingViewModel.fetchWaterBottleData();
            }
        });

        mDataBindingViewModel.waterBottleMutableLiveData.observe(this, new Observer<WaterBottle>() {
            @Override
            public void onChanged(WaterBottle waterBottle) {
                binding.tvBrandName.setText(getString(R.string.brand) + " " + waterBottle.getBrandName());
                binding.tvPackedDate.setText(getString(R.string.packed) + " " + waterBottle.getPackedDate());
                binding.tvQuantity.setText(waterBottle.getWaterQuantity() + " " + getString(R.string.ltr));
                binding.imgBottle.setImageDrawable(getDrawable(R.drawable.bailley));
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
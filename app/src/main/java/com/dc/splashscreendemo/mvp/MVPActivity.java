package com.dc.splashscreendemo.mvp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.dc.splashscreendemo.R;
import com.dc.splashscreendemo.models.WaterBottle;
import com.dc.splashscreendemo.mvp.interfaces.WaterBottleListener;
import com.dc.splashscreendemo.mvp.presenters.WaterBottlePresenter;

public class MVPActivity extends AppCompatActivity implements WaterBottleListener {

    TextView tvBrandName, tvPackedOn, tvQuantity;
    WaterBottlePresenter mPresenter;
    ImageView imgBottle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpactivity);
        setUpActionBar();
        imgBottle = findViewById(R.id.img_bottle);
        tvBrandName = findViewById(R.id.tv_brand_name);
        tvPackedOn = findViewById(R.id.tv_packed_date);
        tvQuantity = findViewById(R.id.tv_quantity);
        mPresenter = new WaterBottlePresenter(this);
        findViewById(R.id.btn_bottle_details).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.fetchWaterBottleData();
            }
        });
    }

    @Override
    public void onWaterBottleInfoReceived(WaterBottle waterBottle) {
        tvBrandName.setText(getString(R.string.brand) + " " + waterBottle.getBrandName());
        tvPackedOn.setText(getString(R.string.packed) + " " + waterBottle.getPackedDate());
        tvQuantity.setText(waterBottle.getWaterQuantity() + " " + getString(R.string.ltr));
        imgBottle.setImageDrawable(getDrawable(R.drawable.bisleri));
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
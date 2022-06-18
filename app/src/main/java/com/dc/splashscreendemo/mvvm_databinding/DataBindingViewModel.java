package com.dc.splashscreendemo.mvvm_databinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dc.splashscreendemo.models.WaterBottle;
import com.dc.splashscreendemo.utils.Utils;

public class DataBindingViewModel extends ViewModel {

    MutableLiveData<WaterBottle> waterBottleMutableLiveData = new MutableLiveData<>();

    private WaterBottle getWaterBottle() {
        return new WaterBottle(Utils.getBrandName(3), Utils.getRandomDate(), Utils.getRandomNumber());
    }

    public void fetchWaterBottleData() {
        waterBottleMutableLiveData.setValue(getWaterBottle());
    }
}

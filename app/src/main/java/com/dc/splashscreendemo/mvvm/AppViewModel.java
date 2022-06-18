package com.dc.splashscreendemo.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dc.splashscreendemo.models.WaterBottle;
import com.dc.splashscreendemo.utils.Utils;

public class AppViewModel extends ViewModel {

    MutableLiveData<WaterBottle> waterBottleMutableLiveData = new MutableLiveData<>();

    private WaterBottle getWaterBottle() {
        return new WaterBottle(Utils.getBrandName(2), Utils.getRandomDate(), Utils.getRandomNumber());
    }

    public void getWaterBottleData() {
        waterBottleMutableLiveData.setValue(getWaterBottle());
    }
}

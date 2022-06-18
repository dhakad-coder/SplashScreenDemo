package com.dc.splashscreendemo.mvp.presenters;

import com.dc.splashscreendemo.models.WaterBottle;
import com.dc.splashscreendemo.mvp.interfaces.WaterBottleListener;
import com.dc.splashscreendemo.utils.Utils;

public class WaterBottlePresenter {

    WaterBottleListener mListener;

    public WaterBottlePresenter(WaterBottleListener listener) {
        this.mListener = listener;
    }

    public void fetchWaterBottleData() {
        mListener.onWaterBottleInfoReceived(getWaterBottle());
    }

    private WaterBottle getWaterBottle() {
        return new WaterBottle(Utils.getBrandName(1), Utils.getRandomDate(), Utils.getRandomNumber());
    }


}

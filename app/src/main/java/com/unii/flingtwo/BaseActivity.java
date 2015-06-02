package com.unii.flingtwo;

import android.app.Activity;
import android.os.Bundle;

import icepick.Icepick;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
public abstract class BaseActivity extends Activity {



    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }
}

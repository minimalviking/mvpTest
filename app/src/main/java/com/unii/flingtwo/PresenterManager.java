package com.unii.flingtwo;

import com.unii.flingtwo.login.LoginPresenter;
import com.unii.flingtwo.login.LoginPresenterInterface;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
public class PresenterManager {
    private static PresenterManager instance = new PresenterManager();
    LoginPresenterInterface loginPresenter;

    private PresenterManager() {
    }

    public static PresenterManager getInstance() {
        return instance;
    }

    public LoginPresenterInterface getLoginPresenter() {
        if (loginPresenter == null) {
            loginPresenter = new LoginPresenter();
        }
        return loginPresenter;
    }


    public void clearPresenters() {
        loginPresenter = null;
    }

}
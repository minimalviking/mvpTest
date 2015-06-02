package com.unii.flingtwo.login;

import android.text.Editable;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
public interface LoginPresenterInterface {
    void attatchView(LoginActivityInterface view);

    void onTextChanged(Editable email, Editable password);

    void onLoginButtonClick();
}

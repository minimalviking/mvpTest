package com.unii.flingtwo.login;

import android.text.Editable;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
public interface LoginPresenterInterface  {
    void bindView(LoginActivityInterface view);

    void unbindView();

    void onTextChanged(Editable email, Editable password);

    void onLoginButtonClick();
}

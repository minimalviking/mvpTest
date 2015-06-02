package com.unii.flingtwo.login;

import android.text.Editable;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
public class LoginPresenter implements LoginPresenterInterface {
    private LoginActivityInterface view;

    @Override
    public void attatchView(LoginActivityInterface view) {
        this.view = view;
        view.setButtonEnabled(isLoginAllowed());
    }


    private boolean isLoginAllowed() {
        return view.getEmail() != null && view.getPassword() !=null && view.getEmail().contains("@") && view.getPassword().length() > 5;
    }

    @Override
    public void onTextChanged(Editable email, Editable password) {
        view.setButtonEnabled(isLoginAllowed());
    }

    @Override
    public void onLoginButtonClick() { }
}

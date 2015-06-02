package com.unii.flingtwo.login;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
public interface LoginPresenterInterface  {
    void bindView(LoginActivityInterface view);

    void unbindView();

    void onTextChanged(String email, String password);

    void onLoginButtonClick();

    boolean isLoginAllowed();
}

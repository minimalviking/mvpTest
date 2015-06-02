package com.unii.flingtwo.login;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
public interface LoginActivityInterface {
    void setButtonEnabled(boolean buttonEnabled);

    String getEmail();

    String getPassword();

    void setEmail(String email);

    void setPassword(String password);

    void showProgress(boolean b);

    void loginSuccess();
}

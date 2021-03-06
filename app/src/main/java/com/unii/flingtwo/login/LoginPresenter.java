package com.unii.flingtwo.login;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jacek Olszewski on 02/06/15.
 */
public class LoginPresenter implements LoginPresenterInterface {
    private LoginActivityInterface view;
    private String                 email, password;
    private boolean waitingForNetworkResponse;

    @Override
    public void bindView(LoginActivityInterface view) {
        this.view = view;
        view.setButtonEnabled(isLoginAllowed());
        view.setPassword(password);
        view.setEmail(email);
        if (waitingForNetworkResponse) {
            view.showProgress(true);
        } else {
            view.showProgress(false);
        }
    }

    @Override
    public void unbindView() {
        view = null;
    }

    @Override
    public boolean isLoginAllowed() {
        return email != null && password != null && email.contains("@") && password.length() > 5;
    }

    @Override
    public void onTextChanged(String email, String password) {
        this.email = email;
        this.password = password;
        if (view != null) {
            view.setButtonEnabled(isLoginAllowed());
        }
    }

    @Override
    public void onLoginButtonClick() {
        view.showProgress(true);
        waitingForNetworkResponse = true;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                onNetworkResponse();
            }
        }, 5, TimeUnit.SECONDS);
    }

    private void onNetworkResponse() {
        waitingForNetworkResponse = false;
        view.showProgress(false);
        view.loginSuccess();

    }

}

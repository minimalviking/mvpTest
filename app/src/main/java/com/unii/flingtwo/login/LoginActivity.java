package com.unii.flingtwo.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.unii.flingtwo.BaseActivity;
import com.unii.flingtwo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import icepick.Icicle;


public class LoginActivity extends BaseActivity implements LoginActivityInterface {

    @InjectView(R.id.loginEmail)    EditText emailEditText;
    @InjectView(R.id.loginPassword) EditText passwordEditText;
    @InjectView(R.id.loginButton)   Button   loginButton;

    @Icicle String password;
    @Icicle String email;

    LoginPresenterInterface presenter;

    TextWatcher fieldsWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void afterTextChanged(Editable editable) {
            if (presenter != null) {
                presenter.onTextChanged(emailEditText.getText(), passwordEditText.getText());
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        if (presenter == null) {
            presenter = new LoginPresenter();
        }

        emailEditText.setText(email);
        passwordEditText.setText(password);

        presenter.attatchView(this);

        emailEditText.addTextChangedListener(fieldsWatcher);
        passwordEditText.addTextChangedListener(fieldsWatcher);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLoginButtonClick();
            }
        });
    }

    @Override
    public void setButtonEnabled(boolean buttonEnabled) {
        loginButton.setEnabled(buttonEnabled);
    }

    @Override
    public String getEmail() {
        return emailEditText.getText().toString();
    }
    @Override
    public String getPassword() {
        return passwordEditText.getText().toString();
    }
}

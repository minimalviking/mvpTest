package com.unii.flingtwo.login;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unii.flingtwo.PresenterManager;
import com.unii.flingtwo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class LoginActivity extends Activity implements LoginActivityInterface {

    @InjectView(R.id.loginEmail)    EditText emailEditText;
    @InjectView(R.id.loginPassword) EditText passwordEditText;
    @InjectView(R.id.loginButton)   Button   loginButton;
    @InjectView(R.id.progressView)  View     progressView;

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

        presenter = PresenterManager.getInstance().getLoginPresenter();

        presenter.bindView(this);

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

    @Override
    public void setEmail(String email) {
        emailEditText.setText(email);
    }

    @Override
    public void setPassword(String password) {
        passwordEditText.setText(password);
    }

    @Override
    public void showProgress(final boolean show) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (show) {
                    progressView.setVisibility(View.VISIBLE);
                } else {
                    progressView.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    @Override
    public void loginSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "LOGGED IN!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

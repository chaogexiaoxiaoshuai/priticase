package com.example.a99544.uidemo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SignUpCallback;
import com.example.a99544.uidemo.R;
import com.example.a99544.uidemo.collector.ActivityCollector;

public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    //private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = getWindow();
//设置透明状态栏,这样才能让 ContentView 向上
        //window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置状态栏颜色
        window.setStatusBarColor(Color.rgb(255, 204, 39));
        ActivityCollector.addActivites(this);

        if (AVUser.getCurrentUser() != null) {
            startActivity(new Intent(this, StartActivity.class));
            finish();
        }

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
       // mCheckBox = (CheckBox) findViewById(R.id.checkbox);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        Button mRegisterButton = (Button) findViewById(R.id.register_button);

        // ??
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        // 登陆
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        // 注册
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegister();
            }
        });

    }

    private boolean checkParams(String email, String password) {
        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            mPasswordView.setError("无效的密码");
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError("该邮箱已被注册");
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError("无效的邮箱");
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
        return cancel;
    }

    private void attemptLogin() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        boolean cancel = checkParams(email, password);
        if (cancel) {
            return;
        }
        showProgress(true);
        login(email, password);
    }

    private void attemptRegister() {
        // 获取用户输入的email和密码
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        // 检查用户输入的参数
        boolean cancel = checkParams(email, password);
        // 本次注册失败，需要重新输入
        if (cancel) {
            return;
        }

        // 展示进度圈
        showProgress(true);
        // 执行注册逻辑
        register(email, password);
    }

    /**
     * 真正执行的注册的逻辑
     * @param email
     * @param password
     */
    private void register(String email, String password) {
        AVUser user = new AVUser();
        user.setUsername(email);
        user.setPassword(password);
        user.setEmail(email);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    // 注册成功，把用户对象赋值给当前用户 AVUser.getCurrentUser()
                    Toast.makeText(LoginActivity.this,"注册成功，欢迎使用途悠！",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,StartActivity.class));
                    LoginActivity.this.finish();
                } else {
                    // 失败的原因可能有多种，常见的是用户名已经存在。
                    showProgress(false);
                    Toast.makeText(LoginActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 登陆的逻辑写在这里
     *
     * @param email    邮箱
     * @param password 密码
     */
    private void login(String email, String password) {
        AVUser.logInInBackground(email, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if (e == null) {

                    startActivity(new Intent(LoginActivity.this, StartActivity.class));
                    LoginActivity.this.finish();
                    return;
                }
                showProgress(false);
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 检测邮箱是否合法
     *
     * @param email 邮箱
     * @return 是否合法
     */
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    /**
     * 检测密码是否合法
     *
     * @param password 密码
     * @return 是否合法
     */
    private boolean isPasswordValid(String password) {
        return password.length() > 4 && password.length() < 20;
    }

    /**
     * 展示/隐藏 进度圈
     *
     * @param show true为展示/false为隐藏
     */
    private void showProgress(final boolean show) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        mLoginFormView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgressView.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }
}


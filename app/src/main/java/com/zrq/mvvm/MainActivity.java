package com.zrq.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.zrq.mvvm.databinding.ActivityMainBinding;
import com.zrq.mvvm.view_models.MainViewModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
        initEvent();
    }

    private void initData() {
        mainViewModel = new MainViewModel();
        User user = new User("admin", "123456");
        mainViewModel.getUser().setValue(user);
        MutableLiveData<User> user1 = mainViewModel.getUser();
        user1.observe(this, user2 -> {
            dataBinding.setViewModel(mainViewModel);
        });
    }

    private void initEvent() {
        dataBinding.btnLogin.setOnClickListener(v -> {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        });
    }
}
package com.example.call_api_hk;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.call_api_hk.adapter.UaerAdapter;
import com.example.call_api_hk.adapter.User;
import com.example.call_api_hk.api.ApiService;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private List<User> mListUser;
    private RecyclerView rcvUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rcvUsers = findViewById(R.id.rcv_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( this);
        rcvUsers.setLayoutManager (linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration( this, DividerItemDecoration.VERTICAL);
        rcvUsers.addItemDecoration (itemDecoration);

        mListUser = new ArrayList<>();
        callApiGetUsers();
    }

    private void callApiGetUsers() {
        ApiService.apiService.getListUsers(1).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mListUser = response.body();
                UaerAdapter userAdapter = new UaerAdapter(mListUser);
                rcvUsers.setAdapter (userAdapter);
            }


            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
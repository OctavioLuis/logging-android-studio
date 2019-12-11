package com.unsis.loggin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends AppCompatActivity {

   TextView txtUser;
   ProfilePictureView imgUser;
   Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser=(TextView)findViewById(R.id.usuario);
        imgUser=(ProfilePictureView)findViewById(R.id.imgUser);
        btnCerrar=(Button)findViewById(R.id.btnCerrarSesion);

        if(AccessToken.getCurrentAccessToken()== null){
            IrPantallaLogin();
        }else {
            Profile profile=Profile.getCurrentProfile();
            txtUser.setText(profile.getName());
            imgUser.setProfileId(profile.getId());
        }

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                IrPantallaLogin();
            }
        });

    }

    private void IrPantallaLogin() {
        Intent intent=new Intent(MainActivity.this, LogginFacebook.class);
        finish();
        startActivity(intent);
    }


}

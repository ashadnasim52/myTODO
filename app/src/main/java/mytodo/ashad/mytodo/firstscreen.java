package mytodo.ashad.mytodo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class firstscreen extends AppCompatActivity {

    private static final String USER_IS_LOGIN = "UserIsLogin";
    private static final String UI_ID_FIREBASE = "UiIdFirebase";
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstscreen);






//        FirebaseMessaging.getInstance().subscribeToTopic("NoticeAccepter");

        mAuth = FirebaseAuth.getInstance();
//        mUser = User.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
//                            mUser.setLoginState(true);
//                            mUser.setUiIdFirebase(user.getUid());
//                            editor.putBoolean(USER_IS_LOGIN, true);
//                            editor.putString(UI_ID_FIREBASE, user.getUid());
//                            editor.commit();
                    StartMainActivity();
                    firstscreen.this.finish();
                } else {
                    // User is signed out
//                            mUser.setLoginState(false);
//                            editor.putBoolean(USER_IS_LOGIN, false);
//                            editor.commit();
                    StartSignInActivity();
                    firstscreen.this.finish();
                }
            }
        };
        //add listener
        mAuth.addAuthStateListener(mAuthListener);









    } public void StartMainActivity (){
        Intent i = new Intent(firstscreen.this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void StartSignInActivity (){
        Intent i = new Intent(firstscreen.this,loginscreen.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


}

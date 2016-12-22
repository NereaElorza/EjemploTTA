package appejemplo.tta.intel.ehu.eus.appejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent= getIntent();
        TextView textLogin = (TextView)findViewById(R.id.menu_login);
        //textLogin.setText(intent.getStringExtra(EXTRA_LOGIN));

    }

    public void loging(View view){
        Intent intent = new Intent(this,MainActivity.class);
        String loging = ((EditText)findViewById(R.id.login)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.passwd)).getText().toString();
        if(authenticate(loging,passwd)){
            startActivity(intent);
        }
    }
    public boolean authenticate(String login, String passwd){
        if(login == "123"){
            if(passwd=="123"){
            Toast.makeText(
                    getApplicationContext(),
                    R.string.login_bien,
                    Toast.LENGTH_SHORT
            ).show();
            return true;}
        }else{
            Toast.makeText(
                    getApplicationContext(),
                    R.string.login_error,
                    Toast.LENGTH_SHORT
            ).show();
        }
        return false;
    }

}

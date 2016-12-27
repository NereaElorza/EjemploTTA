package appejemplo.tta.intel.ehu.eus.appejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loging(View view){
        Intent intent = new Intent(this,menu.class);
        String loging = ((EditText)findViewById(R.id.login)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.passwd)).getText().toString();
        if(authenticate(loging,passwd)){
            intent.putExtra(menu.EXTRA_LOGIN, loging);
            startActivity(intent);
        }
    }
    public boolean authenticate(String login, String passwd){
        return true;
    }

}

package appejemplo.tta.intel.ehu.eus.appejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Data server;
    private String dni;
    private User data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loging(View view){
        Intent intent = new Intent(this,MenuActivity.class);
        String loging = ((EditText)findViewById(R.id.login)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.passwd)).getText().toString();
        if(authenticate(loging,passwd)){
            intent.putExtra(MenuActivity.EXTRA_LOGIN, loging);
            startActivity(intent);
        }
    }
    public boolean authenticate(String login, String passwd){return true;}

    public void user(View view){
        new ProgressTask<User>(this){
            @Override
            protected User work()throws Exception{
                return server.user(dni);
            }

            @Override
            protected void onFinish(User result) {
                data.getName();

            }
        }.execute();
    }

}

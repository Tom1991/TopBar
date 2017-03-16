package topbar.tomcode.com.topbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopBar topbar = (TopBar) findViewById(R.id.topbar);
        topbar.setOnClickTopBarListener(new TopBar.OnClickTopBarListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "点击了左边按钮", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "点击了右边按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

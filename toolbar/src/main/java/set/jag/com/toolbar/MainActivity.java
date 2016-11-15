package set.jag.com.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @butterknife.InjectView(R.id.tol)
    Toolbar tol;
    @butterknife.InjectView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.inject(this);
        setSupportActionBar(tol);
        tol.setNavigationIcon(R.mipmap.ic_launcher);
        tol.setLogo(R.mipmap.ic_launcher);
        tol.setTitle("xxxx");
        tol.setSubtitle("副标题");
        tol.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    /*
    * 创建Toolbar的菜单点击事件
    * */
    private Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            String msg = "s";
            switch (item.getItemId()) {
                case R.id.action_edit:
                    msg += "Click edit";
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click settings";
                    break;

            }
            if (!msg.equals("")){
                Toast.makeText(MainActivity.this, "xxxxxx", Toast.LENGTH_SHORT).show();
            }

            return true;
        }
    };
/*创建menu栏*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
/*menu的点击事件*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}

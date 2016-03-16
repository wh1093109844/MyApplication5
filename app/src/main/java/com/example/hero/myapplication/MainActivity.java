package com.example.hero.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.ViewById;

import java.util.Observable;
import java.util.Observer;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity implements  Observer {

    public static final String TAG = MainActivity.class.getSimpleName();

    @ViewById(R.id.tag_edit)
    EditText tagEditText;

    @ViewById(R.id.message_edit)
    EditText messageEditText;

    @ViewById(R.id.reg_btn)
    Button regBtn;

    @ViewById(R.id.publish_btn)
    Button publishBtn;

    @ViewById(R.id.add_btn)
    Button addFragmentBtn;

    @ViewById(R.id.text_view)
    TextView showMessageTextView;

    @ViewById(R.id.fragmentLayout)
    LinearLayout fragmentLayout;

    FragmentManager fragmentManager;

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
    }


    @Click(R.id.add_btn)
    public void addFragment() {
        count++;
        FrameLayout layout = new FrameLayout(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
        lp.weight = 1;
        fragmentLayout.addView(layout, lp);
        layout.setId(count);
        MyFragment_ fragment_ = new MyFragment_();
        Bundle bundle = new Bundle();
        bundle.putString("fragment_name", "第" + count + "个fragment");
        fragment_.setArguments(bundle);
        fragmentManager.beginTransaction().add(layout.getId(), fragment_).commit();
        Log.i(TAG, "add fragment: count = " + count);
    }

    @Click(R.id.reg_btn)
    public void register() {
        String tag = tagEditText.getText().toString();
        if (TextUtils.isEmpty(tag)) {
            Toast.makeText(this, "请输入tag", Toast.LENGTH_SHORT).show();
            return;
        }
        ObserverManager.getInstance().registerObserver(tag, this);
    }

    @Click(R.id.publish_btn)
    public void publishMsg() {
        String msg = messageEditText.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            Toast.makeText(this, "请输入要发送的内容", Toast.LENGTH_SHORT).show();
            return;
        }
        String tag = tagEditText.getText().toString();
        if (TextUtils.isEmpty(tag)) {
            ObserverManager.getInstance().notifyObserver(msg);
        } else {
            ObserverManager.getInstance().notifyObserver(tag, msg);
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        showMessageTextView.setText((String)data);
    }
}

package com.example.hero.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by hero on 2016/3/16.
 */
@EFragment(R.layout.fragment_layout)
public class MyFragment extends Fragment implements Observer {

    @ViewById(R.id.fragment_name)
    TextView fragmentNameTextView;

    @ViewById(R.id.tag_edit)
    EditText tagEdit;

    @ViewById(R.id.message_edit)
    EditText messageEditText;

    @ViewById(R.id.reg_btn)
    Button regBtn;

    @ViewById(R.id.publish_btn)
    Button publishBtn;

    @ViewById(R.id.text_view)
    TextView showMessageTextView;

    @FragmentArg("fragment_name")
    String fragmentName;

    @AfterViews
    public void setFragmentName() {
        fragmentNameTextView.setText(fragmentName);
    }

    @Click(R.id.reg_btn)
    public void register() {
        String tag = tagEdit.getText().toString();
        if (TextUtils.isEmpty(tag)) {
            Toast.makeText(getContext(), "请输入tag", Toast.LENGTH_SHORT).show();
            return;
        }
        ObserverManager.getInstance().registerObserver(tag, this);
    }

    @Click(R.id.publish_btn)
    public void publishMsg() {
        String msg = messageEditText.getText().toString();
        String tag = tagEdit.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            Toast.makeText(getContext(), "请输入要发送的内容", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(tag)) {
            ObserverManager.getInstance().notifyObserver(msg);
        } else {
            ObserverManager.getInstance().notifyObserver(tag, msg);
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        showMessageTextView.setText((String) data);
    }

    public interface Listener {
        public void onListener();
    }
}

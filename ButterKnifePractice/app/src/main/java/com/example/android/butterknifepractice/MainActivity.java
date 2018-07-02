package com.example.android.butterknifepractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.titleTextView)
    TextView titleTextView;
    @BindView(R.id.smallTextView)
    TextView smallTextView;
    @BindString(R.string.title_mine)
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        titleTextView.setText(R.string.title_mine);
        smallTextView.setText("Mini title");
    }


    @OnClick(R.id.btnClickMe)
    public void onBtnClickMeClicked() {
        Toast.makeText(this, "this is next button",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnClickMe2)
    public void onBtnClickMe2Clicked() {
        Toast.makeText(this, "this is back button",Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.btnClickMe2)
    public boolean onBtnClickMe2LongClicked() {
        Toast.makeText(this, "this is Long back button",Toast.LENGTH_SHORT).show();
        return true;
    }
}

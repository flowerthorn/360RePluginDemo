package com.replugin.host;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qihoo360.replugin.RePlugin;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_start_plugin)
    Button btnStartPlugin;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnStartPlugin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RePlugin.isPluginInstalled("com.replugin.plugin")) {
                    Toast.makeText(context, "打开内置插件", Toast.LENGTH_SHORT);
                    RePlugin.startActivity(context, RePlugin.createIntent("com.replugin.plugin", "com.replugin.plugin.MainActivity"));
                }
            }
        });
    }
}

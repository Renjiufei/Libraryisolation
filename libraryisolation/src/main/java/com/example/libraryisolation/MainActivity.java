package com.example.libraryisolation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.libraryisolation.util.net.HttpCallBack;
import com.example.libraryisolation.util.net.HttpHelper;
import com.example.libraryisolation.util.net.dao.PiecesInfo;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Button btn;
    //get请求
    private String URL="http://192.168.8.211:9080/entry-access/lotteryActivity/getPieces";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv= (TextView) findViewById(R.id.tv);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpHelper.getInstance().get(URL, null, new HttpCallBack<PiecesInfo>() {
                    @Override
                    public void onFailure(String e) {

                    }

                    @Override
                    public void onSuccess(PiecesInfo piecesInfo) {
                        if(piecesInfo!=null){
                            tv.setText(piecesInfo.errmsg);
                        }
                    }
                });

            }
        });

    }
}

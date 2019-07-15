package leduc.com.gamerandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AppMayTinh extends AppCompatActivity implements View.OnClickListener{
    private EditText    edt1;
    private EditText    edt2;
    private Button      btn1;
    private Button      btn2;
    private Button      btn3;
    private Button      btn4;
    private TextView    txt;
    private int         result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_may_tinh);
        init();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }
    // set su kien click vao
    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(edt1.getText()) || TextUtils.isEmpty(edt2.getText())) {
            showToast("Requied Number");
        } else {
            int num1 = Integer.parseInt(edt1.getText()+ "");
            int num2 = Integer.parseInt(edt2.getText()+ "");
            String caculate = null;

            switch (view.getId()) {
                case R.id.button:
                    caculate = "+";
                    result = num1 + num2;
                    break;
                case R.id.button2:
                    caculate = "-";
                    result = num1 - num2;
                    break;
                case R.id.button3:
                    caculate = "*";
                    result = num1 * num2;
                    break;
                case R.id.button4:
                    caculate = "/";
                    result = num1 / num2;
                    break;
            }
            hidenKeyBoard();
            txt.setText(String.format("%d %s %d = %d", num1,caculate, num2, result));
        }
    }

    // ham dong ban phim
    public void hidenKeyBoard() {
        InputMethodManager inputMethod = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethod.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
    }

    public void showToast(String msg) {
        Toast.makeText(AppMayTinh.this, msg, Toast.LENGTH_SHORT).show();
    }

    public void init() {
        edt1 = (EditText) findViewById(R.id.editText1);
        edt2 = (EditText) findViewById(R.id.editText2);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        txt = (TextView) findViewById(R.id.textView);
    }


}

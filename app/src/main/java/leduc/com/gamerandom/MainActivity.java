package leduc.com.gamerandom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnClick;
    private TextView txt;
    private List<String> listCauDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hien thi dong toast
                //showToast();

                // set auto time
                CountDownTimer countDownTimer = new CountDownTimer(20000,1000) {
                    @Override
                    public void onTick(long l) {
                        showCauDo();
                    }

                    @Override
                    public void onFinish() {
                        btnClick.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }

    public void init() {
        btnClick = (Button) findViewById(R.id.btnClick);
        txt = (TextView) findViewById(R.id.txt);

        listCauDo = new ArrayList<>();
        listCauDo.add("cau so 1");
        listCauDo.add("cau so 2");
        listCauDo.add("cau so 3");
        listCauDo.add("cau so 4");
    }

    public void showCauDo() {
        // lay do dai cua list
        int sizeList = listCauDo.size();
        Random rd = new Random();
        // random ra cac so
        int rdNumber = rd.nextInt(sizeList);
        int rdPosition = rd.nextInt(3);
        int rdTextSize = rd.nextInt(20);
        int rdTextColor1 = rd.nextInt(265);
        int rdTextColor2 = rd.nextInt(265);
        int rdTextColor3 = rd.nextInt(265);

        // set text size
        txt.setTextSize(rdTextSize + 30);

        //set text color
        txt.setTextColor(Color.rgb(rdTextColor1, rdTextColor2,rdTextColor3));

        // vi tri hien thi
        switch (rdPosition) {
            case 0: txt.setGravity(Gravity.CENTER); break;
            case 1: txt.setGravity(Gravity.LEFT); break;
            case 2: txt.setGravity(Gravity.RIGHT); break;
        }

        // hien thi text ra mh
        txt.setText(listCauDo.get(rdNumber));
        btnClick.setVisibility(View.INVISIBLE);
    }

    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout, null);

        TextView tvCustomToast = (TextView) layout.findViewById(R.id.tvCustomToast);
        tvCustomToast.setText("Errors !!");

        Toast toast = new Toast(getApplicationContext());
        //Set vị trí hiển thị cho Toast
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 300);
        //Thời gian hiển thị của Toast
        toast.setDuration(Toast.LENGTH_LONG);
        //Set layout mycustom_toast_border.xml cho Toast
        toast.setView(layout);
        //hiển thị Toast
        toast.show();
    }
}

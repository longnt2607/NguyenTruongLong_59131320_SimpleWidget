package vn.edu.ntu.nguyentruonglong.nguyentruonglong_59131320_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, date, otherHobbies;
    RadioGroup rdgGender;
    CheckBox chkFilm, chkMusic, chkCafe, chkAlone, chkCook;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvents();
    }

    private void addView() {
        name = findViewById(R.id.txtName);
        date = findViewById(R.id.txtDate);
        rdgGender = findViewById(R.id.rdgGender);
        chkFilm = findViewById(R.id.chkFilm);
        chkMusic = findViewById(R.id.chkMusic);
        chkCafe = findViewById(R.id.chkCafe);
        chkAlone = findViewById(R.id.chkAlone);
        chkCook = findViewById(R.id.chkCook);
        otherHobbies = findViewById(R.id.txtOtherHobbies);
        btnConfirm = findViewById(R.id.btnConfirm);
    }

    private void addEvents() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformation();
            }
        });
    }

    private void getInformation() {
        String gender = "", hobbies = "";

        switch (rdgGender.getCheckedRadioButtonId()) {
            case R.id.btnMale:
                gender = "Nam";
                break;
            case R.id.btnFemale:
                gender = "Nữ";
                break;
        }

        if (chkFilm.isChecked()) {
            hobbies += "Xem phim; ";
        }
        if (chkMusic.isChecked()) {
            hobbies += "Nghe nhạc; ";
        }
        if (chkCafe.isChecked()) {
            hobbies += "Đi cafe với bạn bè; ";
        }
        if (chkAlone.isChecked()) {
            hobbies += "Ở nhà một mình; ";
        }
        if (chkCook.isChecked()) {
            hobbies += "Vào bếp nấu ăn; ";
        }

        hobbies += otherHobbies.getText().toString();

        /*StringBuffer result = new StringBuffer();
        result.append(name.getText().toString());
        result.append("\n");
        result.append("Ngày sinh: " + date.getText().toString());
        result.append("\n");
        result.append("Giới tính: " + gender); // chưa trình bày được đúng kiểu mẫu trong đề
        result.append("\n");
        result.append("Sở thích: " + hobbies);*/

        String result = "";
        result += name.getText().toString() + "\n"
                + "Ngày sinh: " + date.getText().toString() + "\n"
                + "Giới tính: " + gender + "\n"
                + "Sở thích: " + hobbies;
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
    }
}

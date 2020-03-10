package Controleur;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eatit.R;

import Controleur.RepasMainFragment;

public class MesRepasActivity extends AppCompatActivity {

    private static final String TAG="MesRepas";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateListener;
    private EditText jourRepas;
    private RepasMainFragment mFragment;
    private String mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_repas);

        jourRepas = (EditText) findViewById(R.id.jourRepas_mesRepas);
        jourRepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               Calendar cal= Calendar.getInstance();
//               int year = cal.get(Calendar.YEAR);
//               int month= cal.get(Calendar.MONTH);
//               int day= cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        AjouterRepasActivity.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        mDateListener,
//                        year,month,day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
                mDate = jourRepas.getText().toString();
                mFragment = (RepasMainFragment) getSupportFragmentManager().findFragmentById(R.id.recyclerView_mesRepas);
                if (mFragment == null) {
                    mFragment = new RepasMainFragment();
                    mFragment.configureRecyclerView(mDate);
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.recyclerView_mesRepas, mFragment)
                            .commit();
                }
            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                month=month+1;
                Log.d(TAG, "onDateSet: date: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                jourRepas.setText(date);
            }
        };
    }
}

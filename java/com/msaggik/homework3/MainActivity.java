package com.msaggik.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float apartmentPrice = 1_000_000;
    int acccount = 250_000;
    float wage = 100_000;
    int percentFree = 50;
    float percentBank = 5;
    float[] monthlyPayments = new float[120];

    private float apartmentPriceWithContribution() {
        return apartmentPrice - acccount;

    }
    public float mortgageCosts(float amount, int percent) {
        return (amount*percent)/100;
    }
    public int couthMonth(float total, float mortgageCosts, float percentBankYear) {

        float percentBankMouth = percentBankYear / 12;
        int count = 0 ;

        while (total>0) {
            count++;
            total = (total + (total*percentBankMouth)/100) - mortgageCosts;
            monthlyPayments[count - 1] = Math.min(total, mortgageCosts);
        }
        return count;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView countOut = findViewById(R.id.countOut);
        TextView manyMonthOut = findViewById(R.id.manyMonthOut);

        countOut.setText("Ипотека будет выплачиваться " + couthMonth(apartmentPriceWithContribution(), mortgageCosts(wage, percentFree), percentBank) + "месяцев");
        String monthlyPaymentsList = "";
        for(float list : monthlyPayments) {
            if (list > 0) {
                monthlyPaymentsList = monthlyPaymentsList + list + "монет ";
            }else {
                break;
            }
        }
        manyMonthOut. setText("Первоначальный взнос " + acccount + "монет, ежемесячные выплаты:"+ monthlyPaymentsList);







    }
}
package me.guideplus.simplecalculator;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class MainActivity extends Activity implements View.OnClickListener {
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_0;

    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button btn_point;
    Button btn_equle;

    Button btn_clear;
    Button btn_delete;

    EditText et_display;

//    Boolean clear_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1 = (Button) findViewById(R.id.bt_1);
        btn_2 = (Button) findViewById(R.id.bt_2);
        btn_3 = (Button) findViewById(R.id.bt_3);
        btn_4 = (Button) findViewById(R.id.bt_4);
        btn_5 = (Button) findViewById(R.id.bt_5);
        btn_6 = (Button) findViewById(R.id.bt_6);
        btn_7 = (Button) findViewById(R.id.bt_7);
        btn_8 = (Button) findViewById(R.id.bt_8);
        btn_9 = (Button) findViewById(R.id.bt_9);
        btn_0 = (Button) findViewById(R.id.bt_zero);

        btn_plus = (Button) findViewById(R.id.bt_plus);
        btn_minus = (Button) findViewById(R.id.bt_jianhao);
        btn_multiply = (Button) findViewById(R.id.bt_shenghao);
        btn_divide = (Button) findViewById(R.id.bt_chuhao);
        btn_point = (Button) findViewById(R.id.bt_dot);
        btn_equle = (Button) findViewById(R.id.bt_dengyu);

        btn_clear = (Button) findViewById(R.id.bt_clear);
        btn_delete = (Button) findViewById(R.id.bt_delete);

        et_display = (EditText) findViewById(R.id.output_sc);



        //以上是按钮的实例化

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);

        btn_plus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equle.setOnClickListener(this);

        btn_clear.setOnClickListener(this);
        btn_delete.setOnClickListener(this);

        et_display.setOnClickListener(this);

        //以上给按钮设置了点击事件
    }

    @Override
    public void onClick(View v) {
        String str = et_display.getText().toString();
        switch (v.getId()){
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
            case R.id.bt_zero:
            case R.id.bt_dot:
//                if (clear_flag){
//                    clear_flag = false;
//                    et_display.setText("");
//                }
                et_display.setText(str+((Button)v).getText());
                break;

            case R.id.bt_plus:
            case R.id.bt_jianhao:
            case R.id.bt_shenghao:
            case R.id.bt_chuhao:
//                if (clear_flag){
//                    clear_flag = false;
//                    et_display.setText("");
//                }
                et_display.setText(str+" "+((Button)v).getText()+" ");
                break;

            case R.id.bt_clear:
//                clear_flag = false;
                et_display.setText("");
                break;

            case R.id.bt_delete:

//                if (clear_flag){
//                    clear_flag = false;
//                    et_display.setText("");
//                }else
                if (str != null && !str.equals("")){
                    et_display.setText(str.substring(0 , str.length()-1));
                }
                break;

            case R.id.bt_dengyu:
                getResult();
                break;
        }
    }

    //单独运算结果
    private void getResult(){

        String exp = et_display.getText().toString();


        if (exp == null || exp.equals("")){
            return;
        }
        if (!exp.contains(" ")){
            return;
        }
//        if (clear_flag){
//            clear_flag = false;
//            return;
//        }
//
//        clear_flag = true;
        Double result = 0.0;
        String s1 = exp.substring(0,exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2 = exp.substring(exp.indexOf(" ")+3);

        if(!s1.equals("") && !s2.equals("")) {

            Double d1 = Double.parseDouble(s1);
            Double d2 = Double.parseDouble(s2);
            String r;
            if (op.equals("+")) {
                result = d1 + d2;
                et_display.setText(result.toString());
            } else if (op.equals("-")) {
                result = d1 - d2;
                et_display.setText(result.toString());
            } else if (op.equals("×")) {
                result = d1 * d2;
                et_display.setText(result + "");
            } else if (op.equals("÷")) {
                if (d2 == 0) {
                    result = Double.valueOf("0");
                    et_display.setText(result.toString());
                } else {
                    result = d1 / d2;
                    et_display.setText(result.toString());
                }

                if (!s1.contains(".") && !s2.contains(".")) {
                    r = result.toString();
                    et_display.setText(r + "");
                } else {
                    et_display.setText(result + "");
                }
            }





        }else if (!s1.equals("") && s1.equals("")){
            et_display.setText(exp);
        }else if (s1.equals("") && !s1.equals("")){
            Double d2 = Double.parseDouble(s2);
            if (op.equals("+")){
                result = 0 + d2;
                et_display.setText(result + "");
            }else if (op.equals("-")){
                result = 0 - d2;
                et_display.setText(result + "");
            }else{
                et_display.setText("");
            }




        }else{
            et_display.setText("");
        }






    }
}

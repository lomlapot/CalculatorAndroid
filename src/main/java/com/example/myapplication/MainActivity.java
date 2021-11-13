package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication.R;

public class MainActivity extends Activity implements OnClickListener {
  Button brack1,
      brack2,
      arrow,
      num1,
      num2,
      num3,
      num4,
      num5,
      num6,
      num7,
      num8,
      num9,
      num0,
      coma,
      C,
      plus,
      minus,
      mult,
      div,
      pow,
      equally;
  TextView expression;
  TextView result;
  String exept = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    brack1 = (Button) findViewById(R.id.brack1);
    brack2 = (Button) findViewById(R.id.brack2);
    arrow = (Button) findViewById(R.id.arrow);
    num1 = (Button) findViewById(R.id.num1);
    num2 = (Button) findViewById(R.id.num2);
    num3 = (Button) findViewById(R.id.num3);
    num4 = (Button) findViewById(R.id.num4);
    num5 = (Button) findViewById(R.id.num5);
    num6 = (Button) findViewById(R.id.num6);
    num7 = (Button) findViewById(R.id.num7);
    num8 = (Button) findViewById(R.id.num8);
    num9 = (Button) findViewById(R.id.num9);
    num0 = (Button) findViewById(R.id.num0);
    C = (Button) findViewById(R.id.C);
    coma = (Button) findViewById(R.id.coma);
    plus = (Button) findViewById(R.id.plus);
    minus = (Button) findViewById(R.id.minus);
    mult = (Button) findViewById(R.id.mult);
    div = (Button) findViewById(R.id.div);
    pow = (Button) findViewById(R.id.pow);
    equally = (Button) findViewById(R.id.equal);
    expression = findViewById(R.id.expr);
    result = findViewById(R.id.result);
    num1.setOnClickListener(this);
    num2.setOnClickListener(this);
    num3.setOnClickListener(this);
    num4.setOnClickListener(this);
    num5.setOnClickListener(this);
    num6.setOnClickListener(this);
    num7.setOnClickListener(this);
    num8.setOnClickListener(this);
    num9.setOnClickListener(this);
    num0.setOnClickListener(this);
    pow.setOnClickListener(this);
    mult.setOnClickListener(this);
    plus.setOnClickListener(this);
    minus.setOnClickListener(this);
    div.setOnClickListener(this);
    coma.setOnClickListener(this);
    arrow.setOnClickListener(this);
    C.setOnClickListener(this);
    brack2.setOnClickListener(this);
    equally.setOnClickListener(this);
  }

  private void show(String str) {
    expression.setText(exept = exept + str);
  }

  public void brack1(View v) {
    expression.setText(exept = exept + "(");
  }

  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.num1:
        show("1");
        break;
      case R.id.num2:
        show("2");
        break;
      case R.id.num3:
        show("3");
        break;
      case R.id.num4:
        show("4");
        break;
      case R.id.num5:
        show("5");
        break;
      case R.id.num6:
        show("6");
        break;
      case R.id.num7:
        show("7");
        break;
      case R.id.num8:
        show("8");
        break;
      case R.id.num9:
        show("9");
        break;
      case R.id.num0:
        show("0");
        break;
      case R.id.plus:
        show("+");
        break;
      case R.id.minus:
        show("-");
        break;
      case R.id.mult:
        show("×");
        break;
      case R.id.div:
        show("/");
        break;
      case R.id.pow:
        show("^");
        break;
      case R.id.C:
        expression.setText(exept = "");
        result.setText("");
        break;
      case R.id.brack2:
        show(")");
        break;
      case R.id.coma:
        show(".");
        break;
      case R.id.arrow:
        if (exept.length() == 0) exept = "";
        else {
          exept = exept.substring(0, exept.length() - 1);
          expression.setText(exept);
        }
        break;
      case R.id.equal:
        result.setText(PostfixCalc.postFixCount(Convert.convertArr(Parser.count(exept))));
        break;
    }
  }
}

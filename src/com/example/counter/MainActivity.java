package com.example.counter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends Activity implements OnClickListener{
	Button btn_0;
	Button btn_1;
	Button btn_2;
	Button btn_3;
	Button btn_4;
	Button btn_5;
	Button btn_6;
	Button btn_7;
	Button btn_8;
	Button btn_9;
	Button btn_clear;
	Button btn_del;
	Button btn_divide;
	Button btn_plus;
	Button btn_multipty;
	Button btn_minus;
	Button btn_dot;
	Button btn_equal;
	EditText et_input;
	boolean flag;   //清空标识
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_0 = (Button) findViewById(R.id.btn0);
		btn_1 = (Button) findViewById(R.id.btn1);
		btn_2 = (Button) findViewById(R.id.btn2);
		btn_3 = (Button) findViewById(R.id.btn3);
		btn_4 = (Button) findViewById(R.id.btn4);
		btn_5 = (Button) findViewById(R.id.btn5);
		btn_6 = (Button) findViewById(R.id.btn6);
		btn_7 = (Button) findViewById(R.id.btn7);
		btn_8 = (Button) findViewById(R.id.btn8);
		btn_9 = (Button) findViewById(R.id.btn9);
		btn_equal = (Button) findViewById(R.id.btn_equal);
		btn_dot = (Button) findViewById(R.id.btn_dot);
		btn_minus = (Button) findViewById(R.id.btn_minus);
		btn_multipty = (Button) findViewById(R.id.btn_multiply);
		btn_plus = (Button) findViewById(R.id.btn_plus);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_divide = (Button) findViewById(R.id.btn_divide);
		//以上是实例化按钮
		et_input = (EditText) findViewById(R.id.et_input);      //实例化显示屏
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
		btn_dot.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_multipty.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		//以上设置点击事件
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str = et_input.getText().toString();
		switch (v.getId()){
		case R.id.btn0:
		case R.id.btn1:
		case R.id.btn2:
		case R.id.btn3:
		case R.id.btn4:
		case R.id.btn5:
		case R.id.btn6:
		case R.id.btn7:
		case R.id.btn8:
		case R.id.btn9:
		case R.id.btn_dot:
			if(flag){
				flag = false;
				str = "";
				et_input.setText("");
			}
           et_input.setText(str+((Button)v).getText());
		  break;
		case R.id.btn_plus:
		case R.id.btn_divide:
		case R.id.btn_minus:
		case R.id.btn_multiply:
			if(flag){
				flag = false;
				str = "";
				et_input.setText("");
			}
			et_input.setText(str+" "+((Button)v).getText()+" ");
		  break;
		case R.id.btn_clear:
			flag = false;
			
			et_input.setText("");
		case R.id.btn_del:
			if(flag){
				flag = false;
				str = "";
				et_input.setText("");
			}
			else if(str!=null&&str.equals("")){
				et_input.setText(str.substring(0, str.length()-1));
			}
		  break;
		case R.id.btn_equal:
			getresult();
			break;
		}
	}
	private void getresult(){
		String exp = et_input.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		if(!exp.contains(" ")){
			return;
		}
		if(flag){
			flag = false;
			return;
		}
		flag = true;
		double result = 0;
		String s1 = exp.substring(0,exp.indexOf(" "));  //运算符前面的字符串
		String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);  //运算符
		String s2 = exp.substring(exp.indexOf(" ")+3);//运算符后面的字符串
		if(!s1.equals("")&&!s2.equals("")){
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			if(op.equals("＋")){
				result = d1+d2;
			}else if (op.equals("－")){
				result = d1-d2;
			}else if (op.equals("×")) {
				result = d1*d2;
			}else if (op.equals("÷")){
				if(d2==0){
					result = 0;
				}else{
					result = d1/d2;
				}
				
			
			}
		
			et_input.setText(result+"");	
		
		}else if (!s1.equals("")&&s2.equals("")){
			et_input.setText(exp);
		}else if (!s1.equals("")&&!s2.equals("")){
			double d2 = Double.parseDouble(s2);
			if(op.equals("＋")){
				result = 0+d2;
			}else if (op.equals("－")){
				result = 0-d2;
			}else if (op.equals("×")) {
				result = 0*d2;
			}else if (op.equals("÷")){
				result = 0;
			}
			if(!s2.contains(".")){
				int r = (int) result;
				et_input.setText(r+"");
			}else{
				et_input.setText(result+"");
			}
		}else{
			et_input.setText("");
		}
	}


}

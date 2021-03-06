package com.example.ndk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ndk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("one-lib");
        System.loadLibrary("two-lib");
    }

    private Button bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(setJNI("hello world") + "\n" + staticFromJNI());

        // TODO Auto-generated method stub
        bt4 = (Button) this.findViewById(R.id.bt4);
        bt4.setOnClickListener(this);
        bt5 = (Button) this.findViewById(R.id.bt5);
        bt5.setOnClickListener(this);
        bt6 = (Button) this.findViewById(R.id.bt6);
        bt6.setOnClickListener(this);
        bt7 = (Button) this.findViewById(R.id.bt7);
        bt7.setOnClickListener(this);
        bt8 = (Button) this.findViewById(R.id.bt8);
        bt8.setOnClickListener(this);
        bt9 = (Button) this.findViewById(R.id.bt9);
        bt9.setOnClickListener(this);
        bt10 = (Button) this.findViewById(R.id.bt10);
        bt10.setOnClickListener(this);
        bt11 = (Button) this.findViewById(R.id.bt11);
        bt11.setOnClickListener(this);
        bt12 = (Button) this.findViewById(R.id.bt12);
        bt12.setOnClickListener(this);
        bt13 = (Button) this.findViewById(R.id.bt13);
        bt13.setOnClickListener(this);
        bt14 = (Button) this.findViewById(R.id.bt14);
        bt14.setOnClickListener(this);
        bt15 = (Button) this.findViewById(R.id.bt15);
        bt15.setOnClickListener(this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String getJNI();

    // FILE -> SETTINGS -> TOOLS -> EXTERNAL TOOLS
    public native String setJNI(String name); // ?????????javaH ?????????????????????native????????????


    static public native String staticFromJNI();

    static public native String staticFromTwo();

    static public native String staticFromOne();

    @Override
    public void onClick(View v) {

        if (bt4 == v) {
            short s = 1;
            int i = 10;
            long l = 100;
            float f = 1000.00f;
            boolean z = true;
            int[] array = null;
            MyJavaClass mMyJavaClass = null;
            Object obj = null;
            String str = null;
            double d = 10000.000;

            byte b = 1;
            char c = 'A';
            //http://www.jianshu.com/p/04786ef923f4
            JniClient.TestDataTypeJ2C(s, i, l, f, d, c, z, b, str, array, obj, mMyJavaClass);

        } else if (v == bt5) {
            //C?????????Java?????????????????????-???????????????
            //http://www.jianshu.com/p/de2a9141b1e6
            String strFromC = JniClient.AddStr("Java2C_??????1", "Java2C_??????2");
            bt5.setText(bt5.getText() + " ->" + strFromC);
        } else if (v == bt6) {
            //http://www.jianshu.com/p/f2d3f71a1c99
            int[] javaArray = new int[]{10, 20, 30, 40, 50, 60}; // ????????????
            //C?????????Java?????????????????????-???????????????
            int[] javaArrayResult = JniClient.sumArray(javaArray);
            if (javaArrayResult != null) {
                Toast.makeText(MainActivity.this, "native?????????????????????" + javaArrayResult[0], Toast.LENGTH_SHORT).show();
            }
        } else if (v == bt7) {
            //http://www.jianshu.com/p/f2d3f71a1c99
            //C?????????Java?????????????????????-???????????????
            int[][] java2ArrayResult = JniClient.getArrayObjectFromC(100);
            if (java2ArrayResult != null) {
                Toast.makeText(MainActivity.this, "native?????????????????????" + java2ArrayResult[0][99] + "===" + java2ArrayResult[1][99], Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "native?????????????????????" + java2ArrayResult[0].length + "===" + java2ArrayResult[1].length, Toast.LENGTH_SHORT).show();
            }
        } else if (v == bt8) {
            //jni??????java??????????????? ????????? http://www.jianshu.com/p/747e0d60d5a7
            JniClient.callJavaStaticMethod();
            Toast.makeText(MainActivity.this, MyJavaClass.getResultFromC(), Toast.LENGTH_SHORT).show();
        } else if (v == bt9) {
            //jni??????java??????????????? ????????? http://www.jianshu.com/p/747e0d60d5a7
            JniClient.callJavaInstaceMethod();
            Toast.makeText(MainActivity.this, MyJavaClass.getResultFromC2(), Toast.LENGTH_SHORT).show();
        } else if (v == bt10) {
            //C/C++ ?????? Jav???????????? http://www.jianshu.com/p/7d588be423b3
            ClassField obj = new ClassField();
            obj.setNum(10);
            obj.setStr("Hello");

            // ???????????????????????????ClassField?????????????????????num
            //JniClient.accessStaticField();
            JniClient.accessInstanceField(obj);
            // ????????????????????????????????????
            System.out.println("In Java--->ClassField.num = " + obj.getNum());
            System.out.println("In Java--->ClassField.str = " + obj.getStr());
            Toast.makeText(MainActivity.this, "C/C++ ?????? Java???????????? ??????str " + obj.getNum() + "===" + obj.getStr(), Toast.LENGTH_SHORT).show();
        } else if (v == bt11) {
            //C/C++ ?????? Jav???????????? http://www.jianshu.com/p/7d588be423b3
            ClassField obj = new ClassField();
            obj.setNum(10);
            obj.setStr("Hello");
            // ???????????????????????????ClassField?????????????????????num
            JniClient.accessStaticField();
            //JniClient.accessInstanceField(obj);
            // ????????????????????????????????????
            System.out.println("In Java--->ClassField.num = " + obj.getNum());
            System.out.println("In Java--->ClassField.str = " + obj.getStr());
            Toast.makeText(MainActivity.this, "C/C++ ?????? Java???????????? ??????str " + obj.getNum() + "===" + obj.getStr(), Toast.LENGTH_SHORT).show();
        } else if (v == bt12) {
            //JNI ??????????????????????????????????????? http://www.jianshu.com/p/377d115e3c82
            Toast.makeText(MainActivity.this, "JNI ??????????????????????????????????????? ", Toast.LENGTH_SHORT).show();
            JniClient.callSuperInstanceMethod();
        } else if (v == bt13) {
            Toast.makeText(MainActivity.this, "JNI  ????????????????????? " + new DynamicRegiste().getHello() + "===" + new DynamicRegiste().meaningOfTheUniverse(), Toast.LENGTH_SHORT).show();
        } else if (v == bt14) {
            Toast.makeText(MainActivity.this, staticFromOne(), Toast.LENGTH_SHORT).show();
        } else if (v == bt15) {
            Toast.makeText(MainActivity.this, staticFromTwo(), Toast.LENGTH_SHORT).show();

        }
    }
}
package www.loveclub.com.loveclub;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

    private PopupWindow popWindow;
    private View inflate;
    private View parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.login_image).setOnClickListener(loginListener);

    }


    private TranslateAnimation animation;
    private TranslateAnimation animationOut;
    private View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (popWindow == null) {
//                parent = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);

                parent  = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
                inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.popu_layout, null, false);
                animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0);
                animation.setInterpolator(new AccelerateInterpolator());
                animation.setDuration(200);

                animationOut = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 1, 0);
                animationOut.setInterpolator(new AccelerateInterpolator());
                animationOut.setDuration(200);


                int width = getResources().getDisplayMetrics().widthPixels;
                int height = getResources().getDisplayMetrics().heightPixels;
                popWindow = new PopupWindow(inflate, width, height / 5);

            popWindow.setAnimationStyle(R.style.PopupAnimation);
                popWindow.setFocusable(true);
                popWindow.setOutsideTouchable(false);// 设置允许在外点击消失
//                popWindow.setAnimationStyle(R.style.PopupAnimation);
                LinearLayout weixin_layout = inflate.findViewById(R.id.weixin_layout);
                LinearLayout pengyouquan_layout = inflate.findViewById(R.id.pengyuquan_layout);
                LinearLayout ma_layou = inflate.findViewById(R.id.ma_layout);


                View.OnClickListener listener = new View.OnClickListener() {
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.weixin_layout:

                                break;
                            case R.id.pengyuquan_layout:

                                break;
                            case R.id.ma_layout:

                                break;
                        }

                        popWindow.dismiss();
                    }
                };

                weixin_layout.setOnClickListener(listener);
                pengyouquan_layout.setOnClickListener(listener);
                ma_layou.setOnClickListener(listener);
//                ColorDrawable dw = new ColorDrawable(0x30000000);
//                popWindow.setBackgroundDrawable(dw);
                popWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                inflate.startAnimation(animation);

            } else {
//                ColorDrawable dw = new ColorDrawable(0x20000003);
//                popWindow.setBackgroundDrawable(dw);
                popWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
//                inflate.startAnimation(animation);
            }
        }

    };





}

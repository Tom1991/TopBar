package topbar.tomcode.com.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 作者:Created by wangjl on 2017/3/16.
 * 邮箱:Tom91_Wang@163.com
 */

public class TopBar extends RelativeLayout {

    private String leftButtonText;
    private int leftButtonTextColor;
    private Drawable leftDrawable;
    private String rightButtonText;
    private int rightButtonTextColor;
    private Drawable rightDrawable;
    private String centerText;
    private int centerTextColor;
    private float centerTextSize;
    private Button leftButton;
    private Button rightButton;
    private TextView centerTextView;
    private LayoutParams leftLayoutParams;
    private LayoutParams rightLayoutParams;
    private LayoutParams centerLayoutParams;
    OnClickTopBarListener mOnClickTopBarListener;

    //定义点击topBar这个整体控件的接口
    public interface OnClickTopBarListener {
        void leftClick();

        void rightClick();
    }

    //暴露给使用者的方法
    public void setOnClickTopBarListener(OnClickTopBarListener mOnClickTopBarListener) {
        this.mOnClickTopBarListener = mOnClickTopBarListener;
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context mContext, AttributeSet mAttrs) {
        TypedArray ta = mContext.obtainStyledAttributes(mAttrs, R.styleable.topBar);

        //左边Button的属性
        leftButtonText = ta.getString(R.styleable.topBar_LeftButtonText);
        leftButtonTextColor = ta.getColor(R.styleable.topBar_LeftButtonTextColor, 0);
        leftDrawable = ta.getDrawable(R.styleable.topBar_LeftButtonBackground);

        //右边Button的属性
        rightButtonText = ta.getString(R.styleable.topBar_RightButtonText);
        rightButtonTextColor = ta.getColor(R.styleable.topBar_RightButtonTextColor, 0);
        rightDrawable = ta.getDrawable(R.styleable.topBar_RightButtonBackground);

        //中间标题
        centerText = ta.getString(R.styleable.topBar_CenterText);
        centerTextColor = ta.getColor(R.styleable.topBar_CenterTextColor, 0);
        centerTextSize = ta.getDimension(R.styleable.topBar_CenterTextSize, 16);

        ta.recycle();
        //创建子控件
        leftButton = new Button(mContext);
        leftButton.setText(leftButtonText);
        leftButton.setBackground(leftDrawable);
        leftButton.setTextColor(leftButtonTextColor);

        rightButton = new Button(mContext);
        rightButton.setText(rightButtonText);
        rightButton.setBackground(rightDrawable);
        rightButton.setTextColor(rightButtonTextColor);

        centerTextView = new TextView(mContext);
        centerTextView.setText(centerText);
        centerTextView.setTextColor(centerTextColor);
        centerTextView.setTextSize(centerTextSize);
        centerTextView.setGravity(Gravity.CENTER);

        //添加位置属性
        leftLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftButton, leftLayoutParams);

        rightLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton, rightLayoutParams);


        centerLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        centerLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(centerTextView, centerLayoutParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //触发回调监听
                mOnClickTopBarListener.leftClick();
            }
        });
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickTopBarListener.rightClick();
            }
        });
    }
}

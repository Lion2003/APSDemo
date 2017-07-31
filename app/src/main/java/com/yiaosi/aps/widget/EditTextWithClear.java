package com.yiaosi.aps.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

import com.yiaosi.aps.R;


public class EditTextWithClear extends EditText implements TextWatcher {

	private Drawable mClearDrawable;

	public EditTextWithClear(Context context) {
		super(context, null);
		// TODO Auto-generated constructor stub
	}

	public EditTextWithClear(Context context, AttributeSet attrs) {
		super(context, attrs, android.R.attr.editTextStyle);
		init();
	}

	public EditTextWithClear(Context context, AttributeSet attrs, int editStyle) {
		super(context, attrs, editStyle);
		init();
	}

	int mPaddingRight = 0;
	int mTotalPaddingRight = 0;

	private void setPaddingRightWidth() {
		mPaddingRight = getPaddingRight();
		mTotalPaddingRight = getTotalPaddingRight();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		if (event.getAction() == MotionEvent.ACTION_UP) {
			Boolean eable = event.getX() > (getWidth() - mTotalPaddingRight)
					&& event.getX() < (getWidth() - mPaddingRight);
			if (eable) {
				Drawable da = getCompoundDrawables()[2];
				if (da!=null && da.equals(mClearDrawable)) {
					this.setText("");
				}
			}
		}
		return super.onTouchEvent(event);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		setClearIconVisible(s.length() > 0 ? mClearDrawable : null);
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

	private void init() {
		try {
			mClearDrawable = getCompoundDrawables()[2];
			if (mClearDrawable == null) {
				mClearDrawable = getResources().getDrawable(
						R.drawable.delete_selector);
			}

			mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(),
					mClearDrawable.getIntrinsicHeight());

			setClearIconVisible(mClearDrawable);
			addTextChangedListener(this);
			setPaddingRightWidth();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void setClearIconVisible(Drawable rightDrawable) {
		setCompoundDrawables(getCompoundDrawables()[0],
				getCompoundDrawables()[1], rightDrawable,
				getCompoundDrawables()[3]);
	}

	public void setShakeAnimation() {
		TranslateAnimation translateAnimation = new TranslateAnimation(0, 10,
				0, 0);
		translateAnimation.setInterpolator(new CycleInterpolator(5));
		translateAnimation.setDuration(1000);
		this.setAnimation(translateAnimation);
	}
}

/*
package com.bei.test.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.cm.common.common.DimenUtils;
import com.cm.show.R;
import com.cm.show.pages.personal.fragment.PersonalCenterFragment;

public class PersonalCenterScrollView extends ScrollView {
	private static final String TAG = "PersonalCenterScrollView";
	private static final Interpolator sInterpolator = new Interpolator() {
		public float getInterpolation(float paramAnonymousFloat) {
			float f = paramAnonymousFloat - 1.0F;
			return 1.0F + f * (f * (f * (f * f)));
		}
	};
	int mActivePointerId = -1;
	private RelativeLayout mHeaderContainer;
	private int mHeaderHeight;
	float mLastMotionY = -1.0F;
	float mLastScale = -1.0F;
	float mMaxScale = -1.0F;
	private ScalingRunnalable mScalingRunnalable;
	private int mMaxHeaderHerght;
	private int mScreenWidth;
	private int mHeaderPaddingBottom;
	private int mHeaderRealHeight;

	private boolean mScrollable = true;
	private boolean mShowHeaderImage = true;
	private boolean mZoomable = true;

	private View mContainerLayout;

	*/
/************ sticky title bar **************//*

	private OnScrollListener onScrollListener;
	*/
/**
	 * 主要是用在用户手指离开MyScrollView，MyScrollView还在继续滑动，我们用来保存Y的距离，然后做比较
	 *//*

	private int lastScrollY;

	public PersonalCenterScrollView(Context paramContext) {
		super(paramContext);
		init(paramContext);
	}

	public PersonalCenterScrollView(Context paramContext,
									AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		init(paramContext);
	}

	public PersonalCenterScrollView(Context paramContext,
									AttributeSet paramAttributeSet, int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
		init(paramContext);
	}

	private void endScraling() {
		if (getHeaderBottom() >= mHeaderHeight)
//			Log.d("mmm", "endScraling");
		mScalingRunnalable.startAnimation(200L);
	}

	private void init(Context paramContext) {
		mHeaderPaddingBottom = DimenUtils.dp2px(paramContext, PersonalCenterFragment.HEADER_PADDING_BOTTOM_DP);
		mScreenWidth = DimenUtils.getScreenWidth(paramContext);
		mHeaderHeight = (int) (mScreenWidth / PersonalCenterFragment.WEBP_MASK_SCALE) + mHeaderPaddingBottom;
		mMaxHeaderHerght = (int) (mScreenWidth / PersonalCenterFragment.WEBP_SCALE) + mHeaderPaddingBottom;
		mHeaderRealHeight = mHeaderHeight;

		addContainerLayout(paramContext);

		mHeaderContainer = (RelativeLayout) mContainerLayout.findViewById(R.id.header_layout);
		setHeaderViewSize(mScreenWidth, mHeaderHeight);
		mScalingRunnalable = new ScalingRunnalable();
	}

	private void addContainerLayout(Context context) {
		mContainerLayout = LayoutInflater.from(context).inflate(R.layout.personal_center_content_layout, null);
		ViewGroup.LayoutParams params = new LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		addView(mContainerLayout, params);
	}

	private void onSecondaryPointerUp(MotionEvent paramMotionEvent) {
		int i = (paramMotionEvent.getAction()) >> 8;
//		Log.d("onSecondaryPointerUp", i + "");
		if (paramMotionEvent.getPointerId(i) == mActivePointerId)
			if (i != 0) {
				mLastMotionY = paramMotionEvent.getY(1);
				mActivePointerId = paramMotionEvent.getPointerId(0);
				return;
			}
	}

	private void reset() {
		mActivePointerId = -1;
		mLastMotionY = -1.0F;
		mMaxScale = -1.0F;
		mLastScale = -1.0F;
	}

	public boolean isScrollable() {
		return mScrollable;
	}

	public boolean isZoomable() {
		return mZoomable;
	}

	public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
		if (!mZoomable) {
			return super.onInterceptTouchEvent(paramMotionEvent);
		}
		switch (paramMotionEvent.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:

				mActivePointerId = paramMotionEvent.getPointerId(0);
				mMaxScale = (mMaxHeaderHerght * 1.0f / mHeaderHeight);
				break;

			case MotionEvent.ACTION_UP:
				reset();
				break;

			case MotionEvent.ACTION_POINTER_DOWN:
				mActivePointerId = paramMotionEvent
						.getPointerId(paramMotionEvent.getActionIndex());
				break;

			case MotionEvent.ACTION_POINTER_UP:
				onSecondaryPointerUp(paramMotionEvent);
				break;
		}
		return super.onInterceptTouchEvent(paramMotionEvent);
	}

	public boolean onTouchEvent(MotionEvent ev) {
		if (!mZoomable) {
			return super.onTouchEvent(ev);
		}
		switch (ev.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_OUTSIDE:
			case MotionEvent.ACTION_DOWN:
				if (!mScalingRunnalable.mIsFinished) {
					mScalingRunnalable.abortAnimation();
				}
				mLastMotionY = ev.getY();
				mActivePointerId = ev.getPointerId(0);
				mMaxScale = (mMaxHeaderHerght * 1.0f / mHeaderHeight);
				mLastScale = (getHeaderBottom() / mHeaderHeight);
				break;
			case MotionEvent.ACTION_MOVE:
				int j = ev.findPointerIndex(mActivePointerId);
				if (j == -1) {

				} else {
					if (mLastMotionY == -1.0F)
						mLastMotionY = ev.getY(j);
					if (getHeaderBottom() >= mHeaderHeight) {
						ViewGroup.LayoutParams localLayoutParams = mHeaderContainer
								.getLayoutParams();
						float f = ((ev.getY(j) - mLastMotionY + mHeaderContainer
								.getBottom()) / mHeaderHeight - mLastScale)
								/ 2.0F + mLastScale;
						if ((mLastScale <= 1.0D) && (f < mLastScale)) {
							localLayoutParams.height = mHeaderHeight;
							mHeaderContainer
									.setLayoutParams(localLayoutParams);
						}
						mLastScale = Math.min(Math.max(f, 1.0F),
								mMaxScale);
						localLayoutParams.height = ((int) (mHeaderHeight * mLastScale));
						if (localLayoutParams.height < mMaxHeaderHerght) {
							mHeaderContainer
									.setLayoutParams(localLayoutParams);
							mHeaderRealHeight = localLayoutParams.height;
						}
						mLastMotionY = ev.getY(j);

//						Log.e(TAG, "mMaxScale:" + mMaxScale + ", mLastScale:" + mLastScale);
//						Log.e(TAG, "f:" + f + ", localLayoutParams.height:" + localLayoutParams.height);
//						Log.e(TAG, "---------------------------------------------");
					}
					mLastMotionY = ev.getY(j);
				}
				break;
			case MotionEvent.ACTION_UP:
				reset();
				endScraling();
				break;
			case MotionEvent.ACTION_CANCEL:

				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				int i = ev.getActionIndex();
				mLastMotionY = ev.getY(i);
				mActivePointerId = ev.getPointerId(i);
				break;
			case MotionEvent.ACTION_POINTER_UP:
				onSecondaryPointerUp(ev);
				mLastMotionY = ev.getY(ev
						.findPointerIndex(mActivePointerId));
				break;
		}
		return super.onTouchEvent(ev);
	}

	*/
/**
	 * 获取头部相对于屏幕的y轴底部坐标
	 * @return
	 *//*

	private int getHeaderBottom() {
		int[] location = new int[2];
		mHeaderContainer.getLocationInWindow(location);
		int y = location[1];
		return y + mHeaderRealHeight;
	}

	public void setHeaderViewSize(int paramInt1, int paramInt2) {
		if (!mShowHeaderImage) {
			return;
		}
		Object localObject = mHeaderContainer.getLayoutParams();
		if (localObject == null)
			localObject = new ViewGroup.LayoutParams(paramInt1, paramInt2);
		((ViewGroup.LayoutParams) localObject).width = paramInt1;
		((ViewGroup.LayoutParams) localObject).height = paramInt2;
		mHeaderContainer
				.setLayoutParams((ViewGroup.LayoutParams) localObject);
	}

	public void setScrollable(boolean paramBoolean) {
		if (!mShowHeaderImage) {
			return;
		}
		mScrollable = paramBoolean;
	}

	public void setZoomable(boolean paramBoolean) {
		if (!mShowHeaderImage) {
			return;
		}
		mZoomable = paramBoolean;
	}

	class ScalingRunnalable implements Runnable {
		long mDuration;
		boolean mIsFinished = true;
		float mScale;
		long mStartTime;

		ScalingRunnalable() {
		}

		public void abortAnimation() {
			mIsFinished = true;
		}

		public boolean isFinished() {
			return mIsFinished;
		}

		public void run() {
			float f2;
			ViewGroup.LayoutParams localLayoutParams;
			if ((!mIsFinished) && (mScale > 1.0D)) {
				float f1 = ((float) SystemClock.currentThreadTimeMillis() - (float) mStartTime)
						/ (float) mDuration;
				f2 = mScale - (mScale - 1.0F)
						* PersonalCenterScrollView.sInterpolator.getInterpolation(f1);
				localLayoutParams = mHeaderContainer
						.getLayoutParams();
				if (f2 > 1.0F) {
//					Log.d("mmm", "f2>1.0");
					mHeaderRealHeight = localLayoutParams.height = ((int) (f2 * mHeaderHeight));
					mHeaderContainer
							.setLayoutParams(localLayoutParams);
					post(this);
					return;
				}
				mIsFinished = true;
			}
		}

		public void startAnimation(long paramLong) {
			mStartTime = SystemClock.currentThreadTimeMillis();
			mDuration = paramLong;
			mScale = ((float) (mHeaderContainer
					.getBottom()) / mHeaderHeight);
			mIsFinished = false;
			post(this);
		}
	}

	*/
/***************** sticky title bar *******************//*

	*/
/**
	 * 设置滚动接口
	 * @param listener
	 *//*

	public void setOnScrollListener(OnScrollListener listener) {
		onScrollListener = listener;
	}

	*/
/**
	 *
	 * 滚动的回调接口
	 *
	 * @author xiaanming
	 *
	 *//*

	public interface OnScrollListener{
		*/
/**
		 * 回调方法， 返回MyScrollView滑动的Y方向距离
		 * @param scrollY
		 *
		 *//*

		public void onScroll(int scrollY);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);

		if(onScrollListener != null){
			onScrollListener.onScroll(lastScrollY = t);
		}
	}
}
*/

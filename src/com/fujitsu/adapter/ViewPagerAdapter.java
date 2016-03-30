package com.fujitsu.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerAdapter extends PagerAdapter {
	List<Fragment> viewlists;

	public ViewPagerAdapter(List<Fragment> lists) {
		viewlists = lists;
	}

	@Override
	public int getCount() {
		return viewlists.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
//		((ViewPager) container).removeView(viewlists.get(position));
	}

	@Override
	public Object instantiateItem(View container, int position) {
//		((ViewPager) container).addView(viewlists.get(position), 0);
		return viewlists.get(position);
	}

}

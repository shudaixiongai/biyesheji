package com.fujitsu.school;

import com.fujitsu.school.R.layout;

import comfujitsu.fragment.DataFragment;
import comfujitsu.fragment.JpFramgent;
import comfujitsu.fragment.TestFragment;
import comfujitsu.fragment.TranslateFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends FragmentActivity implements OnClickListener {
	private Fragment translatefrFragment, testFragment, dataFragment,
			jpFragment;
	private static Fragment curreFragment;
	private TextView tv_translate, tv_test, tv_data, tv_jp;
	private ImageView iv_translate, iv_test, iv_data, iv_jp;
	private LinearLayout layout_translate, layout_test, layout_data, layout_jp;
	private ImageView left;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragmentllist);
		initview();
		intttab();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		setIntent(intent);
	}

	private void initview() {
		tv_translate = (TextView) findViewById(R.id.tv_translate);
		tv_test = (TextView) findViewById(R.id.tv_test);
		tv_data = (TextView) findViewById(R.id.tv_data);
		tv_jp = (TextView) findViewById(R.id.tv_jp);
		iv_translate = (ImageView) findViewById(R.id.iv_translate);
		iv_test = (ImageView) findViewById(R.id.iv_test);
		iv_data = (ImageView) findViewById(R.id.iv_data);
		iv_jp = (ImageView) findViewById(R.id.iv_jp);
		layout_translate = (LinearLayout) findViewById(R.id.fragment_translate);
		layout_test = (LinearLayout) findViewById(R.id.jiaming_test);
		layout_data = (LinearLayout) findViewById(R.id.jiaming_data);
		layout_jp = (LinearLayout) findViewById(R.id.jp_culture);
		left = (ImageView) findViewById(R.id.left);
		title = (TextView) findViewById(R.id.title);
		layout_translate.setOnClickListener(this);
		layout_jp.setOnClickListener(this);
		layout_data.setOnClickListener(this);
		layout_test.setOnClickListener(this);
		left.setVisibility(View.GONE);
		title.setText("翻译");
	}

	private void intttab() {
		if (translatefrFragment == null) {
			translatefrFragment = new TranslateFragment();
		}
		if (!translatefrFragment.isAdded()) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment, translatefrFragment).commit();
			curreFragment = translatefrFragment;
			/*
			 * iv_translate.setImageResource(R.drawable.ic_menu_allfriends);
			 * tv_translate.setTextColor(getResources().getColor(
			 * R.color.abc_search_url_text_holo));
			 */
		}

	}

	private void clicktabtranlslate() {
		if (translatefrFragment == null) {
			translatefrFragment = new TranslateFragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(),
				translatefrFragment);
		iv_translate.setImageResource(R.drawable.ic_menu_allfriends);
		tv_translate.setTextColor(getResources().getColor(
				R.color.abc_search_url_text_holo));
		iv_test.setImageResource(R.drawable.ic_menu_emoticons);
		tv_test.setTextColor(Color.BLACK);
		iv_data.setImageResource(R.drawable.ic_menu_emoticons);
		tv_data.setTextColor(Color.BLACK);
		iv_jp.setImageResource(R.drawable.ic_menu_emoticons);
		tv_jp.setTextColor(Color.BLACK);
	}

	private void clicktest() {
		if (testFragment == null) {
			testFragment = new TestFragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(),
				testFragment);
		iv_test.setImageResource(R.drawable.ic_menu_allfriends);
		tv_test.setTextColor(getResources().getColor(
				R.color.abc_search_url_text_holo));
		iv_data.setImageResource(R.drawable.ic_menu_emoticons);
		tv_data.setTextColor(Color.BLACK);
		iv_translate.setImageResource(R.drawable.ic_menu_emoticons);
		tv_translate.setTextColor(Color.BLACK);
		iv_jp.setImageResource(R.drawable.ic_menu_emoticons);
		tv_jp.setTextColor(Color.BLACK);

	}

	private void clickdata() {
		if (dataFragment == null) {
			dataFragment = new DataFragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(),
				dataFragment);
		iv_data.setImageResource(R.drawable.ic_menu_allfriends);
		tv_data.setTextColor(getResources().getColor(
				R.color.abc_search_url_text_holo));
		iv_test.setImageResource(R.drawable.ic_menu_emoticons);
		tv_test.setTextColor(Color.BLACK);
		iv_translate.setImageResource(R.drawable.ic_menu_emoticons);
		tv_translate.setTextColor(Color.BLACK);
		iv_jp.setImageResource(R.drawable.ic_menu_emoticons);
		tv_jp.setTextColor(Color.BLACK);
	}

	private void clickjp() {
		if (jpFragment == null) {
			jpFragment = new JpFramgent();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(),
				jpFragment);
		iv_jp.setImageResource(R.drawable.ic_menu_allfriends);
		tv_jp.setTextColor(getResources().getColor(
				R.color.abc_search_url_text_holo));
		iv_data.setImageResource(R.drawable.ic_menu_emoticons);
		tv_data.setTextColor(Color.BLACK);
		iv_translate.setImageResource(R.drawable.ic_menu_emoticons);
		tv_translate.setTextColor(Color.BLACK);
		iv_test.setImageResource(R.drawable.ic_menu_emoticons);
		tv_test.setTextColor(Color.BLACK);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fragment_translate:
			clicktabtranlslate();
			title.setText("翻译");
			break;
		case R.id.jiaming_test:
			clicktest();
			title.setText("假名测验");
			break;
		case R.id.jiaming_data:
			clickdata();
			title.setText("日常假名");
			break;
		case R.id.jp_culture:
			clickjp();
			title.setText("50音图");
			break;
		}
	}

	public static void addOrShowFragment(
			android.support.v4.app.FragmentTransaction fragmentTransaction,
			Fragment fragment) {
		if (curreFragment == fragment)
			return;

		if (!fragment.isAdded()) {
			fragmentTransaction.hide(curreFragment)
					.add(R.id.fragment, fragment).show(fragment).commit();
			Log.v("you", "没有被添加上去");

		} else {
			fragmentTransaction.hide(curreFragment).show(fragment).commit();
			Log.v("you", "被添加上去");
		}
		curreFragment = fragment;

	}
}

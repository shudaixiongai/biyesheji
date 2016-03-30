package comfujitsu.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.fujitsu.adapter.ViewPagerAdapter;
import com.fujitsu.school.R;

public class PingFragment extends Fragment {
	private TextView textview1, textview2, textview3;
	private ViewPager viewPager;
	private ImageView imagerview;
	private List<View> lists = new ArrayList<View>();
	private Bitmap cursor;
	private ViewPagerAdapter adapter;
	private int currentItem;
	private Animation animation;
	private int offSet;
	private Context context;
	private Matrix matrix = new Matrix();
	private int bmWidth;
	private GridView gridView;
	private List<Fragment> fragments;
	private List<Map<String, Object>> datalist;
	private Ping_one_Fragment ping_one_Fragment;
	private Ping_two_Fragment ping_two_Fragment;
	private Ping_three_Fragment ping_three_Fragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.ping_fragment, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setview();
	}

	private void setview() {
		imagerview = (ImageView) getActivity().findViewById(R.id.ping_cursor);
		textview1 = (TextView) getActivity().findViewById(R.id.ping_textview1);
		textview2 = (TextView) getActivity().findViewById(R.id.ping_textview2);
		textview3 = (TextView) getActivity().findViewById(R.id.ping_textview3);
		fragments = new ArrayList<Fragment>();
		ping_one_Fragment = new Ping_one_Fragment();
		ping_two_Fragment = new Ping_two_Fragment();
		ping_three_Fragment = new Ping_three_Fragment();
		fragments.add(ping_one_Fragment);
		fragments.add(ping_two_Fragment);
		fragments.add(ping_three_Fragment);
		initeCursor();
		// adapter = new ViewPagerAdapter(fragments);
		viewPager = (ViewPager) getActivity().findViewById(R.id.ping_viewPager);
		viewPager.setAdapter(new myadapter(getActivity()
				.getSupportFragmentManager()));

		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					if (currentItem == 1) {
						animation = new TranslateAnimation(
								offSet * 2 + bmWidth, 0, 0, 0);
					} else if (currentItem == 2) {
						animation = new TranslateAnimation(offSet * 4 + 2
								* bmWidth, 0, 0, 0);
					}
					break;

				case 1:
					if (currentItem == 0) {
						animation = new TranslateAnimation(0, offSet * 2
								+ bmWidth, 0, 0);
					} else if (currentItem == 2) {
						animation = new TranslateAnimation(4 * offSet + 2
								* bmWidth, offSet * 2 + bmWidth, 0, 0);
					}
					break;
				case 2:
					if (currentItem == 0) {
						animation = new TranslateAnimation(0, 4 * offSet + 2
								* bmWidth, 0, 0);
					} else if (currentItem == 1) {
						animation = new TranslateAnimation(
								offSet * 2 + bmWidth, 4 * offSet + 2 * bmWidth,
								0, 0);
					}
				}
				currentItem = arg0;
				animation.setDuration(150);
				animation.setFillAfter(true);
				imagerview.startAnimation(animation);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		textview1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				viewPager.setCurrentItem(0);

			}
		});
		textview2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				viewPager.setCurrentItem(1);

			}
		});
		textview3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				viewPager.setCurrentItem(2);

			}
		});

	}

	private class myadapter extends FragmentPagerAdapter {

		public myadapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fragments.size();
		}

	}

	private void initeCursor() {
		cursor = BitmapFactory.decodeResource(getResources(), R.drawable.next);
		bmWidth = cursor.getWidth();
		DisplayMetrics dm = getResources().getDisplayMetrics();
		offSet = (dm.widthPixels - 3 * bmWidth) / 6;
		matrix.setTranslate(offSet, 0);
		imagerview.setImageMatrix(matrix);
		currentItem = 0;
	}
}

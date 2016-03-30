package comfujitsu.fragment;

import com.fujitsu.school.R;

import android.app.ActionBar.Tab;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class Fragmentlist extends Fragment {
	private Context mContext;
	private ListView listview, dataList, weekList;
	private static String mdatatitle[] = { "ついたち", "ふつか", "みっか", "よっか", "いつか",
			"むいか", "なのか", "ようか", "ここのか", "とおか", "じゅういちにち", "じゅうににち", "じゅうさんにち",
			"じゅうよっか", "じゅうごにち", "じゅうろくにち", "じゅうしちにち", "じゅうはちにち", "じゅうきゅうにち",
			"はつか", "にじゅういちにち", "にじゅうににち" };
	private static String mdataname[] = { "一日", "二日", "三日", "四日", "五日", "六日",
			"七日", "八日", "九日", "十日", "十一日", "十二日", "十三日", "十四日", "十五日", "十六日",
			"十七日", "十八日", "十九日", "二十日", "二十一日", "二十二日" };

	private static String mdataonth[] = { "1st ", "2st ", "3st", "4st", "5st",
			"6st", "7st", "8st", "9st", "10st", "11st", "12st", "13st", "14st",
			"15st", "16st", "17st", "18st", "19st", "20st", "21st", "22st" };

	private static String mlisttitle[] = { "いちがつ", "にがつ", "さんがつ", "しがつ", "ごがつ",
			"ろくがつ", "しちがつ", "はちがつ", "くがつ", "じゅうがつ", "じゅういちがつ", "じゅうにがつ", };
	private static String mname[] = { "一月", "二月", "三月", "四月", "五月", "六月", "七月",
			"八月", "九月", "十月", "十一月", "十二月" };
	private static String month[] = { "January ", "February ", "March",
			"April", "May", "June", "July", "August", "September", "October",
			"November", "December" };
	private static String mweektitle[] = { "げつようび", "かようび", "すいようび", "もくようび",
			"きんようび", "どようび", "にちようび", "なんようび" };
	private static String mweekname[] = { "月曜日", "火曜日", "水曜日", "木曜日", "金曜日",
			"土曜日", "日曜日", "何曜日" };
	private static String week[] = { "Monday ", "Tuesday ", "Wednesday",
			"Thursday", "Friday", "Saturday", "Sunday", "What day is it?", };
	private ImageView tv_returnImageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.data_list, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setview();
	}

	private void setview() {
		listview = (ListView) getActivity().findViewById(R.id.tab1_list);
		listview.setAdapter(new adapter());
		dataList = (ListView) getActivity().findViewById(R.id.tab2_list);
		dataList.setAdapter(new datadapter());
		weekList = (ListView) getActivity().findViewById(R.id.week_list);
		weekList.setAdapter(new weekadapter());
		tv_returnImageView = (ImageView) getActivity().findViewById(R.id.left);
		TabHost tabHost = (TabHost) getActivity().findViewById(R.id.tabhost);
		tabHost.setup();
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Month")
				.setContent(R.id.tab1));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Data", null)
				.setContent(R.id.tab2));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("week", null)
				.setContent(R.id.tab3));
		tv_returnImageView.setVisibility(View.VISIBLE);
		tv_returnImageView.setOnClickListener(new clin());
	}

	class clin implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			getActivity().getFragmentManager().popBackStack();
		}

	}

	class weekadapter extends BaseAdapter {
		public LayoutInflater inflater;

		public weekadapter() {
			inflater = (LayoutInflater) getActivity().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return mweekname.length;
		}

		@Override
		public Object getItem(int arg0) {
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ViewHolder holder;
			if (arg1 == null) {
				holder = new ViewHolder();
				arg1 = inflater.inflate(R.layout.week_item, null);
				holder.title = (TextView) arg1.findViewById(R.id.tv_week_one);
				holder.name = (TextView) arg1.findViewById(R.id.tv_week_two);
				holder.month = (TextView) arg1.findViewById(R.id.tv_week_three);
				arg1.setTag(holder);
			} else
				holder = (ViewHolder) arg1.getTag();
			holder.title.setText(mweektitle[arg0]);
			holder.name.setText(mweekname[arg0]);
			holder.month.setText(week[arg0]);

			return arg1;
		}
	}

	class datadapter extends BaseAdapter {
		public LayoutInflater mInflater;

		public datadapter() {
			mInflater = (LayoutInflater) getActivity().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return mdataname.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ViewHolder holder;
			if (arg1 == null) {
				holder = new ViewHolder();
				arg1 = mInflater.inflate(R.layout.month_list_item, null);
				holder.title = (TextView) arg1.findViewById(R.id.mont_title);
				holder.name = (TextView) arg1.findViewById(R.id.month_name);
				holder.month = (TextView) arg1.findViewById(R.id.month_month);
				arg1.setTag(holder);
			} else
				holder = (ViewHolder) arg1.getTag();
			holder.title.setText(mdatatitle[arg0]);
			holder.name.setText(mdataname[arg0]);
			holder.month.setText(mdataonth[arg0]);
			return arg1;
		}

	}

	class adapter extends BaseAdapter {
		public LayoutInflater mInflater;

		public adapter() {
			mInflater = (LayoutInflater) getActivity().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ViewHolder holder;
			if (arg1 == null) {
				holder = new ViewHolder();
				arg1 = mInflater.inflate(R.layout.data_list_item, null);
				holder.title = (TextView) arg1.findViewById(R.id.title);
				holder.name = (TextView) arg1.findViewById(R.id.name);
				holder.month = (TextView) arg1.findViewById(R.id.item_month);
				arg1.setTag(holder);
			} else
				holder = (ViewHolder) arg1.getTag();
			holder.title.setText(mlisttitle[arg0]);
			holder.name.setText(mname[arg0]);
			holder.month.setText(month[arg0]);
			return arg1;
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public Object getItem(int arg0) {
			return arg0;
		}

		@Override
		public int getCount() {
			return mname.length;
		}
	};

	public class ViewHolder {
		public TextView title;
		public TextView name;
		public TextView month;

	}

}

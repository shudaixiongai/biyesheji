package comfujitsu.fragment;

import com.fujitsu.school.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TimeFragment extends Fragment {
	private ListView timelist;
	// private static String mdatatitle[] = { "いちじいっぷん", "にじにふん", "さんじ さんぷん  ",
	// "よじよんぷん ", "ごじごふん ", "ろくじろっぷん ", "しちじななふん  ", "はちじはっぷん",
	// " くじきゅうふん", "じゅうじじっぷん ", "じゅういちじじゅういっぷん ", "じゅうにじじゅうにふん " };
	// private static String mdataname[] = { "一时一分", "二时二分", "三时三分", "四时四分",
	// "五时五分", "六时六分", "七时七分", "八时八分", "九时九分", "十时十分", "十一时十一分", "十二十二分" };
	//
	// private static String mdataonth[] = { "01:01", "02:02", "03:03", "04:04",
	// "05:05", "06:06", "07:07", "08:08", "09:09", "10:10", "11:11",
	// "12:12" };
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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.timefragmentlist, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		timesetview();
	}

	private void timesetview() {
		timelist = (ListView) getActivity().findViewById(R.id.time_listview);
		timelist.setAdapter(new timeadapter());
	}

	class timeadapter extends BaseAdapter {
		LayoutInflater inflater;

		public timeadapter() {
			inflater = (LayoutInflater) getActivity().getSystemService(
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
			ViewHolder holder = null;
			if (arg1 == null) {
				holder = new ViewHolder();
				arg1 = inflater.inflate(R.layout.time_list_item, null);
				holder.title = (TextView) arg1.findViewById(R.id.lv_time_title);
				holder.name = (TextView) arg1.findViewById(R.id.lv_time_name);
				holder.month = (TextView) arg1
						.findViewById(R.id.lv_time_content);
				arg1.setTag(holder);
			} else
				holder = (ViewHolder) arg1.getTag();
			holder.title.setText(mdatatitle[arg0]);
			holder.name.setText(mdataname[arg0]);
			holder.month.setText(mdataonth[arg0]);

			return arg1;
		}
	}

	public class ViewHolder {
		public TextView title;
		public TextView name;
		public TextView month;

	}
}

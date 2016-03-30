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

public class NumberFragment extends Fragment {
	private static String mnumberitle[] = { "1", "2 ", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "100", "1,000", "10,000", "100,000,000" };
	private static String mnumbername[] = { "1", "2 ", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "100", "1,000", "10,000", "100,000,000" };

	private static String mnumberonth[] = { "1", "2 ", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "100", "1,000", "10,000", "100,000,000" };

	private ListView listview;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.numberfragmentlist, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setview();
	}

	private void setview() {
		listview = (ListView) getActivity().findViewById(R.id.number_listview);
		listview.setAdapter(new numberadapter());

	}

	class numberadapter extends BaseAdapter {
		LayoutInflater inflater;

		public numberadapter() {
			inflater = (LayoutInflater) getActivity().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return mnumbername.length;
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
				arg1 = inflater.inflate(R.layout.number_list_item, null);
				holder.title = (TextView) arg1
						.findViewById(R.id.lv_number_title);
				holder.name = (TextView) arg1.findViewById(R.id.lv_number_name);
				holder.week = (TextView) arg1
						.findViewById(R.id.lv_content_name);
				arg1.setTag(holder);
			} else
				holder = (ViewHolder) arg1.getTag();
			holder.title.setText(mnumberitle[arg0]);
			holder.name.setText(mnumbername[arg0]);
			holder.week.setText(mnumberonth[arg0]);
			return arg1;
		}
	}

	public class ViewHolder {
		public TextView title;
		public TextView name;
		public TextView week;
	}
}

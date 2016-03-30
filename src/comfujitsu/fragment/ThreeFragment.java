package comfujitsu.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fujitsu.school.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class ThreeFragment extends Fragment {
	private Context context;
	private GridView gridView;
	private List<Map<String, Object>> datalist;
	private String[] iconName = { "きゃ", "きゅ", "きょ", "しゃ", "しゅ", "しょ", "ちゃ",
			"ちゅ", "ちょ", "にゃ", "にゅ", "にょ", "ひゃ", "ひゅ", "ひょ", "みゃ", "みゅ", "みょ",
			"りゃ", "りゅ", "りょ", "ぎゃ", "ぎゅ", "ぎょ", "じゃ", "じゅ", "じょ", "びゃ", "びゅ",
			"びょ", "ぴゃ", "ぴゅ", "ぴょ", };
	private String[] iconName2 = { "kya", "kyu", "kyo", "sha", "shu", "sho", "cha",
			"chyu", "cho", "nya", "nyu", "nyo", "hya", "hyu", "hyo", "mya", "myu", "myo",
			"rya", "ryu", "ryo", "gya", "gyu", "gyo", "ja", "ju", "jo", "bya", "byu",
			"byo", "pya", "pyu", "pyo",};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.viewpager3, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setgirdview();
	}

	private void setgirdview() {
		gridView = (GridView) getActivity().findViewById(R.id.gridView3);
		datalist = new ArrayList<Map<String, Object>>();
		getdata();
		String[] form = { "big", "small" };
		int[] to = { R.id.big, R.id.small };
		SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),
				datalist, R.layout.girdview_item, form, to);
		gridView.setAdapter(simpleAdapter);
	}

	private List<Map<String, Object>> getdata() {
		for (int i = 0; i < iconName.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("big", iconName[i]);
			map.put("small", iconName2[i]);
			datalist.add(map);
		}
		return datalist;
	}

}

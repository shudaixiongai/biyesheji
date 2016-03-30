package comfujitsu.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.fujitsu.school.R;

public class Ping_one_Fragment extends Fragment {
	private Context context;
	private GridView gridView;
	private List<Map<String, Object>> datalist;
	private String[] iconName = { "ア", "イ", "ウ", "ェ", "オ", "カ", "キ", "ク", "ケ",
			"コ", "サ", "シ", "ス", "セ", "ソ", "タ", "チ", "ツ", "テ", "ト", "ナ", "二",
			"ヌ", "ネ", "ノ", "ハ", "ヒ", "フ", "ヘ", "ホ", "マ", "ミ", "ム", "メ", "モ",
			"ヤ", "　", "ユ", "　", "ヨ", "ラ", "リ", "ル", "レ", "ロ", "ワ", "　", "　",
			"　", "ヲ", "ン", };
	private String[] iconName2 = { "a", "i", "u", "e", "o", "ka", "ki", "ku",
			"ke", "ko", "sa", "shi", "su", "se", "so", "ta", "chi", "tsu",
			"te", "to", "na", "ni", "nu", "ne", "no", "ha", "hi", "fu", "he",
			"ho", "ma", "mi", "mu", "me", "mo", "ya", "　", "yu", "　", "yo",
			"ra", "ri", "ru", "re", "ro", "wa", "　", "　", "　", "wo", "n", };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.ping_viewpager, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setgirdview();
	}

	private void setgirdview() {
		gridView = (GridView) getActivity().findViewById(R.id.ping_gridView);
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

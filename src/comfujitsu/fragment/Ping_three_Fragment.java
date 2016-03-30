package comfujitsu.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.fujitsu.school.R;

public class Ping_three_Fragment extends Fragment {
	private Context context;
	private GridView gridView;
	private List<Map<String, Object>> datalist;
	private String[] iconName = { "キャ", "キュ", "キョ", "シャ", "シュ", "ショ", "チャ",
			"チュ", "チョ", "ニャ", "ニュ", "ニョ", "ヒャ", "ヒュ", "ヒョ", "ミャ", "ミュ",
			"ミョ", "リャ", "リュ", "リョ", "ギャ", "ギュ", "ギョ", "ジャ", "ジュ", "ジョ", "ビャ",
			"ビュ", "ビョ", "ピャ", "ビュ", "ビョ", };
	private String[] iconName2 = { "kya", "kyu", "kyo", "sha", "shu", "sho",
			"cha", "chu", "cho", "nya", "nyu", "nyo", "hya", "hyu", "hyo",
			"mya", "myu", "myo", "rya", "ryu", "ryo", "gya", "gyu", "gyo",
			"ja", "ju", "jo", "bya", "byu", "byo", "pya", "pyu", "pyo", };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.ping_viewpagerthree, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setgirdview();
	}

	private void setgirdview() {
		gridView = (GridView) getActivity().findViewById(
				R.id.ping_gridView_three);
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

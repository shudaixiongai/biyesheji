package comfujitsu.fragment;

import com.fujitsu.school.MainActivity;
import com.fujitsu.school.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DataFragment extends Fragment implements OnClickListener {
	private RelativeLayout rl_number, rl_data, rl_time;
	public Fragment fragmentlist, numberFragment, timeFragment;
	private LinearLayout linearLayout;
	FragmentTransaction ft;
	DataFragment dataFragment;
	private ImageView iv_return;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.data, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setview();
	}

	private void setview() {
		rl_number = (RelativeLayout) getActivity().findViewById(R.id.rl_number);
		rl_data = (RelativeLayout) getActivity().findViewById(R.id.rl_data);
		rl_time = (RelativeLayout) getActivity().findViewById(R.id.rl_time);
		linearLayout = (LinearLayout) getActivity().findViewById(R.id.data_lin);
		rl_data.setOnClickListener(this);
		rl_number.setOnClickListener(this);
		rl_time.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_data:
			if (fragmentlist == null) {
				fragmentlist = new Fragmentlist();
			}
			MainActivity.addOrShowFragment(getFragmentManager()
					.beginTransaction(), fragmentlist);
			break;
		case R.id.rl_number:
			if (numberFragment == null) {
				numberFragment = new NumberFragment();
			}
			MainActivity.addOrShowFragment(getFragmentManager()
					.beginTransaction(), numberFragment);
			break;
		case R.id.rl_time:
			if (timeFragment == null) {
				timeFragment = new TimeFragment();
			}
			MainActivity.addOrShowFragment(getFragmentManager()
					.beginTransaction(), timeFragment);
			break;
		}

	}
}

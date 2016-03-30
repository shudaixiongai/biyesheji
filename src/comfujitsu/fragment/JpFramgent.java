package comfujitsu.fragment;

import com.fujitsu.school.MainActivity;
import com.fujitsu.school.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class JpFramgent extends Fragment {
	private Button ping;
	private Button pian;
	private Fragment pianFragment, pingFragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.jp, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setview();
	}

	private void setview() {
		ping = (Button) getActivity().findViewById(R.id.tv_ping);
		pian = (Button) getActivity().findViewById(R.id.tv_pian);
		pian.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (pianFragment == null) {
					pianFragment = new PianFragment();
				}
				MainActivity.addOrShowFragment(getFragmentManager()
						.beginTransaction(), pianFragment);

			}
		});
		ping.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (pingFragment == null) {
					pingFragment = new PingFragment();
				}
				MainActivity.addOrShowFragment(getFragmentManager()
						.beginTransaction(), pingFragment);
			}
		});
	}
}

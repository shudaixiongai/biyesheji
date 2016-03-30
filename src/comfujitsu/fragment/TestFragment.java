package comfujitsu.fragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fujitsu.school.MainActivity;
import com.fujitsu.school.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TestFragment extends Fragment {
	private ListView listview;
	private Fragment questionFragment;
	private TextView tv_easy, tv_normal, tv_hard;
	private Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.test, container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		init();
	}

	private void init() {
		String DB_PATH = "/data/data/com.fujitsu.school/databases/";
		String DB_NAME = "question.db";
		// 判断数据库是否存在，如果不存在就创建这个数据库目录；
		if (new File(DB_PATH + DB_NAME).exists() == false) {
			File dir = new File(DB_PATH);
			if (!dir.exists()) {
				dir.mkdir();
			}
		}
		try {
			InputStream is = getActivity().getBaseContext().getAssets()
					.open(DB_NAME);
			OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			os.flush();
			is.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tv_easy = (TextView) getActivity().findViewById(R.id.tv_easy);
		tv_easy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (questionFragment == null) {
					questionFragment = new QuestionFragment();
				}
				MainActivity.addOrShowFragment(getFragmentManager()
						.beginTransaction(), questionFragment);
			}
		});
		tv_hard = (TextView) getActivity().findViewById(R.id.tv_hard);
		tv_hard.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(context, "1", 1).show();
			}
		});
		tv_normal = (TextView) getActivity().findViewById(R.id.tv_normal);
		tv_normal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(context, "2", 1).show();

			}
		});
	}

}

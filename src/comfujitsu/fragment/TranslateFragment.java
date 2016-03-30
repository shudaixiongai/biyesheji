package comfujitsu.fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.RuleBasedCollator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fujitsu.school.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TranslateFragment extends Fragment implements OnClickListener {
	private String baiduurl = "http://api.fanyi.baidu.com/api/trans/vip/translate?";
	private String client_id = "20150630000000001";
	private String appidString = "YTOVYgwhNZU6xI4dIhyG";
	private EditText et_from;
	private TextView tv_to;
	private Button button;
	private String Youdaourl = "http://fanyi.youdao.com/openapi.do?";
	private String Youdaokey = "1669567238";
	private String youdaokeyfrom = "shudaixiong1";
	private String youdaotype = "data";
	private String youdaodatatype = "json";
	private String youdaoversionString = "1.1";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.translate, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initview();
	}

	private void initview() {
		et_from = (EditText) getActivity().findViewById(R.id.et_from);
		tv_to = (TextView) getActivity().findViewById(R.id.et_to);
		button = (Button) getActivity().findViewById(R.id.btn_dianji);
		button.setOnClickListener(this);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				String word = msg.getData().getString("word");
				Log.v("3", word);
				tv_to.setText(word);
				break;
			default:
				break;
			}
		};
	};

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn_dianji:
			tranThread();
			break;
		}
	}

	private void transento() {
		String put = et_from.getText().toString();
		try {

			URL url = new URL(baiduurl + "q=" + put + "&from=en" + "&to=zh"
					+ "&" + appidString + "&salt=1435660288" + "&"
					+ "sing=f89f9594663708c1605f3d736d01d2d4");
			// http://api.fanyi.baidu.com/api/trans/vip/translate?q=a
			// pple&from=en&to=zh&appid=2015063000000001&salt=1435660288&
			// sign=f89f9594663708c1605f3d736d01d2d4
			put = URLEncoder.encode(put, "UTF-8");
			System.out.println("url" + url);
			URLConnection con = url.openConnection();
			con.connect();
			InputStreamReader reader = new InputStreamReader(
					con.getInputStream());
			BufferedReader buffer = new BufferedReader(reader);
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = buffer.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("sb+" + sb);
			String back = new String(sb.toString().getBytes("ISO-8859-1"),
					"UTF-8");
			String str = jsontostring(back);
			Log.i("1", back);
			Message message = new Message();
			message.what = 0;
			Bundle bundle = new Bundle();
			bundle.putString("word", str);
			message.setData(bundle);
			handler.sendMessage(message);
			reader.close();
			buffer.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String jsontostring(String jsString) {
		try {
			JSONObject joJsonObject = new JSONObject();

			JSONArray ja = new JSONArray("trans_result");
			joJsonObject = ja.getJSONObject(0);
			String word = joJsonObject.getString("dst");
			return word;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

	private void tranThread() {
		new Thread() {
			public void run() {
				transento();
				Log.i("2", "111");
			};

		}.start();

	}
}

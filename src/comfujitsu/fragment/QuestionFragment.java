package comfujitsu.fragment;

import java.util.ArrayList;
import java.util.List;

import com.fujitsu.been.Question;
import com.fujitsu.db.DBservice;
import com.fujitsu.school.R;

import android.R.integer;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class QuestionFragment extends Fragment {
	private int count;
	private int current;
	private TextView tv_questionTextView;
	private RadioButton[] buttons;
	private TextView tv_explaination;
	private RadioGroup radioGroup;
	private List<Question> lists;
	private Context context;
	// 错题标志变量
	private boolean wrongMode;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.test_question, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setview();
	}

	private void setview() {
		DBservice dBservice = new DBservice();
		lists = dBservice.getQuestion();
		// 题目总数
		count = lists.size();
		// 当前题目
		current = 0;
		tv_questionTextView = (TextView) getActivity().findViewById(
				R.id.question);
		buttons = new RadioButton[4];
		buttons[0] = (RadioButton) getActivity().findViewById(R.id.answerA);
		buttons[1] = (RadioButton) getActivity().findViewById(R.id.answerB);
		buttons[2] = (RadioButton) getActivity().findViewById(R.id.answerC);
		buttons[3] = (RadioButton) getActivity().findViewById(R.id.answerD);
		Button btn_next = (Button) getActivity().findViewById(R.id.btn_boom);
		Button btn_previous = (Button) getActivity().findViewById(R.id.btn_top);
		tv_explaination = (TextView) getActivity().findViewById(
				R.id.explaination);
		radioGroup = (RadioGroup) getActivity().findViewById(R.id.gadiogroup);
		Question question = lists.get(0);
		tv_questionTextView.setText(question.question);
		buttons[0].setText(question.answerA);
		buttons[1].setText(question.answerB);
		buttons[2].setText(question.answerC);
		buttons[3].setText(question.answerD);
		tv_explaination.setText(question.explaination);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (current < count - 1) {
					current++;
					Question q = lists.get(current);
					tv_questionTextView.setText(q.question);
					buttons[0].setText(q.answerA);
					buttons[1].setText(q.answerB);
					buttons[2].setText(q.answerC);
					buttons[3].setText(q.answerD);
					tv_explaination.setText(q.explaination);
					radioGroup.clearCheck();
					if (q.selectedAnswer != -1) {
						buttons[q.selectedAnswer].setChecked(true);
					}
				} else if (wrongMode) {
					new AlertDialog.Builder(getActivity())
							.setTitle("提示")
							.setMessage("已经到达最后一题，是否退出?")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface arg0, int arg1) {
											getActivity()
													.getSupportFragmentManager()
													.popBackStack();
										}
									}).setNegativeButton("取消", null).show();
				}

				else {
					final List<Integer> wronglist = checkAnswer(lists);
					if (wronglist.size() == 0) {
						new AlertDialog.Builder(context)
								.setTitle("提示")
								.setMessage("恭喜，你已经全部答对了所有题目")
								.setNegativeButton("取消",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface arg0,
													int arg1) {
												getActivity()
														.getSupportFragmentManager()
														.popBackStack();
											}
										}).show();
					}
					new AlertDialog.Builder(getActivity())
							.setTitle("提示")
							.setMessage(
									"你答对了" + (lists.size() - wronglist.size())
											+ "道题目,你答错了" + wronglist.size()
											+ "道题目")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface arg0, int arg1) {
											wrongMode = true;
											List<Question> newlist = new ArrayList<Question>();
											for (int i = 0; i < wronglist
													.size(); i++) {
												newlist.add(lists.get(wronglist
														.get(i)));
											}
											lists.clear();
											for (int j = 0; j < newlist.size(); j++) {
												lists.add(newlist.get(j));
											}
											current = 0;
											count = lists.size();
											Question q = lists.get(current);
											tv_questionTextView
													.setText(q.question);
											buttons[0].setText(q.answerA);
											buttons[1].setText(q.answerB);
											buttons[2].setText(q.answerC);
											buttons[3].setText(q.answerD);
											tv_explaination
													.setText(q.explaination);
											tv_explaination
													.setVisibility(View.VISIBLE);
										}
									})
							.setNegativeButton("取消",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface arg0, int arg1) {
											getActivity()
													.getSupportFragmentManager()
													.popBackStack();
										}
									}).show();
				}

			}
		});
		btn_previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (current > 0) {
					current--;
					Question q = lists.get(current);
					tv_questionTextView.setText(q.question);
					buttons[0].setText(q.answerA);
					buttons[1].setText(q.answerB);
					buttons[2].setText(q.answerC);
					buttons[3].setText(q.answerD);
					tv_questionTextView.setText(q.explaination);
					radioGroup.clearCheck();
					if (q.selectedAnswer != -1) {
						buttons[q.selectedAnswer].setChecked(true);
					}
				}
			}
		});
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				for (int i = 0; i < 4; i++) {
					if (buttons[i].isChecked() == true) {
						lists.get(current).selectedAnswer = i;
						break;
					}
				}
			}
		});
	}

	private List<Integer> checkAnswer(List<Question> list) {
		List<Integer> wrongList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).answer != list.get(i).selectedAnswer) {
				wrongList.add(i);
			}

		}
		return wrongList;

	}
}

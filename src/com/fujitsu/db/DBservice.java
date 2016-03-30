package com.fujitsu.db;

import java.util.ArrayList;
import java.util.List;

import com.fujitsu.been.Question;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBservice {
	private SQLiteDatabase db;

	public DBservice() {
		// 打开数据库
		db = SQLiteDatabase.openDatabase(
				"/data/data/com.fujitsu.school/databases/question.db", null,
				SQLiteDatabase.OPEN_READWRITE);
	}

	public List<Question> getQuestion() {
		List<Question> lists = new ArrayList<Question>();
		Cursor cursor = db.rawQuery("select * from question", null);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			int count = cursor.getCount();
			for (int i = 0; i < count; i++) {
				cursor.moveToPosition(i);
				Question question = new Question();
				question.ID = cursor.getInt(cursor.getColumnIndex("ID"));
				question.question = cursor.getString(cursor
						.getColumnIndex("question"));
				question.answerA = cursor.getString(cursor
						.getColumnIndex("answerA"));
				question.answerB = cursor.getString(cursor
						.getColumnIndex("answerB"));
				question.answerC = cursor.getString(cursor
						.getColumnIndex("answerC"));
				question.answerD = cursor.getString(cursor
						.getColumnIndex("answerD"));
				question.answer = cursor
						.getInt(cursor.getColumnIndex("answer"));
				question.explaination = cursor.getString(cursor
						.getColumnIndex("explaination"));
				question.selectedAnswer = -1;
				lists.add(question);
			}
		}
		return lists;

	}
}

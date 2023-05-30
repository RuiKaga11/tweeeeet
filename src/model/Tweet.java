package model;

import java.io.Serializable;

//javabeans。ツイートを受け付けるプロパティ。
public class Tweet implements Serializable{
	private String tweet;
	public Tweet() {
		//お約束
	}
	public Tweet(String tweet) {
		//ツイート内容をここに代入、get->setからviewで受け取る。
		this.tweet = tweet;
	}
	//ゲッターとセッター
	public String getTweet() {
		return tweet;
	}
//	public void setTweet(String tweet) {
//		this.tweet = tweet;
//	}

}

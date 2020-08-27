package kr.green.capsuleCloset.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodaysClothesVo {
	public int numToday;
	public String id;
	public int todaystop;
	public int todaysbottom;
	public int todaysouter;
	public int todaysshoes;
	public Date todaysDate;
	
	public int getNumToday() {
		return numToday;
	}
	public void setNumToday(int numToday) {
		this.numToday = numToday;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTodaystop() {
		return todaystop;
	}
	public void setTodaystop(int todaystop) {
		this.todaystop = todaystop;
	}
	public int getTodaysbottom() {
		return todaysbottom;
	}
	public void setTodaysbottom(int todaysbottom) {
		this.todaysbottom = todaysbottom;
	}
	public int getTodaysouter() {
		return todaysouter;
	}
	public void setTodaysouter(int todaysouter) {
		this.todaysouter = todaysouter;
	}
	public int getTodaysshoes() {
		return todaysshoes;
	}
	public void setTodaysshoes(int todaysshoes) {
		this.todaysshoes = todaysshoes;
	}
	public String getTodaysDate() {
		SimpleDateFormat transFormat = 
				new SimpleDateFormat("yyyy-MM-dd");
		String to = transFormat.format(todaysDate);

		return to;
	}
	public void setTodaysDate(String todaysDate) {
		SimpleDateFormat transFormat 
		= new SimpleDateFormat("yyyy-MM-dd");
	try {
		this.todaysDate = transFormat.parse(todaysDate);
	} catch (ParseException e) {
		e.printStackTrace();
	}

	}
	@Override
	public String toString() {
		return "TodaysClothesVo [numToday=" + numToday + ", id=" + id + ", todaystop=" + todaystop + ", todaysbottom="
				+ todaysbottom + ", todaysouter=" + todaysouter + ", todaysshoes=" + todaysshoes + ", todaysDate="
				+ todaysDate + "]";
	}
	
}
package kr.green.capsuleCloset.vo;

public class ClosetVo {
	public int closetNum;
	public int setGoal;
	public int top;
	public int bottom;
	public int outer;
	public int shoes;
	public String id;
	public String file;
	
	
	

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getClosetNum() {
		return closetNum;
	}

	public void setClosetNum(int closetNum) {
		this.closetNum = closetNum;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public int getOuter() {
		return outer;
	}

	public void setOuter(int outer) {
		this.outer = outer;
	}

	public int getShoes() {
		return shoes;
	}

	public void setShoes(int shoes) {
		this.shoes = shoes;
	}

	public int getSetGoal() {
		return setGoal;
	}

	public void setSetGoal(int setGoal) {
		this.setGoal = setGoal;
	}

	@Override
	public String toString() {
		return "ClosetVo [closetNum=" + closetNum + ", setGoal=" + setGoal + ", top=" + top + ", bottom=" + bottom
				+ ", outer=" + outer + ", shoes=" + shoes + ", id=" + id + ", file=" + file + "]";
	}

	

	
	
	
	
}

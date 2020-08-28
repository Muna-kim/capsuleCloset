package kr.green.capsuleCloset.vo;

public class FileVo {
	int fileTableNum;
	String id;
	String clothes;
	String file;
	String del;
	
	public int getFileTableNum() {
		return fileTableNum;
	}
	public void setFileTableNum(int fileTableNum) {
		this.fileTableNum = fileTableNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClothes() {
		return clothes;
	}
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "FileVo [fileTableNum=" + fileTableNum + ", id=" + id + ", clothes=" + clothes + ", file=" + file
				+ ", del=" + del + "]";
	}
	
	
	
}

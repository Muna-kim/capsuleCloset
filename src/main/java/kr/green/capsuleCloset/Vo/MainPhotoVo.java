package kr.green.capsuleCloset.vo;

public class MainPhotoVo {

		public String mainTop;
		public String mainBottom;
		public String mainOuter;
		public String mainShoes;
		public String id;
		
		
		
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getMainTop() {
			return mainTop;
		}


		public void setMainTop(String mainTop) {
			this.mainTop = mainTop;
		}


		public String getMainBottom() {
			return mainBottom;
		}


		public void setMainBottom(String mainBottom) {
			this.mainBottom = mainBottom;
		}


		public String getMainOuter() {
			return mainOuter;
		}


		public void setMainOuter(String mainOuter) {
			this.mainOuter = mainOuter;
		}


		public String getMainShoes() {
			return mainShoes;
		}


		public void setMainShoes(String mainShoes) {
			this.mainShoes = mainShoes;
		}


		@Override
		public String toString() {
			return "MainPhotoVo [mainTop=" + mainTop + ", mainBottom=" + mainBottom + ", mainOuter=" + mainOuter
					+ ", mainShoes=" + mainShoes + ", id=" + id + "]";
		}


		
		
}


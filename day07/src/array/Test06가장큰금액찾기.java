package array;

public class Test06가장큰금액찾기 {

	public static void main(String[] args) {
		
		/*
		int[] priceList = new int[] { 100000, 5000000, 2500000, 30000000, 50000 };
		int max = 0;
		
		int maxIndex = 0;
		int minIndex = 0;
		
		for (int i = 0; i < priceList.length; i++) {
			if (priceList[i] > max) {
				max = priceList[i];
				maxIndex = i;
			}
		}
		System.out.println(maxIndex);

		int min = max;
		for (int i = 0; i < priceList.length; i++) {
			if (priceList[i] < min) {
				min = priceList[i];
				minIndex = i;
			}
		}
		System.out.println(minIndex);
		*/
		
		
		//데이터 준비
		int[] dataList = new int[] {100000, 5000000, 2500000, 30000000, 50000};
		
		//[1] 가장 큰 금액의 위치(index)를 구하세요
		int max = 0;//0 지점이 가장 크다고 치자
		for(int i = 1; i < dataList.length; i++) {//1부터 마지막까지 반복하며
			if (dataList[max] < dataList[i]) {//더 큰 데이터가 나타난다면
				max = i;//max를 변경
			}
		}
		System.out.println("max = " + max);
		
		//[2] 가장 작은 금액의 위치(index)를 구하세요
		int min = 0;
		for(int i = 1; i < dataList.length; i++) {
			if (dataList[min] > dataList[i]) {
				min = i;
			}
		}
		System.out.println("min = " + min);
		
	}

}

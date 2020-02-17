
public class TopSpinPuzzleHeuristic
{
	public double getHeuristic (TopSpinPuzzleState problemState)
	{
		if (isSorted(problemState._TopSpinPuzzle,true))
			return 0;
		int count = 0;
		for (int i = 0; i < problemState._TopSpinPuzzle.length-1; i++) {
//			if(problemState._TopSpinPuzzle[i] != i) {
			if (problemState._TopSpinPuzzle[i]== 0 || problemState._TopSpinPuzzle[i+1]== 0) {
				if (problemState._TopSpinPuzzle[i] == 0 && (problemState._TopSpinPuzzle[i + 1] == 9 || problemState._TopSpinPuzzle[i + 1] == 1))
					count--;
				else if (problemState._TopSpinPuzzle[i + 1] == 0 && (problemState._TopSpinPuzzle[i] == 9 || problemState._TopSpinPuzzle[i] == 1))
					count--;
				count++;
			}
			else if (Math.abs(problemState._TopSpinPuzzle[i]-problemState._TopSpinPuzzle[i+1] )> 1)
				count++;

		}
		if ((Math.abs(problemState._TopSpinPuzzle[0]-problemState._TopSpinPuzzle[9] )> 1)
				&&(problemState._TopSpinPuzzle[0]!= 0)&&(problemState._TopSpinPuzzle[0]!= 0))
			count++;

//		int index3 = problemState._TopSpinPuzzle[3];
//		int index4 = problemState._TopSpinPuzzle[4];
//		int index5 = problemState._TopSpinPuzzle[5];
//		int index6 = problemState._TopSpinPuzzle[6];
//		int cost = 2;
//		//check if we need only 1 swapping (0,9 in the middle)
//		if (index3==0 && index4==9 && index5==8 && index6 ==7){
//			cost = cost+1;
//			if (count==2){
//				return cost;
//			}
//		}
//		if (index3==1 && index4==0 && index5==9 && index6 == 8){
//			cost = cost+1;
//			if (count==2){
//				return cost;
//			}
//		}
//		if (index3==2 && index4==1 && index5==0 && index6 ==9){
//			cost = cost+1;
//			if (count==2){
//				return cost;
//			}
//		}
//
//		if (problemState._TopSpinPuzzle[3]==problemState._TopSpinPuzzle[4]-1 && problemState._TopSpinPuzzle[4]==problemState._TopSpinPuzzle[5]-1
//				&&problemState._TopSpinPuzzle[5]==problemState._TopSpinPuzzle[6]-1){
//			cost = problemState._TopSpinPuzzle[3]+problemState._TopSpinPuzzle[4]+problemState._TopSpinPuzzle[5]+problemState._TopSpinPuzzle[6];
//			if (count==2){
//				return cost;
//			}
//		}

		return (count-1)*4;
	}

	private boolean isSorted(int[] array,boolean bool){
		int index = 0;
		if(bool) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == 0) {
					index = i;
					break;
				}
			}
		}
		for (int i = index; i <array.length -1 ; i++) {
			if (array[i] > array[i+1])
				return false;
		}
		for (int i = 0; i <index-1 ; i++) {
			if (array[i]<array[i+1])
				return false;
		}
		return true;
	}

}


//	private double sum (int[]array){
//		double count=0;
//		for (int i = 0; i <array.length ; i++)
//			count+=array[i];
//		return count;
//
//	}
//
//	private double getMinSwap(int [] array){
//		double min = 31;
//		int [] a = new int[4];
//
//		for (int i = 0; i <array.length - 4 ; i++) {
//			int j = 0;
//			a[j] = array[i];a[j+1] = array[i+1];a[j+2] = array[i+2];a[j+3] = array[i+3];
//			if(!isSorted(a,false)){
//				double s = sum(a);
//				if (s<min)
//					min =s;
//			}
//		}
//		return min;
//	}

//
//public class TopSpinPuzzleHeuristic
//{
//	public double getHeuristic (TopSpinPuzzleState problemState)
//	{
//		if (problemState.isGoalState())
//			return 0;
//		double count = 0;
//		for (int i = 0; i < problemState._TopSpinPuzzle.length ; i++)
////			if ((i < 3 || i > 6) && problemState._TopSpinPuzzle[i] != i)
////				count ++;
//			if (problemState._TopSpinPuzzle[i] != i)
//				count+= Math.abs(problemState._TopSpinPuzzle[i]-i);
//
////		count+= Sum(problemState._TopSpinPuzzle)/4;
//		return (int)(Math.round(count/10));
////		double swap = 0;
////		for (int i = 3; i <5 ; i++) {
////			if (problemState._TopSpinPuzzle[i] > i) {
////				swap = Sum(problemState._TopSpinPuzzle);//problemState._TopSpinPuzzle[i];
////				break;
////			}
////			else
////				swap++;
////		}
////		if (swap >= 2)
////			swap = 4;
////		for (int i = 5; i <7 ; i++) {
////			if (problemState._TopSpinPuzzle[i] < i) {
////				count += problemState._TopSpinPuzzle[i];
////			}
////		}
////		count -= problemState._TopSpinPuzzle[3]+problemState._TopSpinPuzzle[4]+problemState._TopSpinPuzzle[5]+problemState._TopSpinPuzzle[6];
////		count +=( problemState._TopSpinPuzzle[3]+problemState._TopSpinPuzzle[4]+problemState._TopSpinPuzzle[5]+problemState._TopSpinPuzzle[6])/4;
//
////		return count;
//	}
//
//	private double Sum(int[] topSpinPuzzle) {
//		double s = 0;
//		for (int i = 3; i < 7 ; i++) {
//			s +=topSpinPuzzle[i];
//		}
////		for (int i = 3; i <7 ; i++) {
////			s -= Math.abs(topSpinPuzzle[i] - i);
////		}
//		return s;
//	}
//}

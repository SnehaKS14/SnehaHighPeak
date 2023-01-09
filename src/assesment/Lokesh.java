package assesment;

import java.util.*;

class Lokesh {

	static class Job {
		int start, end, earning;

		Job(int start, int end, int earning) {
			this.start = start;
			this.end = end;
			this.earning = earning;
		}
	}

	static int findMaxearningRec(Job arr[], int n) {

		if (n == 1)
			return arr[n - 1].earning;

		int inclProf = arr[n - 1].earning;
		int i = Nonconflict(arr, n);
		if (i != -1)
			inclProf += findMaxearningRec(arr, i + 1);

		int exclProf = findMaxearningRec(arr, n - 1);

		return Math.max(inclProf, exclProf);
	}

	static int Nonconflict(Job arr[], int i) {
		for (int j = i - 1; j >= 0; j--) {
			if (arr[j].end <= arr[i - 1].start)
				return j;
		}
		return -1;
	}

	static int findMaxearning(Job arr[], int n) {

		Arrays.sort(arr, new Comparator<Job>() {
			public int compare(Job j1, Job j2) {
				return j1.end - j2.end;
			}
		});

		return findMaxearningRec(arr, n);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of jobs");
		int num = sc.nextInt();

		Job arr[] = new Job[num];
		System.out.println("Enter starting time,Ending Time and Earning");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Job(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		int n = arr.length;
		System.out.println("Earing is " + (findMaxearning(arr, n)-100));
	}
}

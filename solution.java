package coding;

import java.util.PriorityQueue;
import java.util.Scanner;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		PriorityQueue<record> pq = new PriorityQueue<>();

		System.out.println("Enter number of entries");
		int num = scn.nextInt();

		for (int i = 0; i < num; i++) {
			String option = scn.next();

			if (option.equals("SERVED")) {
				pq.remove();
			} else {
				String name = scn.next();
				float cgpa = scn.nextFloat();
				int token = scn.nextInt();

				record new_record = new record(name, cgpa, token);
				pq.add(new_record);
			}
		}

		if (pq.size() == 0) {
			System.out.println("EMPTY");
		}else{
			while (pq.size() > 0) {
				System.out.println(pq.remove().name);
			}
		}
	}

	private static class record implements Comparable<record> {
		String name;
		float cgpa;
		int token;

		public record(String name, float cgpa, int token) {
			this.name = name;
			this.cgpa = cgpa;
			this.token = token;
		}

		@Override
		public int compareTo(record o) {
			if (this.cgpa == o.cgpa) {
				if (this.name.equals(o.name)) {
					return o.token - this.token;
				} else {
					if (this.name.compareTo(o.name) > 0) {
						return 1;
					} else {
						return -1;
					}
				}
			} else {
				if (this.cgpa > o.cgpa) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}

}

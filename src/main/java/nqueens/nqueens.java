package nqueens;

class nqueens {
	int[] sol;
	int used;

	boolean works(int x, int y) {
		for (int i = 0; i < used; i++) {
			if ((sol[i] == y) || (Math.abs(x - i) == Math.abs(y - sol[i]))) {
				return false;
			}
		}
		
		return true;
	}

	boolean _solutionSearch(int x, int n) {
		if (x == n) {
			return true;
		}

		for (int y = 0; y < n; y++) {
			if (works(x,y)) {
				sol[x] = y;
				used++;

				if (_solutionSearch(x + 1, n)) {
					return true;
				}

				used--;
			}
		}

		return false;
	}

	boolean hasSolution(int n) {
		sol = new int[n];
		used = 0;
		for (int i = 0; i < sol.length; i++) {
			sol[i] = -1;
		}

		return _solutionSearch(0, n);
	}

	void printSolution() {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				if (sol[j] != i) {
					System.out.print("x");
				} else {
					System.out.print("q");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		nqueens nq = new nqueens();

		if (args.length < 1) {
			System.err.println("Usage: java nqueens <board-size>");
			return;
		}

		int len = Integer.parseInt(args[0]);

		for (int i = 0; i < len; i++) {
			System.out.println("Found solution? " + nq.hasSolution(i));
			nq.printSolution();
		}
	}
}

class Solution {
    private List<List<String>> answer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> tmp = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n*2];
        boolean[] diag2 = new boolean[n*2];
        backtrack(0, n, col, diag1, diag2, tmp);
        return answer;
    }

    private void backtrack(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2, List<String> result) {
        if (row == n) {
            //record();
            answer.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] || diag1[row-i+n] || diag2[row+i]) {
                continue;
            }
            col[i] = true;
            diag1[row-i+n] = true;
            diag2[row+i] = true;
            result.add(buildString(n, i));
            backtrack(row+1, n, col, diag1, diag2, result);
            result.remove(result.size() - 1);
            col[i] = false;
            diag1[row-i+n] = false;
            diag2[row+i] = false;
        }
    }

    String buildString(int n, int queenIdx) {
        String res = "";

        for (int i = 0; i < n; i++) {
            

            if (i == queenIdx) {
                res += "Q";
            } else {
                res += ".";
            }
        }

        return res;
    }
}

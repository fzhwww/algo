//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1753 👎 0

package leetcode.editor.cn;  
class NumberOfIslands {

    public static void main(String[] args) {
        char grid[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'}
        };

        int res = new NumberOfIslands().new Solution().numIslands(grid);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            int r = grid.length;
            int c = grid[0].length;
            int dfsTime = 0;
            for (int i = 0;i < r;i++) {
                for (int j = 0; j < c;j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        dfsTime++;
                        dfs(grid,i,j,dfsTime,0);
                    }
                }
            }
            return res;
        }

        //污染相领陆地，设置为海水，以便计算岛屿数量快速返回，定义递归函数
        public void dfs(char[][] grid,int i,int j,int dfsTime,int level) {
            level++;
            //前序位置
            System.out.println("dfsTime:" + dfsTime + ";level:" + level);

            int r = grid.length;
            int c = grid[0].length;
            if (i < 0 || j < 0 || i >= r || j >= c) {
                return;
            }

            if (grid[i][j] == '0') {
                return;
            }

            //污染掉当前的陆地
            grid[i][j] = '0';
            dfs(grid,i - 1,j,dfsTime,level);
            dfs(grid,i + 1,j,dfsTime,level);
            dfs(grid,i,j - 1,dfsTime,level);
            dfs(grid,i,j + 1,dfsTime,level);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
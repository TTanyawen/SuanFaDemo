//package hot100;
//
//public class BL_T_0314_4 {
//    public static void main(String[] args) {
//        int[][] grid={{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
//        System.out.println(num_islands(grid));
//    }
//    public static int num_islands(int[][] grid) {
//
//        // write code here
//        int res=0;
//        for(int x=1;x<= grid.length-2;x++){
//            for(int y=1;y<=grid[0].length-2;y++){
//                if(isIsland(grid,x,y)){
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//    public static boolean isIsland(int[][] grid,int x,int y){
//        if(grid[x][y]!=0){
//            return false;
//        }
//        if(!(grid[x-1][y]==1&&grid[x+1][y]==1&&grid[x][y-1]==1&&grid[x][y+1]==1)){
//            return false;
//        }
//        if(!(grid[x-1][y-1]==1&&grid[x+1][y+1]==1&&grid[x+1][y-1]==1&&grid[x-1][y+1]==1)){
//            return false;
//        }
//        if(y-2>=0&&grid[x][y-2]==1){
//            return false;
//        }
//        if(y+2<= grid[0].length-1&&grid[x][y+2]==1){
//            return false;
//        }
//        if(x-2>=0&&grid[x-2][y]==1){
//            return false;
//        }
//        if(x+2<= grid.length-1&&grid[x+2][y]==1){
//            return false;
//        }
//        return true;
//
//    }
//}

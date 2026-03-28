//package hot100;
//
//import java.util.*;
//
//public class AT1 {
//    //[0, 2, 1, 3]
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        List<Integer> list=new ArrayList<>();
//        String str="[3,2,0,1]";
//        String[] strArr=str.split(",");
//        strArr[0]=strArr[0].substring(1,strArr[0].length());
//        strArr[strArr.length-1]=strArr[strArr.length-1].substring(0,strArr[strArr.length-1].length()-1);
//        for(String tmp:strArr){
//            tmp=tmp.trim();
//            list.add(Integer.parseInt(tmp));
//        }
////        while(sc.hasNext()) {
////            list.add(sc.nextInt());
////        }
////        List<Integer> list=List.of(0,2,1,3);
//        int[] arr=new int[list.size()];
//        int index=0;
//        for(int i:list){
//            arr[index]=i;
//            index++;
//        }
//        Map<Integer,Integer> m=new HashMap<>();
//        for(int i=0;i<=arr.length-1;i++){
//            m.put(arr[i],i);
//        }
//
//        int cnt=0;
//        for(int i=1;i<=arr.length-2;i+=2){
//            int left=arr[i-1];
//            int right=arr[i];
//            int minn=Math.min(left,right);
//            //已经是是情侣
//            if(minn%2==0&&Math.abs(left-right)==1){
//                continue;
//            }
//
//            //找left的cp的index,进行座位交换
//            cnt++;
//            int cp=left/2==0?left+1:left-1;
//            int cpIndex=m.get(cp);
//            int tmp=left;
//            arr[left]=arr[cpIndex];
//            arr[cpIndex]=tmp;
//            m.put(right,cpIndex);
//            m.put(cp,i);
//        }
//        System.out.println(cnt);
////        System.out.println(Arrays.toString(arr));
//    }
//}

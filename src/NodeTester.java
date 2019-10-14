import java.util.ArrayList;

public class NodeTester {
    public static void main(String[] args){
        try {
            ArrayList<int[]> blist = new ArrayList<>();
            blist.add(new int[]{1,2});
            NQnode ex = new NQnode(null,5,5,3,blist);
            System.out.print("[");
            for(int i=0;i<ex.getQueenLocation().size();i++){

                System.out.print("("+ex.getQueenLocation().get(i)[0]+","+ex.getQueenLocation().get(i)[1]+")");

            }
            System.out.print("]");
        }catch(Exception x){
            x.printStackTrace();
        }
    }
}

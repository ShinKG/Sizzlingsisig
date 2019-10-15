import java.util.ArrayList;
public class NQsolver {
    ArrayList<NQnode> frontiers;
    NQnode currnet;
    public void main(String[] args){
        try{
            run();
        }catch(Exception x){
            x.printStackTrace();
        }
    }

    public static void run()throws Exception{
        NQReader r = new NQReader("information.txt");
        NQnode initial= new NQnode(r.getWidth(),r.getHeight(),r.getNoOfQeens(),r.getBlockedBlocks());
        ArrayList<NQnode> sides();
        int index=0;

        while(!sides.isEmpty()){

        }
    }

    public NQnode findNext(NQnode a){
        ArrayList<NQnode> candidates;

        String[][]map = a.getMap();
        ArrayList<int[]> queenList = a.getQueenLocation();
        ArrayList<int[]> blockList = a.getBlockedBlocks();

        while

    }
}

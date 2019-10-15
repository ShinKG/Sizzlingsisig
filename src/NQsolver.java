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
        int index=0;


    }

    public NQnode findNext(NQnode a){
        ArrayList<NQnode> candidates;

        String[][]map = a.getMap();
        ArrayList<int[]> queenList = a.getQueenLocation();
        ArrayList<int[]> blockList = a.getBlockedBlocks();
        ArrayList<String> availMoves = new ArrayList<String>();
        availMoves.add("N");
        availMoves.add("NE");
        availMoves.add("E");
        availMoves.add("SE");
        availMoves.add("S");
        availMoves.add("SW");
        availMoves.add("W");
        availMoves.add("NW");

        int x,y;
        int[] direction = new int[2];
        for(int i =0; i<queenList.size(); i++){
            direction = queenList.get(i);
            
            //availmoves remover
            //N-north , NE-NorthEast, E-East, SE-southeast, S-south, SW-Southwest...
            if(direction[0]==0){
                availMoves.remove("W");
                availMoves.remove("NW");
                availMoves.remove("SW");
            }
            if(direction[0]==map.length-1){
                availMoves.remove("E");
                availMoves.remove("NE");
                availMoves.remove("SE");
            }
            if(direction[1]==0){
                availMoves.remove("N");
                availMoves.remove("NE");
                availMoves.remove("NW");
            }
            if(direction[1]==map.length-1){
                availMoves.remove("S");
                availMoves.remove("SE");
                availMoves.remove("SW");
            }

        }

    }
}

import java.util.ArrayList;
public class NQsolver {
    private static ArrayList<NQnode> frontiers = new ArrayList<>();
    private static NQnode currnet;

    public static void main(String[] args){
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
        frontiers.add(findNext(initial));
        System.out.println(frontiers);


    }

    public static NQnode findNext(NQnode a){
        ArrayList<NQnode> candidates,candifinal=new ArrayList<>();
        NQnode smallest =null;

        String[][]map = a.getMap();
        ArrayList<int[]> queenList = a.getQueenLocation();
        ArrayList<int[]> blockList = a.getBlockedBlocks();
        ArrayList<String> availMoves = new ArrayList<String>();

        int x,y;
        int[] direction = new int[2];
        for(int i =0; i<queenList.size(); i++){
            direction = queenList.get(i);
            availMoves.clear();
            availMoves.add("N");
            availMoves.add("NE");
            availMoves.add("E");
            availMoves.add("SE");
            availMoves.add("S");
            availMoves.add("SW");
            availMoves.add("W");
            availMoves.add("NW");

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
            if(direction[1]==map[0].length-1){
                availMoves.remove("S");
                availMoves.remove("SE");
                availMoves.remove("SW");
            }
            System.out.print("[");
            System.out.print("("+queenList.get(i)[0]+","+queenList.get(i)[1]+")");
            System.out.print("]");
            System.out.println(availMoves);

            candidates = expands(availMoves,a,direction);
            smallest = getnQnode(candidates, smallest);
            candifinal.add(smallest);
        }
        smallest = getnQnode(candifinal, smallest);
        return smallest;
    }

    private static  NQnode getnQnode(ArrayList<NQnode> candifinal, NQnode smallest) {
        for(int k=0; k<candifinal.size();k++){
            if(smallest==null){
                smallest = candifinal.get(k);
                continue;
            }
            smallest.findConflict();
            if(smallest.getConflict()>candifinal.get(k).getConflict()){
                smallest = candifinal.get(k);
            }
        }
        return smallest;
    }

    public static ArrayList<NQnode> expands(ArrayList<String> mov,NQnode can,int[] qLoc){

        ArrayList<NQnode> returning = new ArrayList<NQnode>();
        String[][] d_map= can.getMap();
        ArrayList<int[]> nextQ;
        ArrayList<int[]> nextB = can.getBlockedBlocks();

        for(int i=0; i<mov.size(); i++) {
            nextQ = can.getQueenLocation();
            if(mov.get(i).equals("N")){
                if(!(d_map[qLoc[0]][qLoc[1]-1].equals("B"))&&!(d_map[qLoc[0]][qLoc[1]-1].equals("Q"))) {
                    d_map[qLoc[0]][qLoc[1]] = can.getMap()[qLoc[0]][qLoc[1] - 1];
                    d_map[qLoc[0]][qLoc[1] - 1] = can.getMap()[qLoc[0]][qLoc[1]];
                    nextQ.remove(qLoc);
                    nextQ.add(new int[]{qLoc[0], qLoc[1] - 1});
                    returning.add(new NQnode(can, d_map.length, d_map[0].length, can.getNoOfQueens(), nextQ, nextB));
                }
            }
            nextQ = can.getQueenLocation();
            if(mov.get(i).equals("NE")){
                if(!d_map[qLoc[0]+1][qLoc[1]-1].equals("B")&&!d_map[qLoc[0]+1][qLoc[1]-1].equals("Q")) {
                    d_map[qLoc[0]][qLoc[1]] = can.getMap()[qLoc[0] + 1][qLoc[1] - 1];
                    d_map[qLoc[0] + 1][qLoc[1] - 1] = can.getMap()[qLoc[0]][qLoc[1]];
                    nextQ.remove(qLoc);
                    nextQ.add(new int[]{qLoc[0] + 1, qLoc[1] - 1});
                    returning.add(new NQnode(can, d_map.length, d_map[0].length, can.getNoOfQueens(), nextQ, nextB));
                }
            }
            nextQ = can.getQueenLocation();
            if(mov.get(i).equals("E")){
                if(!d_map[qLoc[0]+1][qLoc[1]].equals("B")&&!d_map[qLoc[0]+1][qLoc[1]].equals("Q")) {
                    d_map[qLoc[0]][qLoc[1]] = can.getMap()[qLoc[0] + 1][qLoc[1]];
                    d_map[qLoc[0] + 1][qLoc[1]] = can.getMap()[qLoc[0]][qLoc[1]];
                    nextQ.remove(qLoc);
                    nextQ.add(new int[]{qLoc[0] + 1, qLoc[1]});
                    returning.add(new NQnode(can, d_map.length, d_map[0].length, can.getNoOfQueens(), nextQ, nextB));
                }
            }
            nextQ = can.getQueenLocation();
            if(mov.get(i).equals("SE")){
                if(!d_map[qLoc[0]+1][qLoc[1]+1].equals("B")&&!d_map[qLoc[0]+1][qLoc[1]+1].equals("Q")) {
                    System.out.println("from x: " + qLoc[0] + " y: " + qLoc[1]);
                    d_map[qLoc[0]][qLoc[1]] = can.getMap()[qLoc[0] + 1][qLoc[1] + 1];
                    d_map[qLoc[0] + 1][qLoc[1] + 1] = can.getMap()[qLoc[0]][qLoc[1]];
                    nextQ.remove(qLoc);
                    nextQ.add(new int[]{qLoc[0] + 1, qLoc[1] + 1});
                    returning.add(new NQnode(can, d_map.length, d_map[0].length, can.getNoOfQueens(), nextQ, nextB));
                }
            }
            nextQ = can.getQueenLocation();
            if(mov.get(i).equals("S")) {
                if (!d_map[qLoc[0]][qLoc[1] + 1].equals("B") && !d_map[qLoc[0]][qLoc[1] + 1].equals("Q")) {
                    d_map[qLoc[0]][qLoc[1]] = can.getMap()[qLoc[0]][qLoc[1] + 1];
                    d_map[qLoc[0]][qLoc[1] + 1] = can.getMap()[qLoc[0]][qLoc[1]];
                    nextQ.remove(qLoc);
                    nextQ.add(new int[]{qLoc[0], qLoc[1] + 1});
                    returning.add(new NQnode(can, d_map.length, d_map[0].length, can.getNoOfQueens(), nextQ, nextB));
                }
            }
            nextQ = can.getQueenLocation();
            if(mov.get(i).equals("SW")) {
                if (!d_map[qLoc[0] - 1][qLoc[1] + 1].equals("B") && !d_map[qLoc[0] - 1][qLoc[1] + 1].equals("Q")) {
                    d_map[qLoc[0]][qLoc[1]] = can.getMap()[qLoc[0] - 1][qLoc[1] + 1];
                    d_map[qLoc[0] - 1][qLoc[1] + 1] = can.getMap()[qLoc[0]][qLoc[1]];
                    nextQ.remove(qLoc);
                    nextQ.add(new int[]{qLoc[0] - 1, qLoc[1] + 1});
                    returning.add(new NQnode(can, d_map.length, d_map[0].length, can.getNoOfQueens(), nextQ, nextB));
                }
            }
            nextQ = can.getQueenLocation();
            if(mov.get(i).equals("W")){
                if(!d_map[qLoc[0]-1][qLoc[1]].equals("B")&&!d_map[qLoc[0]-1][qLoc[1]].equals("Q")){
                    d_map[qLoc[0]][qLoc[1]] = can.getMap()[qLoc[0]-1][qLoc[1]];
                    d_map[qLoc[0]-1][qLoc[1]] = can.getMap()[qLoc[0]][qLoc[1]];
                    nextQ.remove(qLoc);
                    nextQ.add(new int[]{qLoc[0]-1,qLoc[1]});
                    returning.add(new NQnode(can,d_map.length,d_map[0].length,can.getNoOfQueens(),nextQ,nextB));
                }
            }
            if(mov.get(i).equals("NW")) {
                if (!d_map[qLoc[0] - 1][qLoc[1] - 1].equals("B") && !d_map[qLoc[0] - 1][qLoc[1] - 1].equals("Q")) {
                    d_map[qLoc[0]][qLoc[1]] = can.getMap()[qLoc[0] - 1][qLoc[1] - 1];
                    d_map[qLoc[0] - 1][qLoc[1] - 1] = can.getMap()[qLoc[0]][qLoc[1]];
                    nextQ.remove(qLoc);
                    nextQ.add(new int[]{qLoc[0] - 1, qLoc[1] - 1});
                    returning.add(new NQnode(can, d_map.length, d_map[0].length, can.getNoOfQueens(), nextQ, nextB));
                }
            }

        }
        return returning;
    }
}

public class ReaderTester {
    public static void main(String[] args){
        try {
            NQReader rder = new NQReader("information.txt");
            System.out.println("W : "+rder.getWidth());
            System.out.println("H : "+rder.getHeight());
            System.out.println("NoQ: "+rder.getNoOfQeens());


            System.out.print("[");
            for(int i=0;i<rder.getBlockedBlocks().size();i++){

                System.out.print("("+rder.getBlockedBlocks().get(i)[0]+","+rder.getBlockedBlocks().get(i)[1]+")");

            }
            System.out.print("]");
        }catch(Exception x){
            x.printStackTrace();
        }
    }

}

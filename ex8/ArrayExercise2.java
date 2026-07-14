public class ArrayExercise2 {
    public static void main(String[] args) {
        int intNested[][][];
        intNested = new int[2][3][];
        intNested[0][0] = new int[3];
        intNested[0][1] = new int[4];
        intNested[1][0] = new int[5];
        intNested[1][1] = new int[1];
        intNested[0][2] = new int[2];
        intNested[1][2] = new int[1];
        
        for(int i = 0; i < intNested.length; i++) {
            for(int j = 0; j < intNested[i].length; j++) {
                for(int k = 0; k < intNested[i][j].length; k++) {
                    System.out.print("intNested[" + i + "][" + j + "][" + k + "]");
                    System.out.println(intNested[i][j][k]);
                }
            }
        }
    }
}
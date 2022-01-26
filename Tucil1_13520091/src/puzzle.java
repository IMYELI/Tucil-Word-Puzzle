public class puzzle {
    String[][] matrixPuzzle = new String[100][100];
    String[][] matrixWord = new String[100][100];
    int[][] matrixPuzzleC = new int[100][100];
    int[] arrayCount = new int[100];
    boolean[] arrayFound = new boolean[100];
    String[] arrayColor = new String[6];
    long startTime;
    int countWords = 0;
    int length;
    int width;
    int nthColor = 0;
    int getCountSum = 0;
    int wordGot = 0;
    boolean found = false;
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001b[36m";
    public static final String ANSI_MAGENTA = "\u001b[35m";
    public static final String ANSI_BRED = "\033[38;5;213m";
    public static final String ANSI_BBLUE = "\033[38;5;122m";
    public static final String ANSI_RESET = "\u001B[0m";

    // public void setArrC(){
    //     this.arrayColor[0] = "\u001B[31m";  //Red
    //     this.arrayColor[1] = "\u001B[33m";  //Yellow
    //     this.arrayColor[2] = "\u001B[32m";  //Green
    //     this.arrayColor[3] = "\u001B[34m";  //Blue
    //     this.arrayColor[4] = "\u001B[37m";  //White
    //     this.arrayColor[5] = "\u001B[0m";  //reset
    // }
    
    public void initArrFound(){
        int i;
        for(i=0;i<countWords;i++){
            this.arrayFound[i] = false;
        }
    }

    public void setArrFound(int i, boolean x){
        this.arrayFound[i] = x;
    }

    public boolean getArrFound(int i){
        return this.arrayFound[i];
    }

    public void incrWordGot(){
        this.wordGot++;
    }

    public int getWordGot(){
        return this.wordGot;
    }

    public void startTimer(){
        this.startTime = System.nanoTime();
    }
    
    public long getTime(){
        return (System.nanoTime()-this.startTime)/1000000;
    }

    public void setArrCount(int i, int x){
        this.arrayCount[i] = x;
    }

    public void incrGetCount(int x){
        this.getCountSum += x;
    }

    public int getArrCount(int i){
        return this.arrayCount[i];
    }
    public void incrArrCount(int i){
        this.arrayCount[i]++;
    }
    public int getCountSum(){
        int i;
        int sum = 0;
        for(i=0;i<this.arrayCount.length;i++){
            sum += this.arrayCount[i];
        }
        return sum;
    }

    public void initArrCount(){
        int i;
        for(i=0;i<this.countWords;i++){
            setArrCount(i, 0);
        }
    }

    public String getColor(){
        if(this.nthColor == 0){
            return ANSI_RED;
        }else{
            if(this.nthColor == 1){
                return ANSI_YELLOW;
            }else{
                if(this.nthColor == 2){
                    return ANSI_GREEN;
                }else{
                    if(this.nthColor == 3){
                        return ANSI_BLUE;
                    }else{
                        if(this.nthColor == 4){
                            return ANSI_CYAN;
                        }else{
                            if(this.nthColor == 5){
                                return ANSI_MAGENTA;
                            }else{
                                if(this.nthColor == 6){
                                    return ANSI_BRED;
                                }else{
                                    if(this.nthColor==7){
                                        return ANSI_BBLUE;
                                    }else{
                                        return ANSI_RESET;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }

    public void updateColor(){
        this.nthColor++;
        this.nthColor %= 8;
    }

    public String getResetC(){
        return ANSI_RESET;
    }

    public void setMatP(int i, int j, String x){
        this.matrixPuzzle[i][j] = x;
    }
    public String[][] getMatP(){
        return this.matrixPuzzle;
    }

    public String getIsiMatP(int i, int j){
        return this.matrixPuzzle[i][j];
    }
    
    public void setMatW(int i, int j, String x){
        this.matrixWord[i][j] = x;
    }

    public String[][] getMatW(){
        return this.matrixWord;
    }

    public String[] getWord(int pos){
        return this.matrixWord[pos];
    }

    public void setWord(int pos, String[] S){
        this.matrixWord[pos] = S;
    }

    public String getLetter(int x, int y){
        return this.matrixWord[x][y];
    }

    public void setStatus(boolean status){
        this.found = status;
    }

    public boolean getStatus(){
        return this.found;
    }

    public void setCountW(int num){
        this.countWords = num;
    }

    public int getCountW(){
        return this.countWords;
    }

    public void setLength(int num){
        this.length = num;
    }

    public int getLength(){
        return this.length;
    }

    public void setWidth(int num){
        this.width = num;
    }

    public int getWidth(){
        return this.width;
    }

    public void setMatPC(int i, int j, int x){
        this.matrixPuzzleC[i][j] = x;
    }

    public void initMatPC(){
        int i,j;
        for(i=0;i<this.length;i++){
            for(j=0;j<this.width;j++){
                setMatPC(i,j,8);
            }
        }
    }

    public int getIsiMatPC(int i, int j){
        return this.matrixPuzzleC[i][j];
    }

    public int[][] getMatPC(){
        return this.matrixPuzzleC;
    }

    public int getColorCode(){
        return this.nthColor;
    }

    public void setColorCode(int x){
        this.nthColor = x;
    }
}

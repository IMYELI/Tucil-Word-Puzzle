import java.io.File; 
import java.io.FileNotFoundException;    
import java.util.Scanner;


class mainProg{
    public static void printPuzzle(String[][] puzzle,int width,int length){
        int i,j;
        for(i=0;i<length;i++){
            for(j=0;j<width;j++){
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("\u001B[0m");
    }

    public static void printMatColor(puzzle objP){
        int i,j;
        for(i=0;i<objP.length;i++){
            for(j=0;j<objP.width;j++){
                System.out.print(objP.getIsiMatPC(i, j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printWords(String[][] words, int length){
        int i,j;
        for(i=0;i<length;i++){
            int wordLen = words[i].length;
            for(j=0;j<wordLen;j++){
                System.out.print(words[i][j]);
            }
            System.out.println();
        }
    }

    public static void printWord(String[] word){
        int i;
        for(i=0;i<word.length;i++){
            System.out.print(word[i]);
        }
        System.out.println();
    }

    public static String arrToString(String[] word){
        int i;
        String x = "";
        for(i=0;i<word.length;i++){
            x += word[i];
        }
        return x;
    }

    public static void initDash(String[][] dash,int length, int width){
        int i,j;
        for(i=0;i<length;i++){
            for(j=0;j<width;j++){
                dash[i][j] = "-";
            }
        }
    }

    public static puzzle checkR(puzzle objP, String[] word ,int xAwal, int yAwal, int width,int k){        //Mengecek kata di bagian horizontal
        boolean depanMatch = true;
        int i=1;
        int xUp = xAwal;
        int yUp = yAwal+1;
        objP.setStatus(false);
        while(depanMatch && i<word.length && yUp<width){
            objP.incrArrCount(k);
            if(!objP.getIsiMatP(xUp, yUp).equals(word[i])){        
                depanMatch = false;
                return objP;                
            }
            i++;
            yUp++;
        }
        if(i==word.length){
            objP.setStatus(true);
        }
        return objP;
    }
    
    public static puzzle checkL(puzzle objP, String[] word ,int xAwal, int yAwal, int width, int k){        //Mengecek kata di bagian horizontal ke kiri
        boolean depanMatch = true;
        int i=1;
        int xUp = xAwal;
        int yUp = yAwal-1;
        objP.setStatus(false);
        while(depanMatch && i<word.length && yUp>=0){
            objP.incrArrCount(k);
            if(!objP.getIsiMatP(xUp, yUp).equals(word[i])){        
                depanMatch = false;
                return objP;                
            }
            i++;
            yUp--;
        }
        if(i==word.length){
            objP.setStatus(true);
        }
        return objP;
    }

    public static puzzle checkT(puzzle objP, String[] word ,int xAwal, int yAwal, int width, int k){        //Mengecek kata di bagian vertikal ke atas
        boolean depanMatch = true;
        int i=1;
        int xUp = xAwal-1;
        int yUp = yAwal;
        objP.setStatus(false);
        while(depanMatch && i<word.length && xUp>=0){
            objP.incrArrCount(k);
            if(!objP.getIsiMatP(xUp, yUp).equals(word[i])){        
                depanMatch = false;
                return objP;                
            }
            i++;
            xUp--;
        }
        if(i==word.length){
            objP.setStatus(true);
        }
        return objP;
    }

    public static puzzle checkB(puzzle objP, String[] word ,int xAwal, int yAwal, int width,int k){        //Mengecek kata di bagian vertikal ke bawah
        boolean depanMatch = true;
        int i=1;
        int xUp = xAwal+1;
        int yUp = yAwal;
        objP.setStatus(false);
        while(depanMatch && i<word.length && xUp<objP.length){
            objP.incrArrCount(k);
            if(!objP.getIsiMatP(xUp, yUp).equals(word[i])){        
                depanMatch = false;
                return objP;                
            }
            i++;
            xUp++;
        }
        if(i==word.length){
            objP.setStatus(true);
        }
        return objP;
    }

    public static puzzle checkBR(puzzle objP, String[] word ,int xAwal, int yAwal, int width, int k){        //Mengecek kata di bagian diagonal ke tenggara
        boolean depanMatch = true;
        int i=1;
        int xUp = xAwal+1;
        int yUp = yAwal+1;
        objP.setStatus(false);
        while(depanMatch && i<word.length && xUp<objP.length && yUp<objP.width){
            if(!objP.getIsiMatP(xUp, yUp).equals(word[i])){        
                objP.incrArrCount(k);
                depanMatch = false;
                return objP;                
            }
            i++;
            xUp++;
            yUp++;
        }
        if(i==word.length){
            objP.setStatus(true);
        }
        return objP;
    }

    public static puzzle checkBL(puzzle objP, String[] word ,int xAwal, int yAwal, int width,int k){        //Mengecek kata di bagian diagonal ke barat daya
        boolean depanMatch = true;
        int i=1;
        int xUp = xAwal+1;
        int yUp = yAwal-1;
        objP.setStatus(false);
        while(depanMatch && i<word.length && xUp<objP.length && yUp>-1){
            objP.incrArrCount(k);
            if(!objP.getIsiMatP(xUp, yUp).equals(word[i])){        
                depanMatch = false;
                return objP;                
            }
            i++;
            xUp++;
            yUp--;
        }
        if(i==word.length){
            objP.setStatus(true);
        }
        return objP;
    }

    public static puzzle checkTL(puzzle objP, String[] word ,int xAwal, int yAwal, int width, int k){        //Mengecek kata di bagian diagonal ke barat laut
        boolean depanMatch = true;
        int i=1;
        int xUp = xAwal-1;
        int yUp = yAwal-1;
        objP.setStatus(false);
        while(depanMatch && i<word.length && xUp>-1 && yUp>-1){
            objP.incrArrCount(k);
            if(!objP.getIsiMatP(xUp, yUp).equals(word[i])){        
                depanMatch = false;
                return objP;                
            }
            i++;
            xUp--;
            yUp--;
        }
        if(i==word.length){
            objP.setStatus(true);
        }
        return objP;
    }

    public static puzzle checkTR(puzzle objP, String[] word ,int xAwal, int yAwal, int width, int k){        //Mengecek kata di bagian diagonal ke timur laut
        boolean depanMatch = true;
        int i=1;
        int xUp = xAwal-1;
        int yUp = yAwal+1;
        objP.setStatus(false);
        while(depanMatch && i<word.length && xUp>-1 && yUp<objP.width){
            objP.incrArrCount(k);
            if(!objP.getIsiMatP(xUp, yUp).equals(word[i])){        
                depanMatch = false;
                return objP;                
            }
            i++;
            xUp--;
            yUp++;
        }
        if(i==word.length){
            objP.setStatus(true);
        }
        return objP;
    }

    public static puzzle markR(puzzle objP, int xAwal, int yAwal, int wordLen){         //Menandai matrix warna ke arah kanan
        int j;
        for(j=yAwal;j<wordLen+yAwal;j++){
            objP.setMatPC(xAwal, j, objP.getColorCode());
        }
        objP.updateColor();
        return objP;
    }

    public static puzzle markL(puzzle objP, int xAwal, int yAwal, int wordLen){
        int j;
        for(j=yAwal;j>yAwal-wordLen;j--){
            objP.setMatPC(xAwal, j, objP.getColorCode());
        }
        objP.updateColor();
        return objP;
    }

    public static puzzle markT(puzzle objP, int xAwal, int yAwal, int wordLen){
        int i;
        for(i=xAwal;i>xAwal-wordLen;i--){
            objP.setMatPC(i, yAwal, objP.getColorCode());
        }
        objP.updateColor();
        return objP;
    }

    public static puzzle markB(puzzle objP, int xAwal, int yAwal, int wordLen){
        int i;
        for(i=xAwal;i<xAwal+wordLen;i++){
            objP.setMatPC(i, yAwal, objP.getColorCode());
        }
        objP.updateColor();
        return objP;
    }

    public static puzzle markBR(puzzle objP, int xAwal, int yAwal, int wordLen){
        int i;
        int j = yAwal;
        for(i=xAwal;i<xAwal+wordLen;i++){
            objP.setMatPC(i, j, objP.getColorCode());
            j++;
        }
        objP.updateColor();
        return objP;
    }

    public static puzzle markBL(puzzle objP, int xAwal, int yAwal, int wordLen){
        int i;
        int j = yAwal;
        for(i=xAwal;i<xAwal+wordLen;i++){
            objP.setMatPC(i, j, objP.getColorCode());
            j--;
        }
        objP.updateColor();
        return objP;
    }

    public static puzzle markTL(puzzle objP, int xAwal, int yAwal, int wordLen){
        int i;
        int j = yAwal;
        for(i=xAwal;i>xAwal-wordLen;i--){
            objP.setMatPC(i, j, objP.getColorCode());
            j--;
        }
        objP.updateColor();
        return objP;
    }

    public static puzzle markTR(puzzle objP, int xAwal, int yAwal, int wordLen){
        int i;
        int j = yAwal;
        for(i=xAwal;i>xAwal-wordLen;i--){
            objP.setMatPC(i, j, objP.getColorCode());
            j++;
        }
        objP.updateColor();
        return objP;
    }

    public static puzzle color(puzzle objP){                                    //Mewarnain matrix puzzle sesuai warna dari matrix color
        int i,j;
        boolean color = false;
        for(i=0;i<objP.length;i++){
            for(j=0;j<objP.width;j++){
                if(objP.getIsiMatPC(i, j) != 8){
                    color = true;
                }else{
                    color = false;
                }
                if(color){
                    objP.setColorCode(objP.getIsiMatPC(i, j));
                    objP.setMatP(i, j, objP.getColor()+objP.getIsiMatP(i, j)); 
                }else{
                    objP.setMatP(i, j, objP.getResetC()+objP.getIsiMatP(i, j)); 
                }
            }
        }
        return objP;
    }

    public static puzzle checkPuzzle(puzzle pObj, int k, int i, int j){
        if(!pObj.getArrFound(k) && pObj.getIsiMatP(i, j).equals(pObj.getLetter(k, 0))){
            pObj.incrArrCount(k);
            pObj = checkR(pObj, pObj.getWord(k),i,j,pObj.width, k);
            if(pObj.getStatus()){
                // printR(pObj.getMatP(), matrixDash, i, j, pObj.getWord(k), width, length);
                System.out.println("Kata " + arrToString(pObj.getWord(k)) + " ditemukan pada koordinat (" + i + "," + j + ") mendatar ke kanan dalam :");
                System.out.println(pObj.getArrCount(k) + " perbandingan dan waktu " + pObj.getTime() + "ms\n");
                markR(pObj, i, j, pObj.getWord(k).length);
                pObj.incrWordGot();
                pObj.setArrFound(k, true);
            }
            pObj = checkL(pObj, pObj.getWord(k), i, j, pObj.width, k);
            if(pObj.getStatus()){
                // printR(pObj.getMatP(), matrixDash, i, j, pObj.getWord(k), width, length);
                System.out.println("Kata " + arrToString(pObj.getWord(k)) + " ditemukan pada koordinat (" + i + "," + j + ") mendatar ke kiri dalam :");
                System.out.println(pObj.getArrCount(k) + " perbandingan dan waktu " + pObj.getTime() + "ms\n");
                markL(pObj, i, j, pObj.getWord(k).length);
                pObj.incrWordGot();
                pObj.setArrFound(k, true);
            }
            pObj = checkT(pObj, pObj.getWord(k), i, j, pObj.width, k);
            if(pObj.getStatus()){
                // printR(pObj.getMatP(), matrixDash, i, j, pObj.getWord(k), width, length);
                System.out.println("Kata " + arrToString(pObj.getWord(k)) + " ditemukan pada koordinat (" + i + "," + j + ") vertikal ke atas dalam :");
                System.out.println(pObj.getArrCount(k) + " perbandingan dan waktu " + pObj.getTime() + "ms\n");
                markT(pObj, i, j, pObj.getWord(k).length);
                pObj.incrWordGot();
                pObj.setArrFound(k, true);
            }
            pObj = checkB(pObj, pObj.getWord(k), i, j, pObj.width, k);
            if(pObj.getStatus()){
                // printR(pObj.getMatP(), matrixDash, i, j, pObj.getWord(k), width, length);
                System.out.println("Kata " + arrToString(pObj.getWord(k)) + " ditemukan pada koordinat (" + i + "," + j + ") vertikal ke bawah dalam :");
                System.out.println(pObj.getArrCount(k) + " perbandingan dan waktu " + pObj.getTime() + "ms\n");
                markB(pObj, i, j, pObj.getWord(k).length);
                pObj.incrWordGot();
                pObj.setArrFound(k, true);
            }
            pObj = checkBR(pObj, pObj.getWord(k), i, j, pObj.width, k);
            if(pObj.getStatus()){
                // printR(pObj.getMatP(), matrixDash, i, j, pObj.getWord(k), width, length);
                System.out.println("Kata " + arrToString(pObj.getWord(k)) + " ditemukan pada koordinat (" + i + "," + j + ") diagonal ke kanan bawah dalam :");
                System.out.println(pObj.getArrCount(k) + " perbandingan dan waktu " + pObj.getTime() + "ms\n");
                markBR(pObj, i, j, pObj.getWord(k).length);
                pObj.incrWordGot();
                pObj.setArrFound(k, true);
            }
            pObj = checkBL(pObj, pObj.getWord(k), i, j, pObj.width, k);
            if(pObj.getStatus()){
                // printR(pObj.getMatP(), matrixDash, i, j, pObj.getWord(k), width, length);
                System.out.println("Kata " + arrToString(pObj.getWord(k)) + " ditemukan pada koordinat (" + i + "," + j + ") diagonal ke kiri bawah dalam :");
                System.out.println(pObj.getArrCount(k) + " perbandingan dan waktu " + pObj.getTime() + "ms\n");
                markBL(pObj, i, j, pObj.getWord(k).length);
                pObj.incrWordGot();
                pObj.setArrFound(k, true);
            }
            pObj = checkTL(pObj, pObj.getWord(k), i, j, pObj.width, k);
            if(pObj.getStatus()){
                // printR(pObj.getMatP(), matrixDash, i, j, pObj.getWord(k), width, length);
                System.out.println("Kata " + arrToString(pObj.getWord(k)) + " ditemukan pada koordinat (" + i + "," + j + ") diagonal ke kiri atas dalam :");
                System.out.println(pObj.getArrCount(k) + " perbandingan dan waktu " + pObj.getTime() + "ms\n");
                markTL(pObj, i, j, pObj.getWord(k).length);
                pObj.incrWordGot();
                pObj.setArrFound(k, true);
            }
            pObj = checkTR(pObj, pObj.getWord(k), i, j, pObj.width, k);
            if(pObj.getStatus()){
                // printR(pObj.getMatP(), matrixDash, i, j, pObj.getWord(k), width, length);
                System.out.println("Kata " + arrToString(pObj.getWord(k)) + " ditemukan pada koordinat (" + i + "," + j + ") diagonal ke kanan atas dalam :");
                System.out.println(pObj.getArrCount(k) + " perbandingan dan waktu " + pObj.getTime() + "ms\n");
                markTR(pObj, i, j, pObj.getWord(k).length);
                pObj.incrWordGot();
                pObj.setArrFound(k, true);
            }
        }
        
        return pObj;
    };
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String filePath = sc.next();
        String path = System.getProperty("user.dir");
        path = path + "\\..\\test\\" + filePath;
        System.out.println(path);
        puzzle pObj = new puzzle();


        int i,j;
        i = 0; j = 0;
        int length = 0;
        int width = 0;
        int countWords = 0;
        try{
            File file = new File(path);
            Scanner readData = new Scanner(file);
            Boolean puzzEnd = false;
            while(readData.hasNextLine()){
                String lineData = readData.nextLine();
                if(lineData.isEmpty()){
                    puzzEnd = true;
                    lineData = readData.nextLine();
                }
                if(!puzzEnd){
                    String[] row = lineData.split(" ",0);
                    for(j = 0;j<row.length;j++){
                        pObj.setMatP(i,j,row[j]);
                        width = j+1;
                    }
                    length++;
                    i++;
                }else{
                    pObj.setWord(countWords, lineData.split("",0)) ;
                    countWords++;
                }
                
            }
            pObj.setCountW(countWords);
            pObj.setLength(length);
            pObj.setWidth(width);
            pObj.initMatPC();
            pObj.initArrCount();
            pObj.initArrFound();
            readData.close();
        }catch (FileNotFoundException exception){
            System.out.println("File tidak ditemukan");  
        }

        int k;
        pObj.startTimer();
        for(i=0;i<length;i++){
            for(j=0;j<width;j++){
                for(k=0;k<countWords;k++){
                    pObj = checkPuzzle(pObj, k, i, j);
                }
            }
        }
        long endTime = pObj.getTime();
        color(pObj);
        printPuzzle(pObj.getMatP(), pObj.getWidth(), pObj.getLength());
        System.out.println("\n" + "Total perbandingan yang dilakukan:");
        System.out.println(pObj.getCountSum());
        System.out.println("Total waktu yang digunakan:");
        System.out.println(endTime + "ms");
        System.out.println("Total kata yang ditemukan :");
        System.out.println(pObj.getWordGot());
        sc.close();
    }
}
import java.util.Scanner;
class Main {   
    int[] P;
    
    public int[] Solve(int[] stack){
        P = stack;
        int Q = 0;
        int next = P.length - 1;
        int[] flips = new int[58];
        while(!isSorted()){
            int largest = 0;
            int largestIndex = 0;
            for(int i = next; i >= 0; i--){
                if(P[i] > largest){
                    largest = P[i];
                    largestIndex = i;
                }
            }
            if(largestIndex != 0){
                flip(largestIndex);
                flips[Q] = (P.length - largestIndex);
                Q++;
            }
            if(!isSorted()){
                flip(next);
                flips[Q] = P.length - next;
                Q++;
                next--;
            }
        }
        return flips;
    }
    
    public boolean isSorted(){
        boolean sorted = true;
        for(int i = 1; i < P.length; i++){
            if(P[i-1] > P[i]){
                sorted = false;
            }
        }
        return sorted;
    }
    
    public void flip(int bFlip){
        int[] holder = new int[bFlip + 1];
        for(int i = 0; i < holder.length; i++){
            holder[i] = P[i];
        }
        for(int i = 0; i < holder.length; i++){
            P[holder.length - i -1] = holder[i];
        }
    }
    
    public static void main(String[] args) {
       Main m=new Main();
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            int[] flips;
            String newStack = "";
            String oldStack = input.nextLine();
            String[] temp = oldStack.split(" ");
            int[] stack = new int[temp.length];
            for(int i = 0; i < temp.length; i++){
                stack[i] = Integer.parseInt(temp[i]);
            }
            flips = m.Solve(stack);
            System.out.println("" + oldStack);
                for(int i = 0; flips[i] != 0 && i < flips.length; i++){
                    newStack += flips[i] + " ";
                }
            newStack += 0;
            System.out.println("" + newStack);
        }
    }
    
}


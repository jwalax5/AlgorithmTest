public class Sorting {
    public void run() {
        int[] unsortedArray = new int[]{3,1,34,6,11,77,2,4,0,99,35};
        int pivot = unsortedArray.length-1; // default is rightmost;
        int finalPosition = 0;
        int[] result = quicksort(unsortedArray,finalPosition,pivot);
        System.out.println("sort array :");
        for(int num : result) {
            System.out.print(" " +num);
        }

    }

    public int[] quicksort(int[] input,int left,int right){
        // base case
        if(left >= right)
            return input;
        int finalPosition = left;
        // find pivot -> final position of pivot -> seperate left and right
        for(int i=left ;i< right;i++){
            if(input[i]<input[right]){
                swap(input,finalPosition,i);
                finalPosition++;
            }
        }
        // swap pivot to finalPosition
        swap(input, finalPosition, right);
        
        // sort both left and right side
        quicksort(input,left,finalPosition-1);
        quicksort(input,finalPosition+1,input.length-1);

        return input;
    }

    public void swap(int[] input, int leftIndex,int rightIndex){
        if(leftIndex == rightIndex)
            return;
        int temp = input[leftIndex];
        input[leftIndex] = input[rightIndex];
        input[rightIndex] = temp;
    }
}

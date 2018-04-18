package networkCabling;

public class HeapSort{
    private static int total;
    
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    private static void heapify(int[] arr, int i){
        int left = 2*i;
        int right = 2*i+1;
        int index = i;
        
        if(left <= total && arr[left] >= arr[index]){
            index = left;
        }
        if(right <= total && arr[right] >= arr[index]){
            index = right;
        }
        if(index != i){
            swap(arr,i,index);
            heapify(arr,index);
        }
    }
    
    public static void sort(int[] arr){
        total = arr.length - 1;
        for(int i=total/2; i>=0; i--){
            heapify(arr,i);
        }
        for(int i=total; i>0; i--){
            swap(arr,0,i);
            total--;
            heapify(arr,0);
        }
    }
}

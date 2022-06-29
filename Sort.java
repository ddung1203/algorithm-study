import java.util.Scanner;

public class Sort {
    public static void main(String args[]) {
        int[] list = new int[10];
        for(int i = 0; i < list.length; i++) {
            double x = Math.random()*10;
            list[i] = (int) x;
        }
        System.out.print("이전: ");
        for(int j = 0; j < list.length; j++) {
            System.out.print(list[j]);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("\n1: 삽입 \n2: 버블 \n3: 선택 \n4: 합병 \n5: 퀵\n6: 힙\n");
        int select = sc.nextInt();
        switch (select) {
            case 1:
                insertSort(list);
            case 2:
                bubbleSort(list);
            case 3:
                selectionSort(list);
            case 4:
                mergeSort(list);
            case 5:
                quickSort(list);
            case 6:
                heapSort(list);
            default:
                break;
        }
        System.out.print("\n이후: ");
        for(int j = 0; j < list.length; j++) {
            System.out.print(list[j]);
        }

    }


    private static void insertSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i] < list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    private static void bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length-1; j++) {
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int index = i;

            for (int j = i; j < list.length; j++) {
                if (list[index] > list[j]) {
                    index = j;
                }
            }

            int temp = list[index];
            list[index] = list[i];
            list[i] = temp;
        }
    }

    private static void mergeSort(int[] list) {
        int[] temp = new int[list.length];
        merge(list, temp, 0, list.length-1);

    }

    private static void merge(int[] list, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge(list, temp, start, mid);
            merge(list, temp, mid+1, end);

            int p = start;
            int q = mid + 1;
            int index = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && list[p]< list[q])) {
                    temp[index++] = list[p++];
                } else{
                    temp[index++] = list[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                list[i] = temp[i];
            }
        }
    }

    private static void quickSort(int[] list) {
        quick(list, 0, list.length - 1);
    }

    private static void quick(int[] list, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partition(list, low, high);
        quick(list, low, mid - 1);
        quick(list, mid, high);
    }

    private static int partition(int[] list, int low, int high) {
        int pivot = list[(low + high) / 2];
        while(low <= high) {
            while (list[low] < pivot) {
                low++;
            }
            while (list[high] > pivot) {
                high--;
            }
            if (low <= high) {
                int temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }
        }
        return low;
    }

    private static void heapSort(int[] list) {
        for (int i = list.length/2-1; i >= 0; i--) {
            heap(list, list.length, i);
        }
        for (int i = list.length-1; i >= 0; i--) {
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
        }
    }

    private static void heap(int[] list, int length, int node) {
        int parent = node;
        int left = node*2 + 1;
        int right = node*2 + 2;

        if (length > left && list[parent] < list[right]) {
            parent = left;
        }
        if (length > right && list[parent] < list[right]) {
            parent = right;
        }
        if (parent != node) {
            int temp = list[node];
            list[node] = list[parent];
            list[parent] = temp;
            heap(list, length, parent);
        }

    }
}

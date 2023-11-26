import java.util.List;

public class FloatSort {
    private List<Float> unsorted;
    public FloatSort(List<Float> unsorted) {
        this.unsorted = unsorted;
    }

    public void quickSort()
    {
        quickSortAlgorithm(unsorted,0,unsorted.size()-1);
    }

    private void quickSortAlgorithm(List<Float> lst,int left,int right)
    {
        // Base case, left must be smaller than right
        if (left>=right)
        {
            return;
        }
        // Select pivot
        Float pivot = lst.get((int) ((left+right)/2));

        // Sort numbers with using pivot
        int idx = partition(lst,left,right,pivot);

        // Do sorting for smaller numbers than pivot
        quickSortAlgorithm(lst,left,idx-1);
        // Do sorting for bigger numbers than pivot
        quickSortAlgorithm(lst,idx,right);
    }

    private int partition(List<Float> lst, int left, int right, Float pivot)
    {
        // Loop will continue until right smaller than left
        while (left<=right)
        {
            // Loop will continue until it finds bigger
            // number than pivot on the left side of list
            while (lst.get(left)<pivot)
            {
                left++;
            }
            // Loop will continue until it finds smaller
            // number than pivot on the right side of list
            while (lst.get(right)>pivot)
            {
                right--;
            }
            // If left smaller or equal to right it means that
            // there is a number bigger than pivot on the left side
            // and there is a number smaller than pivot on the right
            // side. It will change those numbers.
            if (left<=right)
            {
                Float temp = lst.get(left);
                lst.set(left, lst.get(right));
                lst.set(right,temp);

                left++;
                right--;
            }
        }
        return left;
    }

}

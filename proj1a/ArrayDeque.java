import java.io.ObjectStreamException;

public class ArrayDeque<item> {
    private int size;
    private item[] arry;


    public ArrayDeque() {
        size = 0;
        this.arry = (item[]) new Object[8];

    }

    public void resize(int capacity) {
        item[] a = (item[]) new Object[capacity];
        System.arraycopy(arry, 0, a, 0, size);
        arry = a;
    }

    public void addLast(item x) {
        if (size==arry.length) {
            this.resize(arry.length+1);
        }
        this.arry[size] = x;
        size += 1;
    }


    public void addFirst(item x) {
        item[] a=(item[]) new Object[size+1];
        System.arraycopy(arry,0, a, 1,size);
        arry=a;
        arry[0]=x;
        size+=1;
    }
    public int size(){ return this.size;}
    public item get(int index){
        return arry[index];
    }
    public item getLast(){
        return arry[size-1];
    }
    public void printarray(){
        int i=0;
        while (i<size){
            System.out.print(arry[i]+" ");
            i+=1;
        }
    }
    public item removeLast(){
        item remove_item=arry[size-1];
        arry[size-1]=null;
        size-=1;
        this.resize(size);
        return remove_item;
    }
    public item removeFirst(){
        item remove_item=arry[0];
        arry[0]=null;
        size-=1;
        item[] a=(item[]) new Object[size];
        System.arraycopy(arry,1,a,0,size);
        arry=a;
        return remove_item;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

}







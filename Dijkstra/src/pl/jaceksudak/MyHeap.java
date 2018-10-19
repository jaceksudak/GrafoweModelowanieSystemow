package pl.jaceksudak;

public class MyHeap<T extends Heapable & Comparable<T>> {

    private T[] heap;
    private int size;

    public MyHeap(T[] heap) {
        this.heap = heap;
        this.size = 0;
    }

    public void addNode(T node) {
        heap[size] = node;
        node.setHeapPosition(size);
        size++;
    }

    public T extractRoot() {
        T root = heap[0];
        root.setHeapPosition(null);
        heap[0] = heap[size - 1];
        heap[0].setHeapPosition(0);
        size--;
        shiftDown(0);
        return root;
    }

    private void shiftDown(int position) {
        T t = heap[position];
        T tLeftChild = heap[2 * position + 1];
        T tRightChild = heap[2 * position + 2];
        T minChild;
        if (2 * position + 1 > size - 1) {
            return;
        } else if (2 * position + 2 > size - 1) {
            minChild = tLeftChild;
        } else {
            minChild = tLeftChild.compareTo(tRightChild) < 0 ? tLeftChild : tRightChild;  //TODO: check
        }
        if (t.compareTo(minChild) > 0) {
            heap[position] = minChild;
            heap[minChild.getHeapPosition()] = t;
            t.setHeapPosition(minChild.getHeapPosition());
            minChild.setHeapPosition(position);
            shiftDown(t.getHeapPosition());
        }
    }

    public void shiftUp(int position) {
        if (position == 0) {
            return;
        }
        T t = heap[position];
        T tParent = position % 2 == 0 ? heap[(position - 2) / 2] : heap[(position - 1) / 2];
        if (t.compareTo(tParent) < 0) {
            heap[position] = tParent;
            heap[tParent.getHeapPosition()] = t;
            t.setHeapPosition(tParent.getHeapPosition());
            tParent.setHeapPosition(position);
            shiftUp(t.getHeapPosition());
        }
    }
}

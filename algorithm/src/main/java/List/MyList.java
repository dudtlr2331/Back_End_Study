import java.util.Arrays;

public class MyList<E> {
    private Object[] elements; // 데이터를 저장할 배열
    private int size;          // 실제 데이터 개수

    public MyList() {
        elements = new Object[10]; // 초기 용량 10
        size = 0;
    }

    // 요소 추가
    public void add(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 특정 인덱스 값 가져오기
    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    // 특정 인덱스 값 삭제
    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // 마지막 요소 null로 초기화
    }

    // 현재 저장된 데이터 개수
    public int size() {
        return size;
    }

    // 배열 용량 늘리기
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    // 인덱스 범위 확인
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("Java");
        list.add("Spring");
        list.add("JPA");

        System.out.println("2번 인덱스 값: " + list.get(2)); // JPA

        list.remove(1);
        System.out.println("삭제 후 크기: " + list.size()); // 2
        System.out.println("1번 인덱스 값: " + list.get(1)); // JPA
    }
}
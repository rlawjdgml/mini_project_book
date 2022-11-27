package edu.java.review16;

import java.util.ArrayList;

public class ListMain {

    public static void main(String[] args) {
        // 배열(array): 한 가지 타입의 값들을 여러 개 저장할 수 있는 데이터 타입.
        String[] names = {"scott", "tiger"};
        System.out.println(names[0]); // 배열의 인덱스는 0부터 시작.
        System.out.println(names[1]);
        
        // 배열의 단점: 배열이 처음 생성될 때의 크기(길이, 원소의 개수)를 바꿀 수 없음.
        int[] numArray = new int[2]; // int 2개를 저장할 수 있는 배열을 생성.
        numArray[0] = 100; // 배열의 인덱스 0번 위치에 100을 저장.
        numArray[1] = 200;
        System.out.println(numArray[0]);
        System.out.println(numArray[1]);
//        numArray[2] = 300; //-> ArrayIndexOutOfBoundsException (에러) 발생
        System.out.println("numArray=" + numArray);
        
        // 리스트(list): 배열과 비슷한데, 원소들을 추가/삭제할 수 있는 데이터 타입.
        // ArrayList<E>, LinkedList<E>, ...
        // E: 리스트가 저장하는 원소(element)의 타입(클래스).
        // 리스트의 원소 타입은 반드시 클래스 이름만 사용해야 함.
        // 기본 타입 이름들은 리스트의 원소 타입으로 사용할 수 없음.
        // 기본 타입: byte, short, int, long, char, float, double, boolean
        // 기본 타입 클래스: Byte, Short, Integer, Long, Character, Float, Double, Boolean
        
        // 정수(int)들을 저장할 수 있는 ArrayList 객체 생성.
        ArrayList<Integer> numList = new ArrayList<>(); // new ArrayList<Integer>();와 같음.
        System.out.println("size=" + numList.size()); // 리스트의 원소 개수(크기)
        System.out.println("numList=" + numList);
        
        // 리스트에 원소 추가
        numList.add(100);
        System.out.println("size=" + numList.size());
        System.out.println("numList=" + numList);
        
        numList.add(101);
        numList.add(200);
        System.out.println("size=" + numList.size());
        System.out.println("numList=" + numList);
        
        // 리스트에서 특정 인덱스(위치)에 있는 값을 읽어오기.
        System.out.println(numList.get(1));
        
        // 리스트에서 특정 인덱스에 있는 값을 삭제하기.
        numList.remove(1);
        System.out.println("numList=" + numList);
        
        // 리스트에서 원소의 값으로 삭제하기.
        numList.remove(Integer.valueOf(100));
        System.out.println("numList=" + numList);
    }

}

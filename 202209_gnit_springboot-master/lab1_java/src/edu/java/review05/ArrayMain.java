package edu.java.review05;

public class ArrayMain {

    public static void main(String[] args) {
        // 배열(array): 하나의 변수 이름에 같은 타입의 값들을 여러개 저장하기 위한 타입.
        // 배열에서 저장된 값들을 구분하기 위해서 인덱스를 사용.
        // 배열의 인덱스는 0부터 시작. 배열의 마지막 인덱스는 (원소 개수 - 1).
        
        // 정수 5개를 저장하는 배열
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
        
        numbers[2] = 100;
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();

        // 문자열들을 저장하는 배열
        String[] names = {"Scott", "Tiger", "King"};
        System.out.println(names);
        
        // 향상된 for 문장(enhanced for statement, for-each 문장)
        // for (변수 선언 : 배열) { 반복할 문장들; }
        for (String s : names) {
            System.out.print(s + ", ");
        }
        System.out.println();
        
        // 정수 5개를 저장할 수 있는 배열 선언, 생성
        // 타입[] 변수이름 = new 타입[원소 개수];
        int[] intArray = new int[5]; // 5개의 값이 모두 0인 정수 배열이 생성됨.
        for (int x : intArray) {
            System.out.print(x + ", ");
        }
        System.out.println();
        
        // 배열 intArray에 1, 3, 5, 7, 9를 차례로 저장.
//        intArray[0] = 1;
//        intArray[1] = 3;
//        intArray[2] = 5;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = 2 * i + 1;
        }
        
        for (int x : intArray) {
            System.out.print(x + ", ");
        }
        System.out.println();
        
    }

}

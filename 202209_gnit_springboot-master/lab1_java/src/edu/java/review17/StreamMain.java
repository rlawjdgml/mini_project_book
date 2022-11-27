package edu.java.review17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// List<E>
// |__ ArrrayList<E>, LinkedList<E>, ...

public class StreamMain {

    public static void main(String[] args) {
        // 정수들을 저장하는 List를 생성.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 10, 20, 30, 40);
        System.out.println(numbers);
        
        // 리스트 numbers에서 짝수들만 출력.
        for (Integer x : numbers) {
            if (x % 2 == 0) {
                System.out.print(x + ", ");
            }
        }
        System.out.println(); // 줄바꿈

        numbers.stream() // 리스트를 Stream 객체로 변환 - 리스트의 원소들이 순차적으로 지나가는 통로
            .filter(x -> x % 2 == 0) // 람다(함수)가 true를 리턴하는 원소들만 통과시키는 통로(필터)
            .forEach(x -> System.out.print(x + ", ")); // 람다(함수)를 순차적으로 실행.
        
        System.out.println("\n----------");
        
        // 리스트 numbers의 원소들 중에서 홀수들의 제곱을 저장하는 새로운 리스트를 생성.
        List<Integer> oddSquares = new ArrayList<>(); // 빈 리스트
        for (Integer x : numbers) { // numbers의 원소들을 하나씩 꺼내면서 마지막 원소까지 반복
            if (x % 2 == 1) { // 원소가 홀수이면
                oddSquares.add(x * x); // 홀수 제곱을 리스트에 추가.
            }
        }
        System.out.println(oddSquares);
        
        List<Integer> oddSquares2 = numbers.stream() // 리스트 원소가 지나가는 통로
                .filter(x -> x % 2 == 1) // 홀수들만 필터링
                .map(x -> x * x) // 홀수를 홀수 제곱으로 매핑
                .toList(); // 결과를 List로 수집.
        System.out.println(oddSquares2);
        
        System.out.println("----------");
        
        // numbers의 원소들 중에서 홀수들의 제곱의 합을 계산.
        int sum = 0; // 홀수의 제곱들의 합을 저장할 변수. sum = 1*1 + 3*3 + ...
        for (Integer x : numbers) {
            if (x % 2 == 1) {
                sum += x * x;
            }
        }
        System.out.println("sum=" + sum);
        
        sum = numbers.stream() // 리스트의 원소들이 하나씩 순차적으로 지나가는 통로
                .filter(x -> x % 2 == 1) // 홀수들을 필터링
                .mapToInt(x -> x * x) // 홀수를 홀수의 제곱으로 매핑
                .sum(); // 결과들을 모두 더함.
        System.out.println("sum=" + sum);
        
    }

}

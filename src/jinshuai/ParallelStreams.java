/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;

import java.util.function.Function;
import java.util.stream.*;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ConcurrentMap;
/**
 *
 * @author Planck
 */
public class ParallelStreams {
    public void orderSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        System.out.println("---顺序流运行结果 sum的值---\r\n" + result);
    }
    public void parallelSum(long n) {
        long result = Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println("---并行流运行结果 sum的值---\r\n" + result);
    }
    public static long meaureParallelSumTest(Function<Long, Long> adder, long n) {
        long fastestTime = Long.MAX_VALUE;//将fastestTime设为long.MAX_VALUE可以保证所有duration都不会比fsatestTime大
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();//开始时间
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - startTime) / 1000000;
            if (duration < fastestTime) {
                fastestTime = duration;//记录最短的一次
            }
        }
        return fastestTime;
    }

    public static void main(String args[]){
//        System.out.println("---并行流的最快时间---\r\n" + meaureParallelSumTest(ParallelStreams::parallelSum, 10000000) + "msecs");
//        System.out.println("---顺序流的最快时间---\r\n" + meaureParallelSumTest(ParallelStreams::orderSum, 10000000) + "msecs");
    }
}

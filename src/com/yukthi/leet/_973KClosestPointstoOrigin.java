package com.yukthi.leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _973KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
//         List<Point> pts = new ArrayList<>();
//         for(int[] p: points ){
//             pts.add(new Point(p));
//         }

//         Collections.sort(pts, (p1, p2) -> {
//            if(p1.dist < p2.dist) {
//                return -1;
//            } else if(p1.dist > p2.dist) {
//                return 1;
//            } else {
//                return 0;
//            }
//         });
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double d1 = Math.pow(o1[0], 2) + Math.pow(o1[1], 2);
                double d2 = Math.pow(o2[0], 2) + Math.pow(o2[1], 2);
                if(d1 > d2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        Arrays.sort(points, comparator);

        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++) {
            res[i] = points[i];
        }
        return res;
    }

    public class Point {
        int[] p;
        double dist;

        public Point(int[] p) {
            this.p = p;
            dist = Math.pow(p[0], 2) + Math.pow(p[1], 2);
        }
    }
}

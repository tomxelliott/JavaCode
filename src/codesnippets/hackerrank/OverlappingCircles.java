import java.util.*;
import java.lang.Math.*;
import static java.lang.Math.abs;

class OverlappingCircles {
    public double solution(int x1, int y1, int r1, int x2, int y2, int r2) {
        // Manhattan Distance
        double distance = Math.hypot(x2-x1, y2-y1);
        double result = 0.0;
        if(distance < r1+r2) {
            double radiusC1 = r1 * r1;
            double radiusC2 = r2 * r2;
            
            double x = (radiusC1 - radiusC2 + distance * distance) / (2 * distance);
            double z = x * x;
            double y = Math.sqrt(radiusC1 - z);
        
        if(distance < abs(r2 - r1)) {
            result = Math.PI * Math.min(radiusC1, radiusC2);
        }
        result = radiusC1 * Math.asin(y/r1) + radiusC2 * Math.asin(y / r2) - y * (x + Math.sqrt(z + radiusC2 - radiusC1));
    }
    return result;
}

  public static void main(String[] args){
    solution(1,1,3,5,5,3);  
}
}

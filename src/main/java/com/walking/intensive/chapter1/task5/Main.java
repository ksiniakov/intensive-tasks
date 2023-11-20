package com.walking.intensive.chapter1.task5;

import java.lang.reflect.Array;

/**
 * Условие: <a href="https://geometry-math.ru/homework/Java-triangle.html">ссылка</a>
 */
public class Main {
    public static void main(String[] args) {
        printInfo(10, 15, 17);
    }

    static String arrayToString(double[] arr) {
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
            if (i + 1 < arr.length) {
                result = result + ", ";
            }
        }
        result = result + "]";
        return result;
    }

    static void printInfo(double a, double b, double c) {
        String params = "(" + a + ", " + b + ", " + c + ")\t";
        System.out.println("getAreaByHeron" + params + getAreaByHeron(a, b, c));
        System.out.println("getHeights" + params + arrayToString(getHeights(a, b, c)));
        System.out.println("getMedians" + params + arrayToString(getMedians(a, b, c)));
        System.out.println("getBisectors" + params + arrayToString(getBisectors(a, b, c)));
        System.out.println("getAngles" + params + arrayToString(getAngles(a, b, c)));
        System.out.println("getInscribedCircleRadius" + params + getInscribedCircleRadius(a, b, c));
        System.out.println("getCircumradius" + params + getCircumradius(a, b, c));
        System.out.println("getAreaAdvanced" + params + getAreaAdvanced(a, b, c));

    }

    static double getHalfOfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static double getAreaByHeron(double a, double b, double c) {
        double p = getHalfOfPerimeter(a, b, c);

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Располагайте высоты по возрастанию.
     */
    static double[] getHeights(double a, double b, double c) {
        double p = getHalfOfPerimeter(a, b, c);
        double[] result = new double[3];
        double s = getAreaByHeron(a, b, c);

        result[0] = 2 * s / a;
        result[1] = 2 * s / b;
        result[2] = 2 * s / c;

        return result;
    }

    static double getMedianByThreeSides(double a, double b, double c) {
        return Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;
    }

    /**
     * Располагайте медианы по возрастанию.
     */
    static double[] getMedians(double a, double b, double c) {
        double[] result = new double[3];

        result[0] = getMedianByThreeSides(a, b, c);
        result[1] = getMedianByThreeSides(c, b, a);
        result[2] = getMedianByThreeSides(a, c, b);

        return result;
    }

    static double getOneBisectorByHalfPerimeterAndThreeSides(double a, double b, double c) {
        return (2 * Math.sqrt(a * b * getHalfOfPerimeter(a, b, c) * (getHalfOfPerimeter(a, b, c) - c))) / (a + b);
    }

    /**
     * Располагайте биссектрисы по возрастанию.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] result = new double[3];

        result[0] = getOneBisectorByHalfPerimeterAndThreeSides(a, b, c);
        result[1] = getOneBisectorByHalfPerimeterAndThreeSides(c, b, a);
        result[2] = getOneBisectorByHalfPerimeterAndThreeSides(a, c, b);

        return result;
    }

    static double getOneAngleByThreeSides(double a, double b, double c) {
        return Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
    }

    /**
     * Располагайте углы по возрастанию.
     */
    static double[] getAngles(double a, double b, double c) {
        double[] result = new double[3];

        result[0] = getOneAngleByThreeSides(a, b, c);
        result[1] = getOneAngleByThreeSides(c, b, a);
        result[2] = getOneAngleByThreeSides(a, c, b);

        return result;
    }

    static double getInscribedCircleRadius(double a, double b, double c) {
        double p = getHalfOfPerimeter(a, b, c);

        return Math.sqrt(((p - a) * (p - b) * (p - c)) / p);
    }

    static double getCircumradius(double a, double b, double c) {
        double p = getHalfOfPerimeter(a, b, c);

        return a * b * c / (4 * Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }

    static double getAreaAdvanced(double a, double b, double c) {

        return a * b * Math.cos(getOneAngleByThreeSides(a, b, c)) / 2; // Заглушка. При реализации - удалить
    }
}
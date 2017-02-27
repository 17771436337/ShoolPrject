package prject.shool.src.com.shoolprject.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数学类
 */
public class MathsUtil {

    /*
     * bits 小数点保留的位数
     */
    public static float getAccurateFloat(float value, int bits) {
        BigDecimal b = new BigDecimal(value);
        return b.setScale(bits, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /*
     * bits 小数点保留的位数
     */
    public static double getAccurateDouble(double value, int bits) {
        BigDecimal b = new BigDecimal(value);
        return b.setScale(bits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /*
     * 判断是否为数字，包括整数和小数
     */
    public static boolean isNumber(String str) {
        String reg = "\\d+\\.{0,1}\\d*";
        return str.matches(reg);
    }

    /*
     * 判断是否含汉字
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /*
     * 是否包含英文字母
     */
    public static boolean includeCharacter(String str) {
        Pattern NumberPattern = Pattern.compile("[a-zA-Z]");

        Matcher m = NumberPattern.matcher(str);
        if (m.find()) {
            return true;
        }

        return false;
    }

    /*
     * 只能包含英文字母、汉字、数字和下划线，且要求以英文或者汉字开头
     */
    public static boolean includeCnc(String str) {
        Pattern NumberPattern = Pattern
                .compile("^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9_\u4e00-\u9fa5]+$");

        Matcher m = NumberPattern.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /*
     * 只能包含英文字母、数字和下划线
     */
    public static boolean includeCharacterNumber(String str) {
        Pattern NumberPattern = Pattern.compile("^[\\w]+$");

        Matcher m = NumberPattern.matcher(str);
        if (m.find()) {
            return true;
        }

        return false;
    }


    // float和double只能用来做科学计算或者是工程计算，在商业计算中我们要用java.math.BigDecimal

    public static double add(double d1, double d2) { // 进行加法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).doubleValue();
    }

    public static double sub(double d1, double d2) { // 进行减法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).doubleValue();
    }

    public static double round(double d, int len) { // 进行四舍五入

        BigDecimal b1 = new BigDecimal(d);
        BigDecimal b2 = new BigDecimal(1);
        // 任何一个数字除以1都是原数字
        // ROUND_HALF_UP是BigDecimal的一个常量，表示进行四舍五入的操作
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 数字字符串转化为double
     */
    public static double string2double(String str) {
        return Double.parseDouble(str);
    }

    /**
     * 两点间的距离
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.abs(x1 - x2) * Math.abs(x1 - x2)
                + Math.abs(y1 - y2) * Math.abs(y1 - y2));
    }

    /*
     * 两点之间连线的角度
     */
    public static float getlLineDegrees(double x1, double y1, double x2,
                                        double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double x = Math.abs(x2 - x1);
        double y = Math.abs(y2 - y1);
        double degreens = 0;

        if (dx > 0 && dy > 0) {// 顺时针 象限1
            degreens = Math.toDegrees(Math.atan2(y, x));
        }
        if (dx < 0 && dy > 0) {// 2
            degreens = Math.toDegrees(Math.atan2(x, y)) + 90;
        }
        if (dx < 0 && dy < 0) {// 3
            degreens = Math.toDegrees(Math.atan2(y, x)) + 180;
        }
        if (dx > 0 && dy < 0) {// 4
            degreens = Math.toDegrees(Math.atan2(x, y)) + 270;
        }

        if (dy == 0 && dx > 0) {
            degreens = 0;
        }
        if (dy == 0 && dx < 0) {
            degreens = 180;
        }
        if (dx == 0 && dy > 0) {
            degreens = 90;
        }
        if (dx == 0 && dy < 0) {
            degreens = 270;
        }
        return (float) degreens;
    }

    /**
     * 计算点a(x,y)的角度
     *
     * @param x
     * @param y
     * @return
     */
    public static double pointTotoDegrees(double x, double y) {
        return Math.toDegrees(Math.atan2(x, y));
    }

    /*
     * 判断是否整数
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 点在圆内
     *
     * @param sx 当前x坐标
     * @param sy 当前y坐标
     * @param r  圆半径
     * @param x  圆心x坐标
     * @param y  圆心y坐标
     * @return
     */
    public static boolean checkInRound(float sx, float sy, float r, float x,
                                       float y) {
        return Math.sqrt((sx - x) * (sx - x) + (sy - y) * (sy - y)) < r;
    }

    /**
     * 保留两位小数 DecimalFormat转换最简便
     */
    public static String numFormat2p(double dNum) {
        if (dNum == 0) {
            return "0.00";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(dNum);
    }

    /**
     * 添加 千位分隔符 x,xxx.xx
     */
    public static String numFormat(double dNum) { // dNum: xxxx.xx
        String numAll = numFormat2p(dNum);

        String endNum = numAll.substring(numAll.indexOf("."), numAll.length());
        String numHead = numAll.substring(0, numAll.indexOf("."));
        StringBuffer ret = new StringBuffer();
        if (numHead.length() <= 3) {
            return numAll;
        } else {
            for (int i = numHead.length() - 1; i >= 0; i--) {
                ret.append(numHead.charAt(i));
                if ((numHead.length() - i) % 3 == 0) {
                    ret.append(",");
                }
            }
            numHead = ret.reverse().toString() + endNum;
            if (numHead.startsWith(",")) {
                numHead = numHead.substring(1, numHead.length());
            }
        }

        return numHead;
    }

    /**
     * 添加 千位分隔符 x,xxx.xx
     */
    public static String addSeparator(String numStr) { // numStr: "xxxx.xx"
        String numHead, numEnd;
        if (numStr.contains(".")) {//有小数部分
            numEnd = numStr.substring(numStr.indexOf("."), numStr.length());
            numHead = numStr.substring(0, numStr.indexOf("."));
        } else {//没有小数
            numHead = numStr;
            numEnd = ".00";
        }
        StringBuffer ret = new StringBuffer();
        if (numHead.length() <= 3) {
            return numStr;
        } else {
            for (int i = numHead.length() - 1; i >= 0; i--) {
                ret.append(numHead.charAt(i));
                if ((numHead.length() - i) % 3 == 0) {
                    ret.append(",");
                }
            }
            numHead = ret.reverse().toString() + numEnd;
            if (numHead.startsWith(",")) {
                numHead = numHead.substring(1, numHead.length());
            }
        }

        return numHead;
    }

    /**
     * 四舍五入取整 3.246 -->3 6.703 -->8
     */
    public static double numRounding(double d) {
        d = Math.round((int) (d * 10) / 10.0);
        return d;
    }

    /**
     * 给参数返回指定小数点后 a 位的四舍五入
     *
     * @param sourceData 要取舍的原数据
     * @param a          小数点 后的 位数（如：10：小数点后1位；100：小数据后2位以此类推）
     * @return 舍取后的 数据
     */
    public static float getFloatRound(double sourceData, int a) {
        int i = (int) Math.round(sourceData * a);     //小数点后 a 位前移，并四舍五入
        float f2 = (float) (i / (float) a);        //还原小数点后 a 位
        return f2;
    }


    //---------------------------------------

    /**
     * 随机某一区间的整数值
     *
     * @param min 最小数
     * @param max 最大数
     * @return 【min,max】
     */
    public static int getRandomNumber(int min, int max) {
        return Math.abs(new Random().nextInt() % (max - min + 1)) + min;
    }

    public static int[] createRandomArray(int min, int max, int size) {
        int[] list = new int[size];
        int count = 0; // 计数
        int num = 0; // 随机数
        int i;
        // 初始化数组
        for (i = 0; i < list.length; i++) {
            list[i] = -1;
        }
        // 填充数组元素
        do {
            num = (int) getRandomNumber(min, max);
            // 判断元素是否存在数组中
            for (i = 0; i < list.length; i++) {
                if (list[i] == num) {
                    break;
                }
            }
            // 不存在则装入
            if (i >= list.length) {
                list[count] = num;

                count++;
            }
        } while (count < size);

        return list;
    }

    public static int[] sorting(int min, int max, int size) {
        int[] list = createRandomArray(min, max, size);
        int temp;
        // 第一层循环:表明比较的次数, 比如 length 个元素,比较次数为 length-1 次（肯定不需和自己比）
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = list.length - 1; j > i; j--) {
                if (list[j] < list[j - 1]) {
                    temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }

        return list;
    }
}

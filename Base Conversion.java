public class Solution {
	// 用Integer.toBinaryString()检查了输出，感觉应该有更简洁的写法
	public String oct2Bin(int a) {
        if (a == 0) {
            return "0";
        }
        int flag = a;
        StringBuilder sb = new StringBuilder();
        if (a < 0) {
            a ^= Integer.MAX_VALUE + 1;
        }
        while (a > 0) {
            int mod = a & 1;
            sb.append(mod);
            a >>= 1;
        }
        if (flag < 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }


    public String transform(String s, int radixSrc, int radixTgt) {
        int src = Integer.parseInt(s);
        int oct = 0;
        int pos = 1;
        while (src > 0) {
            int digit = src % 10;
            oct += digit * pos;
            pos *= radixSrc;
            src /= 10;
        }
        StringBuilder sb = new StringBuilder();
        while (oct > 0) {
            int mod = oct & (radixTgt - 1);
            sb.append(mod);
            oct >>= (radixTgt - 1);
        }
        return sb.reverse().toString();
    }
}
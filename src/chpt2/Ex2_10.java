package chpt2;
class Ex2_10 {

    public static void main (String[] args){
         
        // 结果为3
        int result = 1 + 2;
        System.out.println(result);

        // 结果为 2
        result = result - 1;
        System.out.println(result);

        //结果为 4
        result = result * 2;
        System.out.println(result);

        // 结果为2
        result = result / 2;
        System.out.println(result);

        // 结果为 10
        result = result + 8;
        // 结果为 3
        result = result % 7;
        System.out.println(result);
    }
}

public class HugeIntegerMain {
    public static void main(String args[]) {
        HugeInteger largeInt1 = new HugeInteger();
        HugeInteger largeInt2 = new HugeInteger();
        largeInt1.parse("123456789");
        largeInt2.parse("987654321");
        System.out.println(largeInt1.add(largeInt2));
        System.out.println(largeInt1.subtract(largeInt2));
    }
}

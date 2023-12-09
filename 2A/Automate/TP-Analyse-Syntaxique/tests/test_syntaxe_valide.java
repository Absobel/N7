class TestClass {
    private int a;

    public float method1(int a, int b) {
        return a + b;
    }
}

class Test {
    public static void main(String[] args) {
        TestClass test_class = new TestClass();
        test_class.method1(1, 2);

        int b = -2;
        boolean c = !true;
        boolean d = 3 <= 4;
    }
}
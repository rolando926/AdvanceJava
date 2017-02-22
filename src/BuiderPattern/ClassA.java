package BuiderPattern;

/**
 * Created by RXC8414 on 2/13/2017.
 */
public class ClassA {
    private int field1;
    private boolean blnTrue;
    private String string;

    private ClassA(int field1, boolean blnTrue, String string) {
        this.field1 = field1;
        this.blnTrue = blnTrue;
        this.string = string;
    }

    public static class ClassABuilder {
        private int field1;
        private boolean blnTrue;
        private String string;

        public ClassABuilder setField1(int field1) {
            this.field1 = field1;
            return this;
        }

        public ClassABuilder setBlnTrue(boolean blnTrue) {
            this.blnTrue = blnTrue;
            return this;
        }

        public ClassABuilder setString(String string) {
            this.string = string;
            return this;
        }

        public ClassA createClassA() {
            return new ClassA(field1, blnTrue, string);
        }
    }
}

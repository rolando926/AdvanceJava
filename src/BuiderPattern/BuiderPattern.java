package BuiderPattern;

/**
 * Created by RXC8414 on 2/8/2017.
 */
public class BuiderPattern {
    private String givenName;
    private String surName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;

    private BuiderPattern(String givenName, String surName, int age, String gender, String email, String phone, String address, String city, String state) {
        this.givenName = givenName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString(){
        return "First Name: "+givenName+
                "\nLast Name: "+surName+
                "\nAge: "+age+
                "\nGender: "+gender+
                "\nEmail: "+email+
                "\nPhone: "+phone+
                "\nAddress: "+address+
                "\nCity: "+city+
                "\nState: "+state;
    }

    public static class BuiderPatternBuilder {
        private String givenName;
        private String surName;
        private int age;
        private String gender;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String state;

        public BuiderPatternBuilder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public BuiderPatternBuilder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public BuiderPatternBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public BuiderPatternBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public BuiderPatternBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public BuiderPatternBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public BuiderPatternBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public BuiderPatternBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public BuiderPatternBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public BuiderPattern createBuiderPattern() {
            return new BuiderPattern(givenName, surName, age, gender, email, phone, address, city, state);
        }
    }
}

package com.jiaxy.giants.guava.hash;

import com.google.api.client.util.Charsets;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;

public class Main {

    public static void main(String[] args) {

        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person person, PrimitiveSink into) {
                into
                        .putInt(person.id)
                        .putString(person.firstName, Charsets.UTF_8)
                        .putString(person.lastName, Charsets.UTF_8)
                        .putInt(person.birthYear);
            }
        };

        HashFunction hf = Hashing.sha256();
        HashCode hc = hf.newHasher()
                .putLong(1)
                .putString("test", Charsets.UTF_8)
                .putObject(new Person(100, "t", "w", 1984), personFunnel)
                .hash();
        System.out.println(hc.toString().length() * 4);

    }

    public static class Person {

        final int    id;
        final String firstName;
        final String lastName;
        final int    birthYear;

        public Person(int id, String firstName, String lastName, int birthYear) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthYear = birthYear;
        }
    }

}

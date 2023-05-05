package ru.netology;

import java.util.function.Supplier;

public class PhoneBook {
    static Supplier<PhoneBook> instance = PhoneBook::new;

    int add (String name, String number) {
        return 0;
    }

    public PhoneBook() {
    }
}

package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PhoneBook {
    protected static Map<String, String> storage = new HashMap<>();
    static Supplier<PhoneBook> instance = PhoneBook::new;

    public int add (String name, String number) {
        if (!storage.containsKey(name)) {
            storage.put(name, number);
        }
        return storage.size();
    }

    public String findByNumber (String number) {
        if(storage.containsValue(number)) {
            return storage.entrySet().stream()
                    .filter(entry -> number.equals(entry.getValue()))
                    .findFirst().map(Map.Entry::getKey)
                    .orElse(null);
        }
        return  null;
    }

    public PhoneBook() {
    }
}

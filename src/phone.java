import java.util.*;

public class phone {
    private Map<String, List<String>> phoneBook;

    public phone() {
        phoneBook = new HashMap<>();
    }

    // Добавить телефонный номер для имени
    public void addPhoneNumber(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Получить список телефонных номеров для имени
    public List<String> getPhoneNumbers(String name) {
        return phoneBook.getOrDefault(name, Collections.emptyList());
    }

    // Получить телефонную книгу с сортировкой по убыванию числа телефонов
    public Map<String, List<String>> getSortedPhoneBook() {
        // Создаем список записей (имя и список номеров) из мапы
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонных номеров
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Создаем новую мапу на основе отсортированных записей
        LinkedHashMap<String, List<String>> sortedPhoneBook = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : entries) {
            sortedPhoneBook.put(entry.getKey(), entry.getValue());
        }

        return sortedPhoneBook;
    }

    public static void main(String[] args) {
        phone phoneBook = new phone();
        phoneBook.addPhoneNumber("Alice", "1234567890");
        phoneBook.addPhoneNumber("Bob", "9876543210");
        phoneBook.addPhoneNumber("Alice", "5555555555");

        Map<String, List<String>> sortedPhoneBook = phoneBook.getSortedPhoneBook();

        // Вывод телефонной книги с сортировкой по убыванию числа телефонов
        for (Map.Entry<String, List<String>> entry : sortedPhoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

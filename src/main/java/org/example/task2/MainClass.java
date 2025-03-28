package org.example.task2;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    private final Scanner scanner;
    private final PrintStream out;
    private final PersonDAO personDAO;

    public MainClass(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
        this.personDAO = new PersonDAO();
    }

    public void start() {
        try {
            while (true) {
                out.println("Введите команду : 1-вывести список, 2-добавить в список, 3-удалить запись из списка, 5-exit");
                String command = scanner.nextLine();
                switch (command) {
                    case "вывести список":
                    case "1":
                        listPersons();
                        break;
                    case "добавить в список":
                    case "2":
                        addPerson();
                        break;
                    case "удалить запись из списка":
                    case "3":
                        deletePerson();
                        break;
                    case "exit":
                    case "5":
                        out.println("Завершение работы.");
                        return;
                    default:
                        out.println("Неизвестная команда.");
                }
            }
        } finally {
            // Проверка, что EntityManagerFactory закрыт при завершении работы приложения
            PersonDAO.closeEntityManagerFactory();
        }
    }

    public void listPersons() {
        List<Person> persons;
        persons = personDAO.getAllPersons();
        if (persons == null || persons.isEmpty()) {
            out.println("Список пуст.");
        } else {
            for (Person person : persons) {
                out.println(person);
            }
        }
    }

    public void addPerson() {
        out.println("Введите имя :");
        String firstName = scanner.nextLine();
        out.println("Введите фамилию :");
        String lastName = scanner.nextLine();
        out.println("Введите возраст :");
        Integer age = Integer.valueOf(scanner.nextLine());

        Person person = new Person(firstName, lastName, age);
        personDAO.addPerson(person);
        out.println("Person добавлен.");
    }

    public void deletePerson() {
        out.println("Введите ID для удаления :");
        Long id = Long.valueOf(scanner.nextLine());

        if (personDAO.deletePerson(id)) {
            out.println("Person удален.");
        } else {
            out.println("Person с таким ID не найден.");
        }
    }
}
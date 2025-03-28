package org.example.task1;

public class MainFile {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Иван Петровский", 35);

        String filePath = "src/main/java/org/example/task1/person.dat"; // Путь к файлу для сериализации/десериализации
        SerializationMethode.serialize(person, filePath); // Сериализуем объект
        Person deserializedPerson = DeserializationMethode.deserialize(filePath); // Десериализуем объект
        System.out.println(deserializedPerson); // Выведет: Person{name : 'Иван Петровский', age : 35}
    }
}
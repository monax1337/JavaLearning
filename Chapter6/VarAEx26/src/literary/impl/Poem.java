package literary.impl;

import literary.LiteraryWork;

public class Poem implements LiteraryWork {
    @Override
    public void write() {
        System.out.println("Написание стихотворения...");
    }

    @Override
    public void edit() {
        System.out.println("Редактирование стихотворения...");
    }

    @Override
    public void publish() {
        System.out.println("Публикация стихотворения...");
    }

    @Override
    public void dedicate(String dedication) {
        System.out.println("Посвящение стихотворения: " + dedication);
    }

    @Override
    public void translate(String language) {
        System.out.println("Перевод стихотворения на язык: " + language);
    }

    @Override
    public void sellRights() {
        System.out.println("Продажа прав на использование стихотворения...");
    }

    @Override
    public void receiveCritique() {
        System.out.println("Получение критики на стихотворение...");
    }
}

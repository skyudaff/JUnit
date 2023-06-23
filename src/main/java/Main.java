public class Main {
    public static void main(String[] args) {

        Book book = new Book("Книга", 2020, new Author("Петя", "Иванов", 4), 80);

        System.out.println("Является ли книга большой? - " + book.isBig());
        System.out.println("Содержится ли в описании книги (названии или в имени или фамилии автора) слово? - " + book.matches("Ива"));
        System.out.println("Оценка стоимости книги: " + book.estimatePrice(book.pages, book.author.rating) + " руб");
    }
}
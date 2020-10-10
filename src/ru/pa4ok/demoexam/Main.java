package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        Book book = new Book(1, "title", "author", BookStatusEnum.IN_LIBRARY);
        System.out.println(book);
        //System.out.println(book.getStatus().getTranslate());

        book.setStatus(BookStatusEnum.valueOf("IN_TRANSFER"));
        System.out.println(book);

        for(BookStatusEnum e : BookStatusEnum.values()) {
            System.out.printf(e.name() + " ");
        }
        System.out.println();

        /*if(book.getStatus() == BookStatusEnum.IN_LIBRARY) {
            System.out.println("эта книга к библиотеке");
        }

        switch (book.getStatus())
        {
            case ON_HANDS:
                System.out.println(1);
                break;
            case IN_LIBRARY:
                System.out.println(2);
                break;
            case IN_TRANSFER:
                System.out.println(3);
                break;
        }*

         */
    }
}

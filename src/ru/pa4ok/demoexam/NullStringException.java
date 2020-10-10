package ru.pa4ok.demoexam;

//если была бы нужна ошибка не обязательная к обоработке, то я бы унаследовал RuntimeException
public class NullStringException extends Exception
{
    public NullStringException() {
    }

    public NullStringException(String message) {
        super(message);
    }

    public NullStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullStringException(Throwable cause) {
        super(cause);
    }

    public NullStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

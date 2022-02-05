package org.adnan.common;

public interface FileReaderStrategy<T> {
    public T readFile(String fileName, Class<T> cls) throws Exception;
}

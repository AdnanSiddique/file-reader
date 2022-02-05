package org.adnan.common;

import java.util.Objects;

public class FileReaderStrategyContext<T> {

    /**
     *   This is a proxy method which is reading xml or json files
     *   by using specific strategy for file reading depending on file format
     *   or return null if there is no strategy available for file format.
     **/
    public T readFile(String fileName, Class<T> cls ) throws Exception {
        FileReaderStrategy<T> readerStrategy = null;
        if(fileName.toLowerCase().endsWith(FileTypeEnum.XML.name().toLowerCase())) {
            readerStrategy = new XmlFileReaderStrategy<>();
        } else if(fileName.toLowerCase().endsWith(FileTypeEnum.JSON.name().toLowerCase())) {
            readerStrategy = new JsonFileReaderStrategy<>();
        }

        return !Objects.isNull(readerStrategy) ? readerStrategy.readFile(fileName, cls) : null;
    }

    private enum FileTypeEnum {
        XML,
        JSON;
    }
}

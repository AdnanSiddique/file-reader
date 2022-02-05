package org.adnan.common;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlFileReaderStrategy<T> implements FileReaderStrategy<T> {

    /**
     *   This method is used to read Xml format files
     **/
    @Override
    public T readFile(String fileName, Class<T> cls ) throws Exception {
        T result = null;
        try {
            final Unmarshaller jaxbUnmarshaller = JAXBContext.newInstance(cls).createUnmarshaller();
            result = (T) jaxbUnmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException ex) {
            System.out.println("**** Error while reading Xml file : " + fileName );
            System.out.println(ex.getMessage());
        }
        return result;
    }
}

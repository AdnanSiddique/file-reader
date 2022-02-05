package org.adnan.common;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResourceFilesLoader {
    /**
     * This util method is used to list path of all the files in resource folder
     */
    public static List<String> getResourceFilePaths() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String path = Objects.requireNonNull(loader.getResource("")).getPath();
        return Arrays.stream((Objects.requireNonNull(new File(path).listFiles()))).sequential()
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());
    }
}

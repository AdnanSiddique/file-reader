package org.adnan.reader;

import org.adnan.common.FileReaderStrategyContext;
import org.adnan.common.ResourceFilesLoader;
import org.adnan.model.SaleObjectWrapper;

import java.util.ArrayList;

public class SaleObjectFileReader  {

    /**
     * This method is reading Sale Objects files by using file reader strategy,
     */
    public SaleObjectWrapper readSaleObjectFiles() throws Exception {
        final SaleObjectWrapper result = new SaleObjectWrapper(0, new ArrayList<>());
        final  FileReaderStrategyContext<SaleObjectWrapper> fileReaderStrategyContext = new FileReaderStrategyContext<>();
        for (String path : ResourceFilesLoader.getResourceFilePaths()) {

            final SaleObjectWrapper saleObjectWrapper = fileReaderStrategyContext.readFile(path, SaleObjectWrapper.class);
            if (saleObjectWrapper != null) {
                if(saleObjectWrapper.getNumberOfSaleObjects() != saleObjectWrapper.getSaleObjects().size()) {
                    System.out.println("Error while reading file " + path + ", number of records do not represent correct value in provided file... ");
                    System.out.println("Mentioned Count : " + saleObjectWrapper.getNumberOfSaleObjects() + ", Actual number of records : " + saleObjectWrapper.getSaleObjects().size());
                    continue;
                }
                result.getSaleObjects().addAll(saleObjectWrapper.getSaleObjects());
                result.setNumberOfSaleObjects(result.getNumberOfSaleObjects() + saleObjectWrapper.getNumberOfSaleObjects());
            }
        }
        return result;
    }
}

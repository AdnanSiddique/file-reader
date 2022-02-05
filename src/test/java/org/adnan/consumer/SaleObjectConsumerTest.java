package org.adnan.consumer;

import org.adnan.model.SaleObjectWrapper;
import org.adnan.processor.SaleObjectDataProcessor;
import org.adnan.reader.SaleObjectFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaleObjectConsumerTest {

    final SaleObjectConsumer saleObjectConsumer = new SaleObjectConsumerImpl();
    SaleObjectConsumer.PriorityOrderAttribute priorityOrderAttribute;

    @Test
    public void testGetPriorityOrderAttribute() {
        SaleObjectConsumer.PriorityOrderAttribute priorityOrderAttribute = saleObjectConsumer.getPriorityOrderAttribute();
        Assertions.assertNotNull(priorityOrderAttribute);
    }

    @Test
    public void testReadSaleObjectFiles() throws Exception {
        SaleObjectWrapper saleObjectWrapper = new SaleObjectFileReader().readSaleObjectFiles();
        Assertions.assertNotNull(saleObjectWrapper);
        Assertions.assertEquals(saleObjectWrapper.getSaleObjects().size(), saleObjectWrapper.getNumberOfSaleObjects());
    }

    @Test
    public void testProcessSaleObjectData() throws Exception {
        SaleObjectWrapper saleObjectWrapper = new SaleObjectDataProcessor().processSaleObjectDataFiles(priorityOrderAttribute);
        Assertions.assertNotNull(saleObjectWrapper);
        Assertions.assertEquals(saleObjectWrapper.getSaleObjects().size(), saleObjectWrapper.getNumberOfSaleObjects());
    }
}
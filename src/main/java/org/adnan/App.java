package org.adnan;

import org.adnan.model.PostalAddress;
import org.adnan.model.SaleObject;
import org.adnan.model.SaleObjectWrapper;
import org.adnan.consumer.SaleObjectConsumer;
import org.adnan.consumer.SaleObjectConsumerImpl;
import org.adnan.processor.SaleObjectDataProcessor;

import java.util.Objects;


public class App  {

    public static void main (String[] args) throws Exception {

        final SaleObjectConsumer saleObjectConsumer = new SaleObjectConsumerImpl();

        // Calling getPriorityOrderAttribute
        SaleObjectConsumer.PriorityOrderAttribute priorityOrderAttribute = saleObjectConsumer.getPriorityOrderAttribute();

        SaleObjectWrapper saleObjectWrapper
                = new SaleObjectDataProcessor().processSaleObjectDataFiles(priorityOrderAttribute);

        // Calling startSaleObjectTransaction
        saleObjectConsumer.startSaleObjectTransaction();

        // Calling reportSaleObject in loop for each record
        for (SaleObject saleObject : saleObjectWrapper.getSaleObjects()) {
            try {
                PostalAddress postalAddress = saleObject.getPostalAddress();
                saleObjectConsumer.reportSaleObject(
                        saleObject.getSizeSqm(),
                        String.valueOf(saleObject.getPricePerSquareMeter()),
                        !Objects.isNull(postalAddress) ? postalAddress.getCity() : "",
                        !Objects.isNull(postalAddress) ? postalAddress.getStreet() : "",
                        !Objects.isNull(postalAddress) && !Objects.isNull(postalAddress.getFloor())
                                ? saleObject.getPostalAddress().getFloor().intValue() : null);
            } catch (SaleObjectConsumer.TechnicalException ex) {
                System.out.println("Error while reporting sale object id : " + saleObject.getId());
            }
        }

        // Calling commitSaleObjectTransaction
        saleObjectConsumer.commitSaleObjectTransaction();
    }
}

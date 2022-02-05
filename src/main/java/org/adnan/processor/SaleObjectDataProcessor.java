package org.adnan.processor;

import org.adnan.model.SaleObject;
import org.adnan.model.SaleObjectWrapper;
import org.adnan.consumer.SaleObjectConsumer;
import org.adnan.reader.SaleObjectFileReader;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SaleObjectDataProcessor {

    Map<SaleObjectConsumer.PriorityOrderAttribute, Comparator<SaleObject>> comparatorMap;

    /**
     * creating comparator for each priority order attribute for sorting
     */
    public SaleObjectDataProcessor() {
        comparatorMap = new HashMap<>();
        comparatorMap.put(SaleObjectConsumer.PriorityOrderAttribute.City, (SaleObject obj1, SaleObject obj2) -> obj2.getPostalAddress().getCity().compareTo(obj1.getPostalAddress().getCity()));
        comparatorMap.put(SaleObjectConsumer.PriorityOrderAttribute.SquareMeters, (SaleObject obj1, SaleObject obj2) -> obj2.getSizeSqm().compareTo(obj1.getSizeSqm()));
        comparatorMap.put(SaleObjectConsumer.PriorityOrderAttribute.PricePerSquareMeter, (SaleObject obj1, SaleObject obj2) -> obj2.getPricePerSquareMeter().compareTo(obj1.getPricePerSquareMeter()));
    }

    /**
     * This method is the main point of contact for fetching sales object data,
     * It takes the PriorityOrderAttribute as an input and produces the SaleObjectWrapper
     * as an output after calculating the price per sqm and also sorting the Sale Order by priority
     */
    public SaleObjectWrapper processSaleObjectDataFiles(SaleObjectConsumer.PriorityOrderAttribute priorityOrderAttribute) throws Exception {
        SaleObjectWrapper saleObjectWrapper = new SaleObjectFileReader().readSaleObjectFiles();

        // calculating sale object price per sqm
        this.calculateSaleObjectPricePerSqm(saleObjectWrapper);

        // sorting sale object
        saleObjectWrapper.getSaleObjects().sort(comparatorMap.get(priorityOrderAttribute));
        return saleObjectWrapper;
    }

    private void calculateSaleObjectPricePerSqm(SaleObjectWrapper saleObjectWrapper) {
        for ( SaleObject saleObject : saleObjectWrapper.getSaleObjects() ) {
            //  Removing '.' from starting price to make it divisible for price per sqm calculation
            saleObject.setStartingPrice(saleObject.getStartingPrice().replaceAll("\\.", ""));

            // calculating price per Sqm
            int pricePerSqm = 0;
            if(saleObject.getSizeSqm() != null && saleObject.getSizeSqm() != 0) {
                 pricePerSqm =
                        new BigDecimal(saleObject.getStartingPrice())
                                .divide(BigDecimal.valueOf(saleObject.getSizeSqm()), 3, RoundingMode.HALF_UP)
                                .multiply(BigDecimal.valueOf(1000)).intValue();
            }
            saleObject.setPricePerSquareMeter(pricePerSqm);
        }
    }
}

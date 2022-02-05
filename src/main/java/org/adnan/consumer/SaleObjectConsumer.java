package org.adnan.consumer;


public interface SaleObjectConsumer {
    /**
     * This method is called to decide how to order the objects before calling reportSaleObject.
     * @return the attribute of which to order by.
     */
    PriorityOrderAttribute getPriorityOrderAttribute();


    /**
     * Must be called BEFORE using the reportSaleObjects()-method.
     */
    void startSaleObjectTransaction();

    /**
     * Called once per SaleObject. This method must be called with objects ordered by the attribute decided by a call to getPriorityOrderAttribute()
     *
     * @param squareMeters The size of the house or apartment in square meters.
     * @param pricePerSquareMeter The price of the house or apartment divided by square meters. The price must always have exactly three decimals and must not contain a decimal separator. So 1USD = 1000, 2075.4USD = 2075400, 1.511USD = 1511 and so on.
     * @param city The city where the house is located.
     * @param street The street where the house is located.
     * @param floor The floor if eligible, otherwise null.
     *  @throws TechnicalException if any problem occurs during the invocation resulting in the object not being reported successfully.
     */
    void reportSaleObject(int squareMeters, String pricePerSquareMeter, String city, String street, Integer floor) throws TechnicalException;

    /**
     * Must be called AFTER reporting SaleObjects.
     */
    void commitSaleObjectTransaction();





    enum PriorityOrderAttribute {
        City,
        SquareMeters,
        PricePerSquareMeter;
    }

    class TechnicalException extends RuntimeException{
    }
}
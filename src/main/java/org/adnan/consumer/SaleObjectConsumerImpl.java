package org.adnan.consumer;
/**
 * This is just a test implementation of SaleObjectConsumer,
 * It should be replaced with actual implementation.
 */
public class SaleObjectConsumerImpl implements SaleObjectConsumer {

    boolean isTranActive = false;

    /**
     * Setting priority as SquareMeters for testing
     * It can be changed according to the actual implementation.
     * */
    @Override
    public PriorityOrderAttribute getPriorityOrderAttribute() {
        System.out.println("Calling getPriorityOrderAttribute...");
        return PriorityOrderAttribute.SquareMeters;
    }

    @Override
    public void startSaleObjectTransaction() {
        System.out.println("Calling startSaleObjectTransaction... \n");
        isTranActive = true;
    }

    @Override
    public void reportSaleObject(int squareMeters, String pricePerSquareMeter, String city, String street, Integer floor) throws TechnicalException {
        try {
            if (!isTranActive) {
                return;
            }

            System.out.println("********** Reporting data using reportSaleObject **********");
            StringBuilder stringBuilder = new StringBuilder("Square Meter : ");
            stringBuilder.append(squareMeters).append("\n");
            stringBuilder.append("Price Per Square : ").append(pricePerSquareMeter).append("\n");
            stringBuilder.append("City : ").append(city).append("\n");
            stringBuilder.append("Street : ").append(street);
            if (floor != null) {
                stringBuilder.append("\n").append("Floor : ").append(floor);
            }
            System.out.println(stringBuilder.toString());
        } catch (Exception ex) {
            throw new TechnicalException();
        }
    }

    @Override
    public void commitSaleObjectTransaction() {
        if(!isTranActive) {
            return;
        }

        System.out.println("\nCalling commitSaleObjectTransaction...");
        isTranActive = false;
    }

}

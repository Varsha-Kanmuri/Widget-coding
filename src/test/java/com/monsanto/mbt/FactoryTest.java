package com.monsanto.mbt;


import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FactoryTest {

    Factory factory;
    List<Widget> widgets;

    @Before
    public void init() {
        factory = new Factory();
        widgets = WidgetUtils.getSampleWidgets();
    }


    @Test
    public void testShipment_Sorted_By_Color(){

        List<Widget> sortedByColor = factory.sortByColor(widgets);
        List<Shipment> shipmentByColor = factory.getFinalShipments(sortedByColor);
        int shipmentSize = shipmentByColor.get(0).getSize();
        assertEquals(10,shipmentSize);

        Shipment firstShipment = shipmentByColor.get(0);

        assertEquals(2, firstShipment.getWidgetsInShipment().get(0).getSerialNumber());
        assertEquals(6, firstShipment.getWidgetsInShipment().get(1).getSerialNumber());
        assertEquals(8, firstShipment.getWidgetsInShipment().get(2).getSerialNumber());
        assertEquals(10, firstShipment.getWidgetsInShipment().get(3).getSerialNumber());
        assertEquals(20, firstShipment.getWidgetsInShipment().get(4).getSerialNumber());
        assertEquals(22, firstShipment.getWidgetsInShipment().get(5).getSerialNumber());
        assertEquals(4, firstShipment.getWidgetsInShipment().get(6).getSerialNumber());
        assertEquals(5, firstShipment.getWidgetsInShipment().get(7).getSerialNumber());
        assertEquals(7, firstShipment.getWidgetsInShipment().get(8).getSerialNumber());
        assertEquals(11, firstShipment.getWidgetsInShipment().get(9).getSerialNumber());

    }

    @Test
    public void testShipment_Sorted_By_Date(){

        List<Widget> sortedByDate = factory.sortByDate(widgets);
        List<Shipment> shipmentByDate = factory.getFinalShipments(sortedByDate);
        int shipmentSize = shipmentByDate.get(0).getSize();
        assertEquals(10,shipmentSize);

        Shipment firstShipment = shipmentByDate.get(0);

        assertEquals(9, firstShipment.getWidgetsInShipment().get(0).getSerialNumber());
        assertEquals(19, firstShipment.getWidgetsInShipment().get(1).getSerialNumber());
        assertEquals(1, firstShipment.getWidgetsInShipment().get(2).getSerialNumber());
        assertEquals(21, firstShipment.getWidgetsInShipment().get(3).getSerialNumber());
        assertEquals(3, firstShipment.getWidgetsInShipment().get(4).getSerialNumber());
        assertEquals(23, firstShipment.getWidgetsInShipment().get(5).getSerialNumber());
        assertEquals(2, firstShipment.getWidgetsInShipment().get(6).getSerialNumber());
        assertEquals(22, firstShipment.getWidgetsInShipment().get(7).getSerialNumber());
        assertEquals(7, firstShipment.getWidgetsInShipment().get(8).getSerialNumber());
        assertEquals(17, firstShipment.getWidgetsInShipment().get(9).getSerialNumber());

    }

    @Test
    public void testShipment_Sorted_By_Color_And_Then_Date(){

        List<Widget> sortedByColorAndDate = factory.sortByColorAndDate(widgets);
        List<Shipment> shipmentByColorAndDate = factory.getFinalShipments(sortedByColorAndDate);
        int shipmentSize = shipmentByColorAndDate.get(0).getSize();
        assertEquals(10,shipmentSize);

        Shipment firstShipment = shipmentByColorAndDate.get(0);

        assertEquals(2, firstShipment.getWidgetsInShipment().get(0).getSerialNumber());
        assertEquals(22, firstShipment.getWidgetsInShipment().get(1).getSerialNumber());
        assertEquals(8, firstShipment.getWidgetsInShipment().get(2).getSerialNumber());
        assertEquals(10, firstShipment.getWidgetsInShipment().get(3).getSerialNumber());
        assertEquals(6, firstShipment.getWidgetsInShipment().get(4).getSerialNumber());
        assertEquals(20, firstShipment.getWidgetsInShipment().get(5).getSerialNumber());
        assertEquals(7, firstShipment.getWidgetsInShipment().get(6).getSerialNumber());
        assertEquals(4, firstShipment.getWidgetsInShipment().get(7).getSerialNumber());
        assertEquals(14, firstShipment.getWidgetsInShipment().get(8).getSerialNumber());
        assertEquals(18, firstShipment.getWidgetsInShipment().get(9).getSerialNumber());

    }

    @Test
    public void testShipment_Sorted_By_Date_And_Then_Color(){

        List<Widget> sortedByDateAndColor = factory.sortByDateAndColor(widgets);
        List<Shipment> shipmentByDateAndColor = factory.getFinalShipments(sortedByDateAndColor);
        int shipmentSize = shipmentByDateAndColor.get(0).getSize();
        assertEquals(10,shipmentSize);

        Shipment firstShipment = shipmentByDateAndColor.get(0);
       //We see order remains same as sorting by date since all dates present in sample widgetsUtils class are unique
        assertEquals(9, firstShipment.getWidgetsInShipment().get(0).getSerialNumber());
        assertEquals(19, firstShipment.getWidgetsInShipment().get(1).getSerialNumber());
        assertEquals(1, firstShipment.getWidgetsInShipment().get(2).getSerialNumber());
        assertEquals(21, firstShipment.getWidgetsInShipment().get(3).getSerialNumber());
        assertEquals(3, firstShipment.getWidgetsInShipment().get(4).getSerialNumber());
        assertEquals(23, firstShipment.getWidgetsInShipment().get(5).getSerialNumber());
        assertEquals(2, firstShipment.getWidgetsInShipment().get(6).getSerialNumber());
        assertEquals(22, firstShipment.getWidgetsInShipment().get(7).getSerialNumber());
        assertEquals(7, firstShipment.getWidgetsInShipment().get(8).getSerialNumber());
        assertEquals(17, firstShipment.getWidgetsInShipment().get(9).getSerialNumber());

    }


    @Test
    public void testShipment_Sorted_By_Color_Or_Date_With_Size_Less_Than_Ten() {

        List<Widget> sortedByColor = factory.sortByDate(widgets);
        List<Shipment> shipmentByDate = factory.getFinalShipments(sortedByColor);
        int shipmentSize = shipmentByDate.get(2).getSize();
        assertEquals(5,shipmentSize);

        Shipment thirdShipment = shipmentByDate.get(2);

        assertEquals(13, thirdShipment.getWidgetsInShipment().get(0).getSerialNumber());
        assertEquals(11, thirdShipment.getWidgetsInShipment().get(1).getSerialNumber());
        assertEquals(16, thirdShipment.getWidgetsInShipment().get(2).getSerialNumber());
        assertEquals(6, thirdShipment.getWidgetsInShipment().get(3).getSerialNumber());
        assertEquals(20, thirdShipment.getWidgetsInShipment().get(4).getSerialNumber());

    }

    @Test
    public void testShipmentSize_Less_Than_Ten_And_Greater_Than_Zero(){

        List<Widget> sortedByColor = factory.sortByColor(widgets);
        List<Shipment> shipmentByColor = factory.getFinalShipments(sortedByColor);
        int shipmentSize = shipmentByColor.get(0).getSize();
        assertTrue( 0 < shipmentSize &&  shipmentSize <= 10);
    }

    @Test
    public void testTotal_Number_Of_Shipments(){

        List<Widget> sortedByColor = factory.sortByColor(widgets);
        List<Shipment> shipmentByColor = factory.getFinalShipments(sortedByColor);
        int expectedShipmentsCount = widgets.size()/10;
        assertTrue((expectedShipmentsCount == shipmentByColor.size()) || ((expectedShipmentsCount + 1) == shipmentByColor.size()));

    }
}

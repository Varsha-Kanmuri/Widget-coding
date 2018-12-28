package com.monsanto.mbt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Factory {

    static final int SHIPMENT_CONTAINER_SIZE = 10;

    public static void main(String args[]) {


        Factory factory = new Factory();
        List<Widget> widgetsList = WidgetUtils.getSampleWidgets();

        if(widgetsList.size() > 0) {
            System.out.println("Enter your choice to create shipment 1 -> Color or 2 -> Date : or 3 -> Color and then Date or 4 -> Date and then Color");
            Scanner scanner =  new Scanner(System.in);
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        List<Widget> sortedByColor = factory.sortByColor(widgetsList);
                        List<Shipment> shipmentByColor = factory.getFinalShipments(sortedByColor);
                        factory.printShipmentsList(shipmentByColor);
                        break;

                    case 2:
                        List<Widget> sortedByDate = factory.sortByDate(widgetsList);
                        List<Shipment> shipmentByDate = factory.getFinalShipments(sortedByDate);
                        factory.printShipmentsList(shipmentByDate);
                        break;

                    case 3:
                        List<Widget> sortedByColorAndDate = factory.sortByColorAndDate(widgetsList);
                        List<Shipment> shipmentByColorAndDate = factory.getFinalShipments(sortedByColorAndDate);
                        factory.printShipmentsList(shipmentByColorAndDate);
                        break;

                    case 4:
                        List<Widget> sortedByDateAndColor = factory.sortByDateAndColor(widgetsList);
                        List<Shipment> shipmentByDateAndColor = factory.getFinalShipments(sortedByDateAndColor);
                        factory.printShipmentsList(shipmentByDateAndColor);
                        break;

                    default:
                        System.out.println("Please enter a valid choice 1 or 2");
                }
            } catch (Exception e) {
                System.out.println("Please recheck your choice.Pick 1 or 2");
            }
        }
        else {
            System.out.println("No widgets manufactured !!");
        }
    }

    public List<Widget> sortByColor(List<Widget> widgetsList) {

        widgetsList.sort(Comparator.comparing(Widget::getColor));
        return widgetsList;
    }

    public List<Widget> sortByDate(List<Widget> widgetsList) {

        widgetsList.sort(Comparator.comparing(Widget::getProductionDate));
        return widgetsList;
    }

    public List<Widget> sortByColorAndDate(List<Widget> widgetsList) {
        widgetsList.sort(Comparator.comparing(Widget::getColor).thenComparing(Widget::getProductionDate));
        return widgetsList;
    }

    public List<Widget> sortByDateAndColor(List<Widget> widgetsList) {

        widgetsList.sort(Comparator.comparing(Widget::getProductionDate).thenComparing(Widget::getColor));
        return widgetsList;
    }

    public List<Shipment> getFinalShipments(List<Widget> widgetList){

        List<Shipment> shipmentsList = new ArrayList<Shipment>();
        int totalWidgets = widgetList.size();
        int sizeTenShipments = totalWidgets/SHIPMENT_CONTAINER_SIZE;
        int remainingWidgets = totalWidgets%SHIPMENT_CONTAINER_SIZE;
        int startIndex = 0 ,endIndex = SHIPMENT_CONTAINER_SIZE;
        while(sizeTenShipments >= 1) {

            Shipment shipment = new Shipment(shipmentsList.size()+1,SHIPMENT_CONTAINER_SIZE,widgetList.subList(startIndex,endIndex));
            shipmentsList.add(shipment);
            startIndex+=SHIPMENT_CONTAINER_SIZE;
            endIndex+=SHIPMENT_CONTAINER_SIZE;
            sizeTenShipments--;
        }

        if(sizeTenShipments < 1 && remainingWidgets >0){

            endIndex = startIndex + remainingWidgets ;
            Shipment shipment = new Shipment(shipmentsList.size()+1,remainingWidgets,widgetList.subList(startIndex,endIndex));
            shipmentsList.add(shipment);
            return shipmentsList;
        }
        return shipmentsList;
    }

    public void printShipmentsList(List<Shipment> shipments){

        for(Shipment shipment: shipments){
            System.out.println("Shipment "+ shipment.getSerialNumber()+ " has " + shipment.getSize() +" widgets with IDs :");
            for(Widget widget : shipment.getWidgetsInShipment()) {
                System.out.print(widget.getSerialNumber()+"\t");
            }
            System.out.println();
        }
    }
}

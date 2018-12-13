package com.monsanto.mbt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Factory {

    public static void main(String args[]) {

        Factory factory = new Factory();
        List<Widget> widgetsList = WidgetUtils.getSampleWidgets();

        if(widgetsList.size() > 0) {
            System.out.println("Enter your choice to create shipment 1 -> Color or 2 -> Date :");
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

    public List<Shipment> getFinalShipments(List<Widget> widgetList){

        List<Shipment> shipmentsList = new ArrayList<Shipment>();
        int totalWidgets = widgetList.size();
        int sizeTenShipments = totalWidgets/10;
        int remainingWidgets = totalWidgets%10;
        int startIndex = 0 ,endIndex = 10;
        while(sizeTenShipments >= 1) {

            Shipment shipment = new Shipment(shipmentsList.size()+1,10,widgetList.subList(startIndex,endIndex));
            shipmentsList.add(shipment);
            startIndex+=10;
            endIndex+=10;
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

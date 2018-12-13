package com.monsanto.mbt;

import java.util.List;

public class Shipment {

    private int serialNumber;
    private int size;
    private List<Widget> shipmentContainer;

    public Shipment(int serialNumber, int size, List<Widget> shipmentContainer) {
        this.serialNumber = serialNumber;
        this.size = size;
        this.shipmentContainer = shipmentContainer;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Widget> getWidgetsInShipment() {
        return shipmentContainer;
    }

    public void setWidgetsInShipment(List<Widget> shipmentContainer) {
        this.shipmentContainer = shipmentContainer;
    }

}
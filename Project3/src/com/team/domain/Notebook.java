package com.team.domain;

public class Notebook implements  Equipment{

    private String modal;
    private double price;

    public Notebook(String modal, double price) {
        this.modal = modal;
        this.price = price;
    }

    public String getModal() {

        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Notebook() {
    }

    @Override
    public String getDescription() {
        return modal + "(" + price+ ")";
    }
}

public class Item {
    private String id;
    private String name;
    private double unitPrice;

    public Item(String id, String name, double unitPrice) {
        setId(id);
        setName(name);
        setUnitPrice(unitPrice);
    }

    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (! (obj instanceof Item))
            return false;

        Item itObj = (Item) obj;
        return this.getId().equals(itObj.getId());
    }
}

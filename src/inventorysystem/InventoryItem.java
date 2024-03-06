package inventorysystem;

public class InventoryItem {
    public String category;
    public String itemName;
    public double unitPrice;
    public int quantity;
    public String inOut;
    public String dateImportedExported;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDateImportedExported(String dateImportedExported) {
        this.dateImportedExported = dateImportedExported;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "category='" + category + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", inOut='" + inOut + '\'' +
                ", dateImportedExported='" + dateImportedExported + '\'' +
                '}';
    }
}


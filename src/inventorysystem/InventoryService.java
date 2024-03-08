package inventorysystem;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class InventoryService {
    
    public int quantity;
       
    
        
    private final List<InventoryItem> inventoryItems;

    public InventoryService() {
        this.inventoryItems = new ArrayList<>();
    }

    public void createItem(InventoryItem newItem) {
        inventoryItems.add(newItem);
        // Add logic to persist the item to a database or file if needed
        insertItemIntoDatabase(newItem); // Insert the new item into the database

    }

    public List<InventoryItem> getItems() {
        return new ArrayList<>(inventoryItems);
    }

    public boolean updateItem(InventoryItem updatedItem) {
        int index = inventoryItems.indexOf(updatedItem);
        if (index != -1) {
            inventoryItems.set(index, updatedItem);
            return true;
        }
        return false;
    }

    public boolean deleteItem(String itemName) {
        InventoryItem itemToDelete = getItemByName(itemName);
        if (itemToDelete != null) {
            inventoryItems.remove(itemToDelete);
            return true;
        }
        return false;
    }

    InventoryItem getItemByName(String itemName) {
        for (InventoryItem item : inventoryItems) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    
    
    private void insertItemIntoDatabase(InventoryItem item) {
        try (Connection conn = new InventorySystem().getConnection()) {
            String sqlQuery = "INSERT INTO tbl_items (fld_item_name, fld_quantity, fld_unit_price, fld_category) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
                stmt.setString(1, item.itemName);
                stmt.setInt(2, item.quantity);
                stmt.setDouble(3, item.unitPrice);
                stmt.setString(4, item.category);
                stmt.executeUpdate();
            }
            
            String getItemId = "SELECT fld_item_id FROM tbl_items WHERE fld_item_name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(getItemId)) {
                stmt.setString(1, item.itemName); // Set the value for the placeholder
                // Execute the query and retrieve the item ID
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int itemId = rs.getInt("fld_item_id");
                        String transactionQuery = "INSERT INTO tbl_transactions (fld_TRitem_id, fld_transaction_type, fld_TRquantity) VALUES (?, ?, ?)";
                        try (PreparedStatement query = conn.prepareStatement(transactionQuery)) {
                            query.setInt(1, itemId);
                            query.setString(2, item.inOut);
                            query.setInt(3, item.quantity);
                            query.executeUpdate();
                         } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


package atmin.b5;

import java.util.List;

public class Combo {
    private String comboName;
    private List<String> itemList; // Danh sách món được chọn từ checkbox
    private String bannerUrl;

    public Combo() {}

    // Getters and Setters
    public String getComboName() { return comboName; }
    public void setComboName(String comboName) { this.comboName = comboName; }
    public List<String> getItemList() { return itemList; }
    public void setItemList(List<String> itemList) { this.itemList = itemList; }
    public String getBannerUrl() { return bannerUrl; }
    public void setBannerUrl(String bannerUrl) { this.bannerUrl = bannerUrl; }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.Date;

public class Sales {
    private String storId;
    private String ordNum;
    private Date ordDate;
    private int qty;
    private String payterms;
    private String titleId;

    // Constructor
    public Sales(String storId, String ordNum, Date ordDate, int qty, String payterms, String titleId) {
        this.storId = storId;
        this.ordNum = ordNum;
        this.ordDate = ordDate;
        this.qty = qty;
        this.payterms = payterms;
        this.titleId = titleId;
    }

    // Getters and Setters
    public String getStorId() {
        return storId;
    }

    public void setStorId(String storId) {
        this.storId = storId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Date getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPayterms() {
        return payterms;
    }

    public void setPayterms(String payterms) {
        this.payterms = payterms;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }
}


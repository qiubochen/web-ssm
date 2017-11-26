package com.heitian.ssm.model;

public class ShoppingCart {
    int userId;
    int bookId;
    int cost;
    int status;
    int bookAccount;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBookAccount() {
        return bookAccount;
    }

    public void setBookAccount(int bookAccount) {
        this.bookAccount = bookAccount;
    }
}

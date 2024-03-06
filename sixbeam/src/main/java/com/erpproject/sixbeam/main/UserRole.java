package com.erpproject.sixbeam.main;

public enum UserRole {
    HR("인사"),
    PRODUCTION("생산"),
    INVENTORY("재고"),
    SALES("영업"),
    PURCHASE("구매"),
    ACCOUNTING("회계");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

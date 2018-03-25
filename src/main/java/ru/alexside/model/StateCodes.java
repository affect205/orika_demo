package ru.alexside.model;

/**
 * Created by Alex on 25.03.2018.
 */
public enum StateCodes {
    GREEN_PO_CANCELLED,
    RED_PO_CANCELLED,
    GREEN_PO_NEW,
    RED_PO_NEW,
    GREEN_PO_CARRIER_SEARCH,
    GREEN_PO_CARRIERS_FOUND,
    RED_PO_OFFER,
    RED_PO_APPROVED,
    GREEN_PO_DELIVERED,
    GRAY_PO_NEW,
    GRAY_PO_ON_BROKER,
    GRAY_PO_WAIT_FOR_ACCEPT,
    RED_PO_ON_BROKER,
    RED_PO_WAIT_FOR_ACCEPT,
    GREEN_PO_ACCEPTED,
    DEP_DEP_NEW,
    TRAVEL_TIME_TT_NEW,
    GREEN_PO_EARLY_LOAD
}
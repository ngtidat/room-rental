package com.javaweb.room_rental.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),
    INVALID_KEY(9998, "Invalid key"),
    DEVICE_NOT_EXISTED(1001, "The device is not existed"),
    NAME_DEVICE_INVALID(1002, "The device's name cannot be empty"),
    UNIT_DEVICE_INVALID(1002, "The device's unit cannot be empty"),
    DESC_DEVICE_INVALID(1002, "The device's description cannot be empty"),
    IMAGE_DEVICE_INVALID(1002, "The device's image cannot be empty"),
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

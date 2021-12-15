package com.cdec.validator.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    USER_ALREADY_EXISTS("user-already-exists", "User already exists", HttpStatus.BAD_REQUEST),
    USER_IS_NOT_VERIFIED("user-is-not-verified", "User is not verified", HttpStatus.BAD_REQUEST),
    USER_DOES_NOT_EXIST("user-does-not-exist", "User does not exist", HttpStatus.BAD_REQUEST),
    EMAIL_PASSWORD_INCORRECT("incorrect-user-pass", "Incorrect email or password", HttpStatus.BAD_REQUEST),
    USERNAME_DOES_NOT_EXIST("user-does-not-exist", "User does not exist", HttpStatus.BAD_REQUEST),
    OTP_DOES_NOT_EXIST("otp-does-not-exist", "Otp does not exist", HttpStatus.BAD_REQUEST),
    OTP_EXPIRED("otp-expired", "Otp has expired", HttpStatus.BAD_REQUEST),
    NO_OTP("no-otp", "No otp exists", HttpStatus.INTERNAL_SERVER_ERROR),
    NO_CLIENT_EXISTS("no-client-exists", "No such client exists", HttpStatus.BAD_REQUEST),
    COULD_NOT_SEND_OTP("could-not-send-otp", "Could not send Otp", HttpStatus.BAD_REQUEST),
    BILL_NOT_UPDATED("bill-not-updated", "Bill cannot be updated", HttpStatus.BAD_REQUEST),
    BILL_EXISTS("bill-already-exists","Bill already exists",HttpStatus.BAD_REQUEST),
    BILL_NOT_EXIST("bill-not-exist", "Bill does not exist", HttpStatus.BAD_REQUEST),
    COULD_NOT_CALL("could-not-call", "Could not call", HttpStatus.INTERNAL_SERVER_ERROR),
    INCORRECT_OTP("incorrect-otp", "Otp is incorrect", HttpStatus.BAD_REQUEST),
    USER_DOES_NOT_HAVE_ACCESS("user-does-not-have-access", "User does not have access", HttpStatus.BAD_REQUEST),
    REMOTE_DEVICE_AUTH_FAILED("remote-device-auth-failed", "Remote service could not be authenticated", HttpStatus.INTERNAL_SERVER_ERROR),
    REMOTE_DEVICE_CONNECT_FAILED("remote-device-connect-failed", "Remote service could not be connected", HttpStatus.INTERNAL_SERVER_ERROR),
    INCOMING_STATUS_UPDATE_FAILED("incoming-status-update-failed", "Incoming status update failed", HttpStatus.INTERNAL_SERVER_ERROR),
    PUBLISH_CREDENTIALS_ACQUISITION_FAILED("publish-credentials-failed", "Acquiring publish credentials failed", HttpStatus.INTERNAL_SERVER_ERROR);


    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

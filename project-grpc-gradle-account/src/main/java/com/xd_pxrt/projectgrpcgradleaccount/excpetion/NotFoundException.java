package com.xd_pxrt.projectgrpcgradleaccount.excpetion;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

}

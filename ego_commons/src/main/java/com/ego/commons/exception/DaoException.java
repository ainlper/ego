package com.ego.commons.exception;

/**
 * 数据库操作异常
 */
public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}

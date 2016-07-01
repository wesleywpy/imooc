package com.imooc.study.exception;

/**
 * 秒杀关闭异常
 * Created by Wesley on 2016/5/21.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}

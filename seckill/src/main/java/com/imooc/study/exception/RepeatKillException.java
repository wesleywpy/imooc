package com.imooc.study.exception;

/**
 * 重复秒杀
 * Created by Wesley on 2016/5/21.
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}

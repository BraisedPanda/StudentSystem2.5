package com.braisedpanda.shirotest.utils;

public interface ResultType {

    /**
     *
     * getResultCode(取得返回结果值)
     *
     * @return 返回结果值
     */
    public int getResultCode();

    /**
     *
     * getResultMsg(取得返回结果消息内容)
     *
     * @return 返回结果消息内容
     */
    public String getResultMsg();

    /**
     *
     * <b>类 名：</b>SimpleResultType<br/>
     * <b>类描述：</b>简单的返回结果定义（0:成功；-1:操作失败）<br/>
     * @version 1.0<br/>
     *
     */
    public static enum SimpleResultType implements ResultType {
        /**
         * 成功
         */
        SUCCESS(0, "成功"),
        /**
         * 操作失败
         */
        ERROR(-1, "操作失败");
        // 返回结果值
        private int resultCode;
        // 返回结果消息内容
        private String resultMsg;


        /**
         *
         * 创建一个新的实例 SimpleResultType.
         *
         * @param resultCode
         *            返回结果值
         * @param resultMsg
         *            返回结果消息内容
         */
        SimpleResultType(int resultCode, String resultMsg) {
            this.resultCode = resultCode;
            this.resultMsg = resultMsg;
        }


        @Override
        public int getResultCode() {
            return this.resultCode;
        }


        @Override
        public String getResultMsg() {
            return this.resultMsg;
        }
    }
}

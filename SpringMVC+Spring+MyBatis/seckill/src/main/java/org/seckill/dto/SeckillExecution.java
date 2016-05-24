package org.seckill.dto;

import org.seckill.entity.SuccessKilled;

/**��װ��ɱִ�к���
 * Created by Administrator on 2016/5/24.
 */
public class SeckillExecution {

    private int seckillId;

    //��ɱִ�н��״̬
    private int state;

    //״̬��ʾ
    private String stateInfo;

    //��ɱ�ɹ�����
    private SuccessKilled successKilled;

    //��ɱ�ɹ�
    public SeckillExecution(int seckillId, int state, String stateInfo, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.successKilled = successKilled;
    }

    //��ɱʧ��
    public SeckillExecution(int seckillId, String stateInfo, int state) {
        this.seckillId = seckillId;
        this.stateInfo = stateInfo;
        this.state = state;
    }

    public int getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(int seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
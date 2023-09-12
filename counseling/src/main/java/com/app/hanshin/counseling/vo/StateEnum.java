package com.app.hanshin.counseling.vo;

public enum StateEnum {
    SUCCESS(UpdateState.SUCCESS),
    FAIL(UpdateState.FAIL);

    private final Integer state;

    StateEnum(Integer updateState){
        this.state = updateState;
    }

    public Integer getState(){
        return this.state;
    }

    public static class UpdateState{
        public static final Integer SUCCESS = 1;
        public static final Integer FAIL = 0;
    }

    public static StateEnum toStateEnum(Integer currentState){
        return currentState.equals(UpdateState.FAIL) ? FAIL : SUCCESS;
    }
}

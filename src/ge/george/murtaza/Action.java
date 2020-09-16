package ge.george.murtaza;

import java.util.Objects;

public class Action {
    private int roomNum;
    private EnteranceAction action;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action1 = (Action) o;
        return action == action1.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNum, action);
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public void setAction(EnteranceAction action) {
        this.action = action;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public EnteranceAction getAction() {
        return action;
    }

    public Action(int roomNum, EnteranceAction action) {
        this.roomNum = roomNum;
        this.action = action;
    }

    public Action(EnteranceAction action) {
        this.action = action;
    }
    public Action(){

    }

    public Action(int roomNum) {
        this.roomNum = roomNum;
    }

    @Override
    public String toString() {
        return "Action{" +
                "roomNum=" + roomNum +
                ", action=" + action +
                '}';
    }
}

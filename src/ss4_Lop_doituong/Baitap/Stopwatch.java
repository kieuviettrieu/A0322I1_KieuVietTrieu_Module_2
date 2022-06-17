package ss4_Lop_doituong.Baitap;

import java.util.Date;

public class Stopwatch {
    private Date startTime, endTime;

    public Stopwatch() {
        startTime=new Date();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void  start()
    {
        startTime=new Date();
    }

    public void stop()
    {
        endTime=new Date();
    }

    public long getElapsedTime()
    {
        long time1=((startTime.getHours()*60+startTime.getMinutes())*60+startTime.getSeconds())*1000;
        long time2=((endTime.getHours()*60+endTime.getMinutes())*60+endTime.getSeconds())*1000;
        return time2-time1;
    }
}

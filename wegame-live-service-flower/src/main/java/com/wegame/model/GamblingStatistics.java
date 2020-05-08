package com.wegame.model;

public class GamblingStatistics {
    private String id;

    private String createdate;

    private String lastmodifiedtime;

    private Long version;

    private String endtime;

    private Integer integral;

    private Integer roomserial;

    private Integer seatserial;

    private String starttime;

    private Integer usercode;

    private String gambling;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getLastmodifiedtime() {
        return lastmodifiedtime;
    }

    public void setLastmodifiedtime(String lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime == null ? null : lastmodifiedtime.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getRoomserial() {
        return roomserial;
    }

    public void setRoomserial(Integer roomserial) {
        this.roomserial = roomserial;
    }

    public Integer getSeatserial() {
        return seatserial;
    }

    public void setSeatserial(Integer seatserial) {
        this.seatserial = seatserial;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public Integer getUsercode() {
        return usercode;
    }

    public void setUsercode(Integer usercode) {
        this.usercode = usercode;
    }

    public String getGambling() {
        return gambling;
    }

    public void setGambling(String gambling) {
        this.gambling = gambling == null ? null : gambling.trim();
    }
}
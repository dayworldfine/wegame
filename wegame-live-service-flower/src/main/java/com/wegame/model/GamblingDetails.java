package com.wegame.model;

public class GamblingDetails {
    private String id;

    private String createdate;

    private String lastmodifiedtime;

    private Long version;

    private String compareuser;

    private Integer dotype;

    private Integer operatingleverage;

    private Integer round;

    private Integer seatserial;

    private Integer usercode;

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

    public String getCompareuser() {
        return compareuser;
    }

    public void setCompareuser(String compareuser) {
        this.compareuser = compareuser == null ? null : compareuser.trim();
    }

    public Integer getDotype() {
        return dotype;
    }

    public void setDotype(Integer dotype) {
        this.dotype = dotype;
    }

    public Integer getOperatingleverage() {
        return operatingleverage;
    }

    public void setOperatingleverage(Integer operatingleverage) {
        this.operatingleverage = operatingleverage;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getSeatserial() {
        return seatserial;
    }

    public void setSeatserial(Integer seatserial) {
        this.seatserial = seatserial;
    }

    public Integer getUsercode() {
        return usercode;
    }

    public void setUsercode(Integer usercode) {
        this.usercode = usercode;
    }
}
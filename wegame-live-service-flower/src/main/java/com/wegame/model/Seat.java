package com.wegame.model;

public class Seat {
    private String id;

    private String createdate;

    private String lastmodifiedtime;

    private Long version;

    private Integer serial;

    private Integer status;

    private String roomid;

    private Integer usercode;

    private Integer seecard;

    private Integer boarda;

    private Integer boardb;

    private Integer boardc;

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

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public Integer getUsercode() {
        return usercode;
    }

    public void setUsercode(Integer usercode) {
        this.usercode = usercode;
    }

    public Integer getSeecard() {
        return seecard;
    }

    public void setSeecard(Integer seecard) {
        this.seecard = seecard;
    }

    public Integer getBoarda() {
        return boarda;
    }

    public void setBoarda(Integer boarda) {
        this.boarda = boarda;
    }

    public Integer getBoardb() {
        return boardb;
    }

    public void setBoardb(Integer boardb) {
        this.boardb = boardb;
    }

    public Integer getBoardc() {
        return boardc;
    }

    public void setBoardc(Integer boardc) {
        this.boardc = boardc;
    }
}
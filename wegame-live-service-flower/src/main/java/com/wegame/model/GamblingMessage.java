package com.wegame.model;

public class GamblingMessage {
    private String id;

    private String createdate;

    private String lastmodifiedtime;

    private Long version;

    private String board;

    private Integer ending;

    private Integer seatserial;

    private Integer seecard;

    private Integer usercode;

    private String gamblingid;

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

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board == null ? null : board.trim();
    }

    public Integer getEnding() {
        return ending;
    }

    public void setEnding(Integer ending) {
        this.ending = ending;
    }

    public Integer getSeatserial() {
        return seatserial;
    }

    public void setSeatserial(Integer seatserial) {
        this.seatserial = seatserial;
    }

    public Integer getSeecard() {
        return seecard;
    }

    public void setSeecard(Integer seecard) {
        this.seecard = seecard;
    }

    public Integer getUsercode() {
        return usercode;
    }

    public void setUsercode(Integer usercode) {
        this.usercode = usercode;
    }

    public String getGamblingid() {
        return gamblingid;
    }

    public void setGamblingid(String gamblingid) {
        this.gamblingid = gamblingid == null ? null : gamblingid.trim();
    }
}
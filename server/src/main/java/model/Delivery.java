package model;

public class Delivery {
    private String sname = null;
    private String saddress = null;
    private String smobile = null;
    private String rname = null;
    private String raddress = null;
    private String rmobile = null;
    private String type = null;
    private String courier_id = null;
    private String express_num = null;

    public void setType(String type) {
        this.type = type;
    }

    public void setCourier_id(String courier_id) {
        this.courier_id = courier_id;
    }

    public String getType() {
        return type;
    }

    public String getCourier_id() {
        return courier_id;
    }

    public String getExpress_num() {
        return express_num;
    }

    public String getRaddress() {
        return raddress;
    }

    public String getRmobile() {
        return rmobile;
    }

    public String getRname() {
        return rname;
    }

    public String getSaddress() {
        return saddress;
    }

    public String getSmobile() {
        return smobile;
    }

    public String getSname() {
        return sname;
    }

    public void setExpress_num(String express_num) {
        this.express_num = express_num;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public void setRmobile(String rmobile) {
        this.rmobile = rmobile;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public void setSmobile(String smobile) {
        this.smobile = smobile;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }


}

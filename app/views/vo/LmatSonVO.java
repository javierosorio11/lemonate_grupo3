package views.vo;

public class LmatSonVO {
    private String code;
    private double totalInStore;
    private Long totalComing;
    private Long totalRequred;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getTotalInStore() {
        return totalInStore;
    }

    public void setTotalInStore(double totalInStore) {
        this.totalInStore = totalInStore;
    }

    public Long getTotalComing() {
        return totalComing;
    }

    public void setTotalComing(Long totalComing) {
        this.totalComing = totalComing;
    }

    public Long getTotalRequred() {
        return totalRequred;
    }

    public void setTotalRequred(Long totalRequred) {
        this.totalRequred = totalRequred;
    }
}

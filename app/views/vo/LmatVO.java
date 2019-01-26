package views.vo;

import java.util.ArrayList;
import java.util.List;

public class LmatVO {
    public LmatVO(){
        sonVOList=new ArrayList<>();
    }
    private String code;
    private String name;
    private List<LmatSonVO> sonVOList;
    private Double totalAviable;
    private String imgRoute;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<LmatSonVO> getSonVOList() {
        return sonVOList;
    }

    public void setSonVOList(List<LmatSonVO> sonVOList) {
        this.sonVOList = sonVOList;
    }


    public void addSon(LmatSonVO sonVOList) {
        this.sonVOList.add(sonVOList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgRoute() {
        return imgRoute;
    }

    public void setImgRoute(String imgRoute) {
        this.imgRoute = imgRoute;
    }

    public Double getTotalAviable() {
        return totalAviable;
    }

    public void setTotalAviable(Double totalAviable) {
        this.totalAviable = totalAviable;
    }
}

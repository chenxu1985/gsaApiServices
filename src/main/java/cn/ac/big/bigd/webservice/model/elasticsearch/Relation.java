package cn.ac.big.bigd.webservice.model.elasticsearch;

/**
 * Created by chenx on 2023-1-9.
 */
public class Relation {
    private String name;
    private String parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}

package Evolution.utils.pojos.products;

public class Nav {
    private int pageNomer;

    private int pageSize;

    private int recordCount;

    public void setPageNomer(int pageNomer) {
        this.pageNomer = pageNomer;
    }

    public int getPageNomer() {
        return this.pageNomer;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getRecordCount() {
        return this.recordCount;
    }
}

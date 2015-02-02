import com.gigaspaces.annotation.pojo.CompoundSpaceIndex;
import com.gigaspaces.annotation.pojo.CompoundSpaceIndexes;
import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.math.BigDecimal;
import java.io.Serializable;

@CompoundSpaceIndexes({ @CompoundSpaceIndex(paths = {"info", "info2"})})
@SpaceClass
public class SmallMessageCompoundIndex implements Serializable {
  static final long serialVersionUID = 162512L;

  private Integer id;
  private String info;
  private String info2;
  private BigDecimal price;

  public SmallMessageCompoundIndex() {}

  public SmallMessageCompoundIndex(Integer id, String info, String info2, BigDecimal price) {
    this.id = id;
    this.info = info;
    this.info2 = info2;
    this.price = price;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @SpaceRouting
  @SpaceId
  public Integer getId() {
    return id;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String toString() {
    return "SmallMessageCompoundIndex[" + id + ", " + info + ", " + price + "]";
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo2() {
    return info2;
  }

  public void setInfo2(String info2) {
    this.info2 = info2;
  }
}
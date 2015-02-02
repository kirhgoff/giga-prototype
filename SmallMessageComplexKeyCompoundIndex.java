import com.gigaspaces.annotation.pojo.CompoundSpaceIndex;
import com.gigaspaces.annotation.pojo.CompoundSpaceIndexes;
import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.io.Serializable;
import java.math.BigDecimal;

@CompoundSpaceIndexes({ @CompoundSpaceIndex(paths = {"info", "info2", "price"})})
@SpaceClass
public class SmallMessageComplexKeyCompoundIndex implements Serializable {
  static final long serialVersionUID = 162512L;

  private String id;
  private Integer amount;
  private String info;
  private String info2;
  private BigDecimal price;

  public SmallMessageComplexKeyCompoundIndex() {}
  public SmallMessageComplexKeyCompoundIndex(String id) {
    this.id = id;
  }

  public SmallMessageComplexKeyCompoundIndex(Integer amount, String info, String info2, BigDecimal price) {
    this (createId(amount, info, info2, price));
    this.amount = amount;
    this.info = info;
    this.info2 = info2;
    this.price = price;
  }

  public static String createId(Integer amount, String info, String info2, BigDecimal price) {
    return amount + "_" + info + "_" + info2 + "_" + price;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @SpaceRouting
  @SpaceId
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getAmount() {
    return amount;
  }

  @SpaceIndex(type= SpaceIndexType.BASIC)
  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @SpaceIndex(type= SpaceIndexType.BASIC)
  public String getInfo2() {
    return info2;
  }

  public void setInfo2(String info) {
    this.info2 = info2;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String toString() {
    return "SmallMessageCompexKey[" + amount + ", " + info + ", " + price + "]";
  }
}

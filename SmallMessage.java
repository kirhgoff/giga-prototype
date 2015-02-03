import com.gigaspaces.annotation.pojo.CompoundSpaceIndex;
import com.gigaspaces.annotation.pojo.CompoundSpaceIndexes;
import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.io.Serializable;
import java.math.BigDecimal;

@CompoundSpaceIndexes({ @CompoundSpaceIndex(paths = {"info", "info2", "price2"})})
@SpaceClass
public class SmallMessage implements Serializable {
  static final long serialVersionUID = 162512L;

  private String id;
  private Integer amount;
  private String info;
  private String info2;
  private BigDecimal price;
  private BigDecimal price2;

  public SmallMessage() {}
  public SmallMessage(String id) {
    this.id = id;
  }

  public SmallMessage(Integer amount, String info, BigDecimal price) {
    this (createId(amount, info, price));
    this.amount = amount;
    this.info = info;
    this.price = price;
  }

  public static String createId(Integer amount, String info, BigDecimal price) {
    return amount + "_" + info + "_" + price;
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

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice2() {
    return price2;
  }

  public void setPrice2(BigDecimal price2) {
    this.price2 = price2;
  }
}

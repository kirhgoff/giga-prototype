import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.io.Serializable;
import java.math.BigDecimal;

@SpaceClass
public class SmallMessageCompexKey implements Serializable {
  static final long serialVersionUID = 162512L;

  private String id;
  private Integer amount;
  private String info;
  private BigDecimal price;

  public SmallMessageCompexKey() {}
  public SmallMessageCompexKey(String id) {
    this.id = id;
  }

  public SmallMessageCompexKey(Integer amount, String info, BigDecimal price) {
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